import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

/** mmn12-1
 * @author Gad Maor
 * @version 1.0
 * Plots a polygon from a given ArrayList of Points on a JPanel object.
 *  Adds the length of each line line in the line's middle Point. *
 */
public class graphPlot extends JPanel {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // The Points object containing the polygon's Points
    private ArrayList<Point> points;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    /** Creates a new graphPlot using an ArrayList of Points
     *
     * @param points
     */
    public graphPlot(ArrayList<Point> points) {
        this.points = points;
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/
    /** Draws the lines of the polygon and then calculates and draws their length in the middle of the line
     *
     * @param g A Graphics object to plot the lines with
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 1; i < points.size(); ++i) {
            Point currentpoint = points.get(i);
            Point previousPoint = points.get(i - 1);
            // Draw a line from the previous point to the current point
            g.drawLine(currentpoint.getX(), currentpoint.getY(), previousPoint.getX(), previousPoint.getY());
            double length = currentpoint.getDistance(previousPoint);
            Point middle = currentpoint.getMiddlePoint(previousPoint);
            // Draw the length of the line created by the 2 Points in the middle Point between them
            g.drawString(String.format("%.2f", length) , middle.getX(), middle.getY());
        }
    }
}
