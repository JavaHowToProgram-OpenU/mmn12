import static java.lang.Math.*;

/** mmn12-1
 * @author Gad Maor
 * @version 1.0
 * Represents a point in a 2D coordinate system
 */
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
    /** Creates a new Point from given x and y coordinates
     *
     * @param x The x coordinate of this Point
     * @param y The y coordinate of this Point
     */
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

    /** Returns the distance between this Point and p
     *
     * @param p The point to calculate the distance to
     * @return - The distance between this Point and p
     */
    public double getDistance(Point p) {
        return sqrt(pow(this.getX() - p.getX(), 2) + pow(this.getY() - p.getY(), 2));
    }

    /** Returns the middle Point between this point and p
     *
     * @param p The point to use to find the midpoint between this Point and it
     * @return - The midpoint between this Point and p
     */
    public Point getMiddlePoint(Point p) {
        int xMiddle = (this.getX() + p.getX()) / 2;
        int yMiddle = (this.getY() + p.getY()) / 2;
        return new Point(xMiddle, yMiddle);
    }
}
