package Main;
import Entidades.Conexion;
import GUI.*;
import com.birosoft.liquid.LiquidLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
public class SIRP {

    public static void main(String[] args) {
        con = new Conexion("root","","localhost");
        style();
        new Login();
    }
    
    public static Conexion con;
    //ESTO ES UNA PRUEBA, NO TIENE VALOR....
    public static void style(){
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            LiquidLookAndFeel.setLiquidDecorations(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SIRP.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    public static void inicio(){
        JOptionPane.showMessageDialog(null, "Conectado");
        System.exit(id);
    }
    
    public static int id;
}
