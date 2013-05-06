package sirp.Entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sirp.SIRP;

public class Profesor implements Persona{
    
    private int id_pro;
    private String nombre;
    private String apellido;
    private String ci;
    private String direccion;
    private String telf;
    
    public Profesor(int id_pro){
        this.id_pro = id_pro;
        ResultSet rs;
        rs = SIRP.con.listaResultados("select * from registro.profesor where id_pro='"+id_pro+"';");
        try {
            while(rs.next()){
                this.nombre = rs.getString("nombre");
                this.apellido = rs.getString("apellido");
                this.ci = rs.getString("ci");
                this.direccion = rs.getString("direccion");
                this.telf = rs.getString("telf");                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Profesor(String nombreCompleto){
        ResultSet rs;
        rs = SIRP.con.listaResultados("SELECT * FROM `registro`.`profesor` WHERE CONCAT(`nombre`,' ',`apellido`) = '"+nombreCompleto+"';");
        try {
            while(rs.next()){            
                id_pro = rs.getInt("id_pro");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                ci = rs.getString("ci");
                direccion = rs.getString("direccion");
                telf = rs.getString("telf");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Profesor(String nombre, String apellido, String ci, String direccion, String telf) {
        id_pro = SIRP.con.ultimo("registro.alumno", "id_alu")+1;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.direccion = direccion;
        this.telf = telf;
    }   
    
    @Override public int getId() {
        return id_pro;
    }

    @Override public void insert() {
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea agregar a:"+nombre+" "+apellido+" como nuevo Profesor(a)?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "INSERT INTO REGISTRO.PROFESOR(id_pro, nombre, apellido,ci, direccion, telf) VALUES('";
                s+= id_pro;
                s+= "','";
                s+= nombre;
                s+= "','";
                s+= apellido;
                s+="','";
                s+= ci;
                s+="','";
                s+= direccion;
                s+="','";
                s+= telf;
                s+= "');";
                //registropedagogico.RegistroPedagogico.con.query(s);
                JOptionPane.showMessageDialog(null, "El nuevo Profesor fue Registrado Exitosamente");
           }
           else{
               JOptionPane.showMessageDialog(null, "El registro fue Cancelado");
           }
        }
    }

    @Override public String getNombre() {
        return nombre;
    }

    @Override public String getApellido() {
        return apellido;
    }

    @Override public String getCI() {
        return ci;
    }

    @Override public String getDireccion() {
        return direccion;
    }

    @Override public String getTelf() {
        return telf;
    }   
    
    @Override public String toString(){
        return id_pro+ " "+super.toString();
    }
}
