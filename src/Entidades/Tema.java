package Entidades;
import Main.SIRP;
import javax.swing.JOptionPane;
public class Tema {
    private int id_tem;
    private int id_mat;
    private String tema;

    public Tema(int id_mat, String tema) {
        this.id_mat = id_mat;
        this.tema = tema;
        this.id_tem = SIRP.con.ultimo("registro.tema", "id_tem")+1; 
    }

    public Tema(int id_tem){
        this.id_tem = id_tem;
        id_mat = Integer.parseInt(SIRP.con.ver("select id_mat from registro.tema where id_tem='"+id_tem+"';", "id_mat"));
        tema = SIRP.con.ver("SELECT tema FROM registro.tema WHERE id_tem='"+id_tem+"';", "tema");
    }
    
    public void setId_mat(int id_mat) {
        this.id_mat = id_mat;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getId_tem() {
        return id_tem;
    }

    public int getId_mat() {
        return id_mat;
    }

    public String getTema() {
        return tema;
    }
    
    public void insert(){
        String materia = SIRP.con.ver("Select materia from registro.materia where id_mat='"+id_mat+"';", "materia");        
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea agregar el tema :"+tema+" a la materia "+materia+"?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "INSERT INTO REGISTRO.TEMA(id_tem,id_mat,tema) VALUES('";
                s+= id_tem;
                s+= "','";
                s+= id_mat;
                s+= "','";
                s+= tema;
                s+= "');";
                SIRP.con.query(s);
                JOptionPane.showMessageDialog(null, "El nuevo Tema fue Registrado Exitosamente");
           }
           else{
               JOptionPane.showMessageDialog(null, "El registro fue Cancelado");
           }
        }        
    }
    
    public void eliminar(){
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea eliminar el Tema:"+tema+"?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "DELETE FROM `registro`.`tema` WHERE `id_tem`='";
                s+= id_tem;
                s+= "';";
                SIRP.con.query(s);
                JOptionPane.showMessageDialog(null, "El tema "+tema+" Fue Removido de la Base de datos");
           }
           else{
               JOptionPane.showMessageDialog(null, "La eliminacion del Tema fue Cancelada");
           }
        }         
    }
    
    public void update(){
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea Actualizar los datos del Tema:"+tema+"?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "UPDATE `registro`.`tema` SET `tema`='"+
                    tema+"',`id_mat`='"+
                    id_mat+"' WHERE `id_tem`='"+
                    id_tem+"'; ";
                
                SIRP.con.query(s);
                JOptionPane.showMessageDialog(null, "Se actualizaron los dato del tema "+tema);
           }
           else{
               JOptionPane.showMessageDialog(null, "La Actualizacion de datos del Tema fue Cancelada");
           }
        }         
    }     
}