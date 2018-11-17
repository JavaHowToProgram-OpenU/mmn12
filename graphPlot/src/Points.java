import java.awt.*;
import java.util.ArrayList;
import static java.lang.Math.*;

public class Points {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // The ArrayList to hold the Points.
    private ArrayList<Point> points = new ArrayList<>();

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    public Points (Point p) {
        points.add(p);
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/
    public double getLength(Point p1, Point p2) {
        return sqrt(pow(p2.getY() - p1.getX()) + pow(p2.getY() - p1.getY()));
    }

    /** Calculates and returns the middle Point of a line between the 2 given Points
     *
     * @param p1 The first point
     * @param p2 The second point
     * @return - The Point in the middle of the line between the 2 given Points
     */
    public Point getMiddlePoint(Point p1, Point p2) {
        int xMiddle = (int) (p1.getX() + p2.getX() / 2);
        int yMiddle = (int) (p1.getY() + p2.getY() / 2);
        return new Point(xMiddle, yMiddle);
    }
}
