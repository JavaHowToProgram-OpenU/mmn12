import javax.swing.JPanel;
import java.awt.*;

public class graphPlot extends JPanel {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // The Points object containing the Points to connect
    private Points points;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    public graphPlot(Points points) {
        this.points = points;
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
