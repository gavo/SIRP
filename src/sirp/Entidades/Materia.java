package sirp.Entidades;

import javax.swing.JOptionPane;
import sirp.*;

public class Materia {
    private int id_mat;
    private int id_cur;
    private int id_pro;
    private String materia;

    public Materia(int id_cur, int id_pro, String materia) {
        id_mat = SIRP.con.ultimo("registro.materia", "id_mat")+1;
        this.id_cur = id_cur;
        this.id_pro = id_pro;
        this.materia = materia;
    }
    
    public Materia(String curso, String materia){
        this.id_cur = Integer.parseInt(SIRP.con.ver("select id_cur from registro.curso where curso='"+curso+"';", "id_cur"));
        this.materia = materia;
        this.id_pro = Integer.parseInt(SIRP.con.ver("select id_pro from registro.materia where id_cur ='"+id_cur+"' and materia ='"+materia+"';", "id_pro"));
        this.id_mat = Integer.parseInt(SIRP.con.ver("select id_mat from registro.materia where id_cur ='"+id_cur+"' and materia ='"+materia+"';", "id_mat"));
    }

    public void setId_mat(int id_mat) {
        this.id_mat = id_mat;
    }

    public void setId_cur(int id_cur) {
        this.id_cur = id_cur;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getId_mat() {
        return id_mat;
    }

    public int getId_cur() {
        return id_cur;
    }

    public int getId_pro() {
        return id_pro;
    }

    public String getMateria() {
        return materia;
    }
        
    public void insert(){
        Curso c = new Curso(id_cur);
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea agregar la materia:"+materia+" al curso:"+c.getCurso()+" ?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "INSERT INTO REGISTRO.MATERIA(id_mat,id_cur,id_pro,materia) VALUES('";
                s+= id_mat;
                s+= "','";
                s+= id_cur;
                s+= "','";
                s+= id_pro;
                s+= "','";
                s+= materia;
                s+= "');";
                SIRP.con.query(s);
                JOptionPane.showMessageDialog(null, "La nueva materia fue registrada Exitosamente");
           }
           else{
               JOptionPane.showMessageDialog(null, "El registro de la materia fue Cancelado");
           }
        }        
    }
    
    public void eliminar(){
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea eliminar la Materia:"+materia+"?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "DELETE FROM `registro`.`materia` WHERE `id_mat`='";
                s+= id_mat;
                s+= "';";
                SIRP.con.query(s);
                JOptionPane.showMessageDialog(null, "La materia fue removida Exitosamente");
           }
           else{
               JOptionPane.showMessageDialog(null, "La eliminacion de la materia fue Cancelada");
           }
        }         
    }
    
    
    
}
