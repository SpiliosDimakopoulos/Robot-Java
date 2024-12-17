import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

public class RobotBlueprint {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            // Total program runtime in minutes
            int durationMinutes = 60; // Change this value to set the total duration

            // List of mouse coordinates (x, y) for movements
            List<int[]> mouseCoordinates = List.of(
                    new int[]{1724, 206},
                    new int[]{1824, 346},
                    new int[]{697, 458},
                    new int[]{1369, 608},
                    new int[]{1119, 583},
                    new int[]{1368, 608},
                    new int[]{1114, 583},
                    new int[]{1875, 149}
            );

            // List of delays (in milliseconds) between actions
            List<Integer> delays = List.of(
                    20000,
                    2000,
                    5000,
                    1500,
                    1500,
                    1500,
                    1500,
                    1000
            );

            // Start time tracking
            long startTime = System.currentTimeMillis();
            long durationMillis = durationMinutes * 60 * 1000;

            System.out.println("Program started. Duration: " + durationMinutes + " minutes.");

            while (true) {
                long elapsedTime = System.currentTimeMillis() - startTime;

                // Stop if total runtime exceeds the specified duration
                if (elapsedTime > durationMillis) {
                    System.out.println("Program terminated after " + durationMinutes + " minutes.");
                    break;
                }

                // Iterate over coordinates and delays
                for (int i = 0; i < mouseCoordinates.size(); i++) {
                    int[] coordinates = mouseCoordinates.get(i);
                    int delay = delays.get(i);

                    // Move the mouse and simulate click
                    robot.mouseMove(coordinates[0], coordinates[1]);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                    // Delay before the next action
                    System.out.println("Clicked at (" + coordinates[0] + ", " + coordinates[1] + "). Waiting for " + delay + " ms.");
                    Thread.sleep(delay);
                }
            }

        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
