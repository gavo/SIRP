package Entidades;

import Main.SIRP;
import javax.swing.JOptionPane;

public class Curso {
    private int id_cur;
    private String curso;

    public Curso(String curso) {
        this.curso = curso;
        id_cur = SIRP.con.ultimo("registro.curso", "id_cur")+1; 
    }

    public Curso(int id_cur){
        this.id_cur = id_cur;
        curso = SIRP.con.ver("select curso from registro.curso where id_cur='"+id_cur+"';", "curso");
    }
    
    public int getId_cur() {
        return id_cur;
    }

    public String getCurso() {
        return curso;
    }

    public void setId_cur(int id_cur) {
        this.id_cur = id_cur;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public void insert(){
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea agregar a:"+curso+" como nuevo Curso?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "INSERT INTO REGISTRO.CURSO(id_cur,curso) VALUES('";
                s+= id_cur;
                s+= "','";
                s+= curso;
                s+= "');";
                SIRP.con.query(s);
                JOptionPane.showMessageDialog(null, "El nuevo Curso fue Registrado Exitosamente");
           }
           else{
               JOptionPane.showMessageDialog(null, "El registro fue Cancelado");
           }
        }        
    }
    
    public void eliminar(){
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea eliminar el curso:"+curso+"?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "DELETE FROM `registro`.`curso` WHERE `id_cur`='";
                s+= id_cur;
                s+= "';";
                SIRP.con.query(s);
                JOptionPane.showMessageDialog(null, "El nuevo Curso fue Removido Exitosamente");
           }
           else{
               JOptionPane.showMessageDialog(null, "La eliminacion del registro fue Cancelado");
           }
        }         
    }
}
