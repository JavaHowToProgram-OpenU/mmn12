import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.ArrayList;

public class graphPlotDriver {
    public static void main(String[] args) {
        // ArrayList to hold the plot Points
        ArrayList<Point> points = new ArrayList<>();
        // graphPlot object to plot the lines between the given Points
        graphPlot plot = new graphPlot(points);
        JFrame app = new JFrame();
        // JDialog object for displaying the input requests on top of all other windows
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(dialog, "Welcome to Polygon plotter!");
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
            catch (IllegalArgumentException e) {
                if (! input.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Input error:\nMust enter an integer between 0-400!");
                }
                continue;
            }
            points.add(new Point(x ,y));
            ++pointCounter;
            // IF we don't have at least 2 points, there's nothing to plot
            if (pointCounter > 1) {
                JOptionPane.showMessageDialog(dialog, "Will now plot the line!");
                // plot.repaint();
            }
        } while (! input.isEmpty());
        dialog.dispose();

        /*

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(plot);
        app.setSize(400, 400);
        app.setVisible(true);*/
    }
    private static String getInput(JDialog dialog, String coordinateComponnet) {
        String message = "Enter " + coordinateComponnet + " for the Point:";
        String result =  JOptionPane.showInputDialog(dialog, message);
        return result;
    }
    private static int getCoordinate(String input) {
        int result = Integer.parseInt(input);
        if (result < 0 || result > 400) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}