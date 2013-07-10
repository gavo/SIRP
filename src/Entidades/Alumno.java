package Entidades;

import Main.SIRP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Alumno implements Persona{

    private int id_alu;
    private String nombre;
    private String apellido;
    private String ci;
    private Date nac;
    private String direccion;
    private String telf;
    
    public Alumno(int id_alu){
        this.id_alu = id_alu;
        ResultSet rs;
        rs = SIRP.con.consulta("select * from registro.alumno where id_alu='"+id_alu+"';");
        try {
            while(rs.next()){
                this.nombre = rs.getString("nombre");
                this.apellido = rs.getString("apellido");
                this.ci = rs.getString("ci");
                this.direccion = rs.getString("direccion");
                this.nac = rs.getDate("nac");
                this.telf = rs.getString("telf");                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Alumno(String nombreCompleto){
        ResultSet rs;
        rs = SIRP.con.consulta("SELECT * FROM `registro`.`alumno` WHERE CONCAT(`nombre`,' ',`apellido`) = '"+nombreCompleto+"';");
        try {
            while(rs.next()){            
                id_alu = rs.getInt("id_alu");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                ci = rs.getString("ci");
                nac = rs.getDate("nac");
                direccion = rs.getString("direccion");
                telf = rs.getString("telf");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Alumno(String nombre, String apellido, String ci, Date nac, String direccion, String telf) {
        id_alu = SIRP.con.ultimo("alumno", "id_alu")+1;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.nac = nac;
        this.direccion = direccion;
        this.telf = telf;
    }   
    
    @Override public int getId() {
        return id_alu;
    }

    @Override public void insert() {
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea agregar a:"+nombre+" "+apellido+" como nuevo alumno?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){     
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                String s="";
                s+= "exec insertarAlumno '";
                s+= id_alu;
                s+= "','";
                s+= nombre;
                s+= "','";
                s+= apellido;
                s+= "','";
                s+= ci;
                s+= "','";
                s+= sdf.format(nac);
                s+= "','";
                s+= direccion;
                s+= "','";
                s+= telf;
                s+= "'";
                SIRP.con.ejecutar(s);
                //registropedagogico.RegistroPedagogico.con.query(s);
                JOptionPane.showMessageDialog(null, "El alumno fue Registrado Exitosamente");
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
        return id_alu+ ": "+nombre+" "+apellido;        
    }
}
