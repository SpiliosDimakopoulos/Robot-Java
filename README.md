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


