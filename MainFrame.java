import javax.swing.*;
import java.awt.*;

/**
 * Created by Aldi Firmansyah on 5/20/2017.
 */

public class MainFrame extends JFrame {
    private JLabel label;

    public MainFrame() throws HeadlessException {
        this.setLayout(null);
        this.setSize(1500, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Icon logo = new ImageIcon(getClass().getResource("top.png"));
        label = new JLabel(logo);
        this.add(label);
        label.setBounds(310, 0, 1000, 150);


    }
}
