package sirp;
import com.birosoft.liquid.LiquidLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import sirp.GUI.RegistrarAlumno;
public class SIRP {

    public static void main(String[] args) {
        con = new Conexion("root","","localhost");
        style();
        new RegistrarAlumno();
    }
    
    public static Conexion con;
    
    public static void style(){
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            LiquidLookAndFeel.setLiquidDecorations(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SIRP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SIRP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SIRP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SIRP.class.getName()).log(Level.SEVERE, null, ex);
        }
  
   }
}
