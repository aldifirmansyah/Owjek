
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Aldi Firmansyah on 5/20/2017.
 */
public class MainPanel extends JPanel {
    private int[] startKoor;
    private MapPanel mapPanel;
    private JLabel label1;
    private JLabel label2;
    private TextField field1;
    private TextField field2;
    private JComboBox comboBox;
    private JButton button1;
    private JButton button2;

    private String start, finish, jenisOwjek;

    private JLabel jarak, tipeO, hargaPertama, KMSel, promo, proteksi, total;
    private JTextField textJarak, textTipeO, textHargaPertama, textKMSel, textPromo, textProteksi, textTotal;

    private ArrayList<Integer[]> path = new ArrayList<>();

    OwjekRegular regular = new OwjekRegular();
    OwjekSporty sporty = new OwjekSporty();
    OwjekExclusive exclusive = new OwjekExclusive();

    public MainPanel(MapPanel map) {
        super(null);

        mapPanel = map;

        String[] owjekType = {"Choose Type", "Regular", "Sporty", "Exclusive"};
        this.label1 = new JLabel("Pick-up");
        this.label2 = new JLabel(("Destination"));
        this.field1 = new TextField(10);
        this.field2 = new TextField(10);
        this.comboBox = new JComboBox(owjekType);

        this.jarak = new JLabel("Total Jarak");
        this.tipeO = new JLabel("Tipe Ow-Jek");
        this.hargaPertama = new JLabel("Harga Pertama");
        this.KMSel = new JLabel("KM selanjutnya");
        this.promo = new JLabel("Promo");
        this.proteksi = new JLabel("Proteksi");
        this.total = new JLabel("Total");

        this.textJarak = new JTextField();
        textJarak.setEditable(false);
        this.textTipeO = new JTextField();
        textTipeO.setEditable(false);
        this.textHargaPertama = new JTextField();
        this.textHargaPertama.setEditable(false);
        this.textKMSel = new JTextField();
        this.textKMSel.setEditable(false);
        this.textPromo = new JTextField();
        this.textPromo.setEditable(false);
        this.textPromo = new JTextField();
        textPromo.setEditable(false);
        this.textProteksi = new JTextField();
        textProteksi.setEditable(false);
        this.textTotal = new JTextField();
        textTotal.setEditable(false);


        this.button1 = new JButton("Start");
        this.setBounds(0,0,300,600);

        label1.setBounds(10, 20, 100, 40);
        label1.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(label1);

        field1.setBounds(130, 28, 100, 25);
        field1.setFont(new Font("Serif", Font.PLAIN, 20));
        field1.setBackground(Color.LIGHT_GRAY);
        this.add(field1);

        label2.setBounds(10,  80, 100, 40);
        label2.setFont((new Font("Serif", Font.BOLD, 20)));
        this.add(label2);

        field2.setBounds(130, 88, 100, 25);
        field2.setFont(new Font("Serif", Font.PLAIN, 20));
        field2.setBackground(Color.LIGHT_GRAY);
        this.add(field2);

        comboBox.setBounds(75, 145, 140, 35);
        comboBox.setFont(new Font("Serif", Font.PLAIN, 18));
        this.add(comboBox);

        jarak.setBounds(10, 300, 100, 25);
        jarak.setFont(new Font("Serif", Font.BOLD, 18));
        this.add(jarak);
        textJarak.setBounds(160, 300, 100, 25);
        textJarak.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(textJarak);

        tipeO.setBounds(10, 340, 100, 25);
        tipeO.setFont(new Font("Serif", Font.BOLD, 18));
        this.add(tipeO);
        textTipeO.setBounds(160, 340, 100, 25);
        textJarak.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(textTipeO);

        hargaPertama.setBounds(10, 380, 150, 25);
        hargaPertama.setFont(new Font("Serif", Font.BOLD, 18));
        this.add(hargaPertama);
        textHargaPertama.setBounds(160, 380, 100, 25);
        textHargaPertama.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(textHargaPertama);

        KMSel.setBounds(10, 420, 150, 25);
        KMSel.setFont(new Font("Serif", Font.BOLD, 18));
        this.add(KMSel);
        textKMSel.setBounds(160, 420, 100, 25);
        textKMSel.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(textKMSel);

        promo.setBounds(10, 460, 100, 25);
        promo.setFont(new Font("Serif", Font.BOLD, 18));
        this.add(promo);
        textPromo.setBounds(160, 460, 100, 25);
        textPromo.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(textPromo);

        proteksi.setBounds(10, 500, 100, 25);
        proteksi.setFont(new Font("Serif", Font.BOLD, 18));
        this.add(proteksi);
        textProteksi.setBounds(160, 500, 100, 25);
        textProteksi.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(textProteksi);

        total.setBounds(10, 540, 100, 25);
        total.setFont(new Font("Serif", Font.BOLD, 18));
        this.add(total);
        textTotal.setBounds(160, 540, 100, 25);
        textTotal.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(textTotal);

        mulaiOwjek();

    }



    private void mulaiOwjek() {
        button1 = new JButton("Start");
        button1.setBounds(75, 240, 140, 35);

        class ButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                start = field1.getText();
                finish = field2.getText();
                jenisOwjek = (String)comboBox.getSelectedItem();

                if (ShortestPath.isJalan(start)) {
                    if (ShortestPath.isJalan(finish)) {

                        if (jenisOwjek.equalsIgnoreCase("choose type")) {
                            JOptionPane.showMessageDialog(null, "Pilih jenis Ow-Jek!");
                        }

                        else {
                            startKoor = getKoor(start);
                            int[] koorFinish = getKoor(finish);

                            ShortestPath shortestPath = new ShortestPath(startKoor[0], startKoor[1], koorFinish[0], koorFinish[1]);

                            path = shortestPath.getPath();

                            double jarak = (double)path.size() / 10;

                            textJarak.setText(String.valueOf(jarak));
                            textTipeO.setText(jenisOwjek);
                            textTipeO.setFont(new Font("Serif", Font.BOLD, 15));
                            hitungBiaya(jenisOwjek, jarak);

                            mapPanel.draw(mapPanel.getGraphics(), startKoor[1], startKoor[0], Color.ORANGE, "rect");

                            for(Integer[] i: path) {
                                try {
                                    Thread.sleep(65);

                                    mapPanel.draw(mapPanel.getGraphics(), i[1], i[0], Color.GREEN, "oval");
                                }
                                catch (InterruptedException error) {
                                }
                            }

                            mapPanel.draw(mapPanel.getGraphics(), koorFinish[1], koorFinish[0], Color.RED, "rect");

                            button1.setVisible(false);
                            button2.setVisible(true);


                        }
                    }

                }
            }
        }
        button1.addActionListener(new ButtonListener());

        button2 = new JButton("New Ride");
        button2.setBounds(75, 240, 140, 35);
        button2.setVisible(false);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setVisible(true);
                button2.setVisible(false);

                textJarak.setText("");
                textTipeO.setText("");
                textHargaPertama.setText("");
                textKMSel.setText("");
                textPromo.setText("");
                textProteksi.setText("");
                textTotal.setText("");
                field1.setText("");
                field2.setText("");
                comboBox.setSelectedIndex(0);

                mapPanel.draw(mapPanel.getGraphics(), startKoor[1], startKoor[0], Color.WHITE, "rect");
                for(Integer[] i: path) {

                    mapPanel.draw(mapPanel.getGraphics(), i[1], i[0], Color.WHITE, "RECT");
                }
            }
        });

        this.add(button1);
        this.add(button2);
    }


    public void hitungBiaya(String jenisOwjek, double jarak) {

        if (jenisOwjek.equalsIgnoreCase("regular")) {
            textHargaPertama.setText(String.valueOf(regular.getHargaPertama(jarak)));
            textKMSel.setText(String.valueOf(regular.getKMSel(jarak)));
            textPromo.setText(String.valueOf(regular.getPromo(jarak)));
            textProteksi.setText("0");
            textTotal.setText(String.valueOf(regular.getCost(jarak)));
        }

        else if (jenisOwjek.equalsIgnoreCase("sporty")) {
            textHargaPertama.setText(String.valueOf(sporty.getHargaPertama(jarak)));
            textKMSel.setText(String.valueOf(sporty.getKMSel(jarak)));
            textPromo.setText(String.valueOf(sporty.getPromo(jarak)));
            textProteksi.setText(String.valueOf(sporty.getProteksi(jarak)));
            textTotal.setText(String.valueOf(sporty.getCost(jarak)));
        }

        else if (jenisOwjek.equalsIgnoreCase("exclusive")) {
            textHargaPertama.setText(String.valueOf(exclusive.getHargaPertama(jarak)));
            textKMSel.setText(String.valueOf(exclusive.getKMSel(jarak)));
            textPromo.setText(String.valueOf(exclusive.getPromo(jarak)));
            textProteksi.setText(String.valueOf(exclusive.getProteksi(jarak)));
            textTotal.setText(String.valueOf(exclusive.getCost(jarak)));
        }
    }

    public static int[] getKoor(String jalan) {

        int y = (jalan.charAt(0)-65)*10 + Integer.parseInt(String.valueOf(jalan.charAt(1)));
        int x = (jalan.charAt(2)-81)*10 + Integer.parseInt(String.valueOf(jalan.charAt(3)));

        int[] arr = {y,x};
        return arr;
    }

}
