package sirp.Entidades;

import javax.swing.JOptionPane;
import sirp.*;

public class Tipo_Ev {
    private int id_tip;
    private String tipo;

    public Tipo_Ev(String tipo) {
        this.tipo = tipo;
        id_tip = SIRP.con.ultimo("registro.tipo_ev", "id_tip")+1; 
    }

    public Tipo_Ev(int id_tip){
        this.id_tip = id_tip;
        tipo = SIRP.con.ver("select tipo from registro.tipo_ev where id_tip='"+id_tip+"';", "tipo");
    }

    public void setId_tip(int id_tip) {
        this.id_tip = id_tip;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId_tip() {
        return id_tip;
    }

    public String getTipo() {
        return tipo;
    }
        
    public void insert(){
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea agregar a:"+tipo+" como nuevo Tipo de Evaluaciones?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "INSERT INTO REGISTRO.TIPO_ev(id_tip,tipo) VALUES('";
                s+= id_tip;
                s+= "','";
                s+= tipo;
                s+= "');";
                SIRP.con.query(s);
                JOptionPane.showMessageDialog(null, "la nueva Evaluacion fue Registrada Exitosamente");
           }
           else{
               JOptionPane.showMessageDialog(null, "El registro fue Cancelado");
           }
        }        
    }
    
    public void eliminar(){
        int seleccion = JOptionPane.showOptionDialog(null,
        "¿Desea eliminar la Evaluacion:"+tipo+"?",
        "Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"},"Si");
        if (seleccion != -1){
           if((seleccion + 1)==1){              
                String s="";
                s+= "DELETE FROM `registro`.`tipo_ev` WHERE `id_tip`='";
                s+= id_tip;
                s+= "';";
                SIRP.con.query(s);
                JOptionPane.showMessageDialog(null, "La Evaluacion fue Removida Exitosamente");
           }
           else{
               JOptionPane.showMessageDialog(null, "La eliminacion del registro fue Cancelada");
           }
        }         
    }
}
