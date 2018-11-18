import javax.swing.*;
import java.util.ArrayList;

/** mmn12-1
 * @author Gad Maor
 * @version 1.0
 * A driver class for the GraphPlot program. Initiates an ArrayList of points and a JFrame object,
 * receives the points as input from the user and draws the lines between them on the panel
 */
public class GraphPlotDriver {
    public static void main(String[] args) {
        // ArrayList to hold the plot Points
        ArrayList<Point> points = new ArrayList<>();
        // GraphPlot object to plot the lines between the given Points
        GraphPlot plot = new GraphPlot(points);
        JFrame app = new JFrame();
        app.setAlwaysOnTop(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(400, 400);
        app.setVisible(true);
        app.add(plot);
        // JDialog object for displaying the input requests and messages on top of all other windows
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        printWelcomeMessage(dialog);
        // Point coordinate variables
        int x, y;
        x = y = 0;
        int pointCounter = 0;
        String input = "";
        // Continue receiving input until user inputs an empty string
        do {
            try {
                input = getInput(dialog, "x");
                x = getCoordinate(input);
                input = getInput(dialog, "y");
                y = getCoordinate(input);
            }
            /* Catches NumberFormatException exception if user inputs anything byt an integer and
               an IllegalArgumentException exception if the user inputs an out of range coordinate.
               If we encounter a NullPointerException, such as the user closed the input window, we end the plot.
             */
            catch (NullPointerException | IllegalArgumentException e) {
                if (input == null) {
                    break;
                }
                else if (! input.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Input error:\nMust enter an integer between 0-400!");
                    continue;
                }
            }
            points.add(new Point(x ,y));
            ++pointCounter;
            // IF we don't have at least 2 points, there's nothing to plot
            if (pointCounter > 1) {
                JOptionPane.showMessageDialog(dialog, "Will now plot the line!");
                // Draw the lines between all points received until now
                plot.repaint();
            }
        } while (! input.isEmpty());
        JOptionPane.showMessageDialog(dialog, "Plotting completed!\nClose the graph window to end program.");
        dialog.dispose();
    }

    /** Gets the input from the user for the Point's coordinates
     *
     * @param dialog The dialog object in which to print the input request message
     * @param coordinateComponnet the coordinateComponnet(x or y) to request input for
     * @return - The user's input
     */
    private static String getInput(JDialog dialog, String coordinateComponnet) {
        String message = "Enter " + coordinateComponnet + " coordinate for the Point:(in the range 0-400)";
        String result =  JOptionPane.showInputDialog(dialog, message);
        return result;
    }

    /** Gets the coordinate in int form from the user's input and validate it's in the range 0-400
     *
     * @param input The input the user typed in
     * @return - The coordinate
     */
    private static int getCoordinate(String input) {
        int result = Integer.parseInt(input);
        if (result < 0 || result > 400) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    /** Prints a welcome message and the instructions for plotting a new polygon.
     *
     * @param dialog The dialog object in which to print the welcome message
     */
    public static void printWelcomeMessage(JDialog dialog) {
        String message = "Welcome to Polygon plotter!\n" +
                         "This program plots lines between each 2 points you enter.\n" +
                         "Accepted input is an integer in the range 0-400.\n"  +
                         "Enter an empty string to mark end of input.\n" +
                         "Happy plotting!\n";
        JOptionPane.showMessageDialog(dialog, message);
    }
}