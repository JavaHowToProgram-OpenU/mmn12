import static java.lang.Math.*;

public class Point {
    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // The x coordinate of this Point
    private int x;
    // The y coordinate of this Point
    private int y;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /** Calculates and returns the length of the line created by the 2 given Points
     *
     * @param p1 The first point
     * @param p2 The second Point
     * @return - The length of the line between the 2 Points
     */
    public double getLength(Point p1, Point p2) {
        return sqrt(pow((double)p2.getY() - p1.getX(), 2) + pow((double)p2.getY() - p1.getY(), 2));
    }

    /** Calculates and returns the middle Point of a line between the 2 given Points
     *
     * @param p1 The first point
     * @param p2 The second point
     * @return - The Point in the middle of the line between the 2 given Points
     */
    public Point getMiddlePoint(Point p1, Point p2) {
        int xMiddle = p1.getX() + p2.getX() / 2;
        int yMiddle = p1.getY() + p2.getY() / 2;
        return new Point(xMiddle, yMiddle);
    }
}
