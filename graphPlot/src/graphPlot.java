import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class graphPlot extends JPanel {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // The Points object containing the Points to connect
    private ArrayList<Point> points;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    public graphPlot(ArrayList<Point> points) {
        this.points = points;
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


    }
}
