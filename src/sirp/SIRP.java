package sirp;
import com.birosoft.liquid.LiquidLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import sirp.GUI.*;
public class SIRP {

    public static void main(String[] args) {
        con = new Conexion("root","","localhost");
        style();
        new TomarLista(1);
        new TomarListaTable(1);
    }
    
    public static Conexion con;
    
    public static void style(){
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            LiquidLookAndFeel.setLiquidDecorations(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SIRP.class.getName()).log(Level.SEVERE, null, ex);
        }
  
   }
}
