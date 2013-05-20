package Main;
import Entidades.Conexion;
import GUI.RegistrarAsistencia;
import com.birosoft.liquid.LiquidLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
public class SIRP {

    public static void main(String[] args) {
        con = new Conexion("root","","localhost");
        style();
        new RegistrarAsistencia(2);
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
}
