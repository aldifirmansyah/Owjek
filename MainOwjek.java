import java.awt.*;

/**
 * Created by Aldi Firmansyah on 5/20/2017.
 */
public class MainOwjek {
    public static void main(String[] args){
        MainFrame frame = new MainFrame();
        MapPanel p1 = new MapPanel();
        p1.setBounds(310, 150,1000, 500);
        MainPanel p2 = new MainPanel(p1);
        frame.add(p1);
        frame.add(p2);
        frame.setVisible(true);
    }

}
