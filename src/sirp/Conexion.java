package sirp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion{
    private String user;            // Usuario de Mysql
    private String password;        // Contraseña de Mysql
    private String host;            // Direccion del Servidor
    private String url;             // Direccion del Driver más el host del Servidor
    private Connection conn = null; // Conexion que se establecerá
    private Statement stm;          // manejado para hacer las consultas

    // Constructor de la Clase, Recibe parametros para realizar la Conexion
    // luego la conexion se realiza llamando al metodo conectar automáticamente
    public Conexion(String usuario, String contraseña, String servidor){
        this.user = usuario;
        this.password = contraseña;
        this.host = servidor;
        this.url = "jdbc:mysql://" + this.host + "/" ;
        conectar();
    }
    
    //  Establece la Conexion con los datos recibidos en el Constructor
    private void conectar(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");        
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null){
                stm = conn.createStatement();
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a: "+url+" con el usuario: "+user+"\n");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);        
        }
        catch(ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);        
        }
    }
    
    // Devuelve verdadero si se estableció conexion sin problemas
    // Devuelve Falso si no se pudo establecer conexion
    public boolean isConectado(){
        if(conn != null){
            return true;
        }
        else{
            return false;
        }
    }
    
    // Recibe una consulta sql y la envia directamente a la base de datos
    public void query(String sqlInsert){
        try {
            stm.executeUpdate(sqlInsert);
        }catch (SQLException ex) {
            System.out.println("Error al ejecutar query: "+sqlInsert+"\n");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Devuelve una tabla de Resultados de una consulta
    public ResultSet listaResultados(String consulta){
        ResultSet rs = null;
            try {
                rs = stm.executeQuery(consulta);
            } catch (SQLException ex) {
                System.out.println("Error realizar la Consutla: "+consulta+"\n");
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        return rs;
    }
    
    // Devuelve el valor de una columna del Ultimo registro de la tabla
    public int ultimo(String tabla, String columna){
        int n =0;
        ResultSet rs = listaResultados("select Max("+columna+")"+columna+" from "+tabla);
        try {
            int aux = 0;
            while(rs.next()){
                aux = rs.getInt(columna);
            }
            n+=aux;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    // Indica cuántos registros se seleccionarán con una consulta
    public int nSeleccionados(String consulta){
        int n = 0;
        ResultSet rs = listaResultados(consulta);
        try {
            while(rs.next()){
                n++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    // permite ver el resultado de una casilla especifica
    public String ver(String consulta, String columna){
        String s = "";
        try {
            ResultSet rs = stm.executeQuery(consulta);
            while(rs.next())
               s = rs.getString(columna);
        } catch (SQLException ex) {
            System.out.println("Error al ver datos: \n");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);        
        }    
        return s;
    }  
}
