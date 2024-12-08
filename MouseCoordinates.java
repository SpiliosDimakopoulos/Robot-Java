import java.awt.MouseInfo;

public class MouseCoordinates {
    public static void main(String[] args) {
        while (true) {
            
            int x = MouseInfo.getPointerInfo().getLocation().x;
            int y = MouseInfo.getPointerInfo().getLocation().y;

            System.out.println("Mouse coordinates: X = " + x + ", Y = " + y);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
