import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Aldi Firmansyah on 5/21/2017.
 */
public class MapPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            FileReader fr = new FileReader("map.txt");
            Scanner s = new Scanner(fr);

            int row = 0;

            while (s.hasNextLine()) {
                String column = s.nextLine();
                for(int i = 0; i < column.length(); i++) {

                    if(column.charAt(i) == '#') {

                        draw(g, i, row, Color.BLACK, "rect");
                    }

                    else {
                        draw(g, i, row, Color.WHITE, "rect");
                    }


                }
                row++;
            }

        }
        catch (IOException e) {

        }
    }

    public void draw (Graphics g, int x, int y, Color color,  String shape) {

        g.setColor(color);

        if(shape.equalsIgnoreCase("rect")) {
            g.fillRect(10*x, 10*y, 10, 10);
        }

        else if(shape.equalsIgnoreCase("oval")) {
            g.fillOval(10*x, 10*y, 10, 10);
        }
    }
}
