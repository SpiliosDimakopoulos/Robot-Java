# Mouse Coordinates Tracker

A simple Java program that continuously tracks and displays the current mouse cursor coordinates (X and Y positions) on the screen.

## Features
- Uses `MouseInfo` from `java.awt` to get mouse position.
- Continuously prints mouse coordinates to the console every 500 milliseconds.
- Simple and lightweight implementation.

## Prerequisites
To compile and run this program, ensure you have:
- **Java Development Kit (JDK)** installed (minimum version 8).
- A text editor or IDE (e.g., IntelliJ, Eclipse, VSCode).

## Code
Copy and paste the following code into your editor:

```java
import java.awt.MouseInfo;

public class MouseCoordinates {
    public static void main(String[] args) {
        while (true) {
            // Get the current mouse X and Y coordinates
            int x = MouseInfo.getPointerInfo().getLocation().x;
            int y = MouseInfo.getPointerInfo().getLocation().y;

            // Print the coordinates to the console
            System.out.println("Mouse coordinates: X = " + x + ", Y = " + y);

            // Wait for 500 milliseconds before checking again
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

## How to Run
1. **Save the file** as `MouseCoordinates.java`.
2. Open a terminal or command prompt.
3. Navigate to the directory where the file is saved.
4. Compile the program:
   ```bash
   javac MouseCoordinates.java
   ```
5. Run the program:
   ```bash
   java MouseCoordinates
   ```
6. The program will continuously print the current mouse cursor coordinates to the terminal.

## Output Example
```
Mouse coordinates: X = 500, Y = 300
Mouse coordinates: X = 520, Y = 310
Mouse coordinates: X = 540, Y = 320
...
```

## Stopping the Program
To stop the program, press **Ctrl + C** in the terminal or command prompt.

## Notes
- The program captures mouse coordinates every 500 milliseconds. Adjust the `Thread.sleep(500)` value to change the refresh rate.
- Ensure your environment allows access to `java.awt` for the program to work correctly.

# Automated Mouse Controller with Robot Class

A Java program that automates mouse movements and clicks using the `Robot` class. It moves the mouse cursor to specific coordinates, simulates clicks, and repeats these actions for a specified duration.

## Features
- Uses `Robot` from `java.awt` to control the mouse.
- Automates clicks at predefined screen coordinates.
- Allows setting delays between actions and a total runtime duration.
- Prints status messages for each action performed.

## Prerequisites
To compile and run this program, ensure you have:
- **Java Development Kit (JDK)** installed (minimum version 8).
- A text editor or IDE (e.g., IntelliJ, Eclipse, VSCode).
- Knowledge of screen coordinates where you want the mouse actions.

## Code
Copy and paste the following code into your editor:

```java
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
```

## How to Run
1. **Save the file** as `RobotBlueprint.java`.
2. Open a terminal or command prompt.
3. Navigate to the directory where the file is saved.
4. Compile the program:
   ```bash
   javac RobotBlueprint.java
   ```
5. Run the program:
   ```bash
   java RobotBlueprint
   ```
6. The program will automate mouse movements and clicks as specified.

## How It Works
- **Predefined Coordinates**: The mouse moves to specific screen coordinates (e.g., `1724, 206`). Modify the `mouseCoordinates` list to set your desired positions.
- **Delays**: Delays between each action are specified in milliseconds in the `delays` list.
- **Runtime Duration**: Set the total duration in minutes using the `durationMinutes` variable.

## Output Example
```
Program started. Duration: 60 minutes.
Clicked at (1724, 206). Waiting for 20000 ms.
Clicked at (1824, 346). Waiting for 2000 ms.
Clicked at (697, 458). Waiting for 5000 ms.
...
Program terminated after 60 minutes.
```

## Notes
- Adjust coordinates and delays as per your use case.
- Ensure you have sufficient permissions to access the `java.awt` classes.
- **Interrupt the program** using **Ctrl + C** if needed.
