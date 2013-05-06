package sirp.Entidades;

import javax.swing.JOptionPane;
import sirp.*;

public class Bloque {
    private int id_blo;
    private String bloque;

    public Bloque(String bloque) {
        this.bloque = bloque;
        id_blo = SIRP.con.ultimo("registro.bloque", "id_blo")+1; 
    }

    public Bloque(int id_blo){
        this.id_blo = id_blo;
        bloque = SIRP.con.ver("select bloque from registro.bloque where id_blo='"+id_blo+"';", "bloque");
    }

    public int getId_blo() {
        return id_blo;
    }

    public String getBloque() {
        return bloque;
    }

    public void setId_blo(int id_blo) {
        this.id_blo = id_blo;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }
        
    public void insert(){
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea agregar a:"+bloque+" como nuevo Bloque de Evaluaciones?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "INSERT INTO REGISTRO.BLOQUE(id_blo,bloque) VALUES('";
                s+= id_blo;
                s+= "','";
                s+= bloque;
                s+= "');";
                SIRP.con.query(s);
                JOptionPane.showMessageDialog(null, "El nuevo Bloque fue Registrado Exitosamente");
           }
           else{
               JOptionPane.showMessageDialog(null, "El registro fue Cancelado");
           }
        }        
    }
    
    public void eliminar(){
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea eliminar el Bloque:"+bloque+"?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "DELETE FROM `registro`.`bloque` WHERE `id_blo`='";
                s+= id_blo;
                s+= "';";
                SIRP.con.query(s);
                JOptionPane.showMessageDialog(null, "El nuevo Bloque fue Removido Exitosamente");
           }
           else{
               JOptionPane.showMessageDialog(null, "La eliminacion del registro fue Cancelado");
           }
        }         
    }
}
