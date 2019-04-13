import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Aldi Firmansyah on 5/19/2017.
 */
public class ShortestPath {
    private static Map mapCheck = new Map();
    private ArrayList<Integer[]> path = new ArrayList<>();
    private boolean adaShortestPath;
    private Map map;

    public ShortestPath(int yStart, int xStart, int yFinish, int xFinish) {
        this.adaShortestPath = false;
        this.map = new Map();
        ArrayList<Integer[]> arr = new ArrayList<>();
        getShortestPath(yStart, xStart, yFinish, xFinish, arr);
    }

    public static boolean isJalan (String jalan) {
        try {
            if ((jalan.charAt(0)>='A' && jalan.charAt(0)<='E') && (jalan.charAt(2)>='Q' && jalan.charAt(2)<='Z')) {

                int y = (jalan.charAt(0)-65)*10 + Integer.parseInt(String.valueOf(jalan.charAt(1)));
                int x = (jalan.charAt(2)-81)*10 + Integer.parseInt(String.valueOf(jalan.charAt(3)));

                if (mapCheck.get(y, x).equals(' ')) {
                    return true;
                }
                else {
                    System.out.printf("Kordinat %s bukan merupakan jalan!\n", jalan);
                    JOptionPane.showMessageDialog(null, "Kordinat " + jalan + " bukan merupakan jalan!");
                }
            }

            else {
                JOptionPane.showMessageDialog(null, "Kordinat " + jalan + " bukan merupakan jalan!");
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.printf("Kordinat %s bukan merupakan jalan!\n", jalan);
            JOptionPane.showMessageDialog(null, "Kordinat " + jalan + " bukan merupakan jalan!");
            return false;
        }
        catch (NumberFormatException e) {
            System.out.printf("Kordinat %s bukan merupakan jalan!\n", jalan);
            JOptionPane.showMessageDialog(null, "Kordinat " + jalan + " bukan merupakan jalan!");
            return false;
        }
        return false;
    }

    public void getShortestPath(int yCurr, int xCurr, int yFinish, int xFinish, ArrayList<Integer[]> pathArr) {
        if (yCurr == yFinish && xCurr == xFinish && !adaShortestPath) {
            this.adaShortestPath = true;
            this.path = pathArr;
        }
        else if (yCurr == yFinish && xCurr == xFinish && adaShortestPath && pathArr.size() < this.path.size()) {
            this.path = pathArr;
        }
        else if (!adaShortestPath) {

            if (map.get(yCurr+1, xCurr).equals(' ') && !isInArray(yCurr+1, xCurr, pathArr)) {
                ArrayList<Integer[]> newArr = new ArrayList<>(pathArr);
                Integer[] newKoor = {yCurr+1, xCurr};
                newArr.add(newKoor);
                getShortestPath(yCurr+1, xCurr, yFinish, xFinish, newArr);
            }

            if (map.get(yCurr-1, xCurr).equals(' ') && !isInArray(yCurr-1, xCurr, pathArr)) {
                ArrayList<Integer[]> newArr = new ArrayList<>(pathArr);
                Integer[] newKoor = {yCurr-1, xCurr};
                newArr.add(newKoor);
                getShortestPath(yCurr-1, xCurr, yFinish, xFinish, newArr);
            }

            if (map.get(yCurr, xCurr+1).equals(' ') && !isInArray(yCurr, xCurr+1, pathArr)) {
                ArrayList<Integer[]> newArr = new ArrayList<>(pathArr);
                Integer[] newKoor = {yCurr, xCurr+1};
                newArr.add(newKoor);
                getShortestPath(yCurr, xCurr+1, yFinish, xFinish, newArr);
            }

            if (map.get(yCurr, xCurr-1).equals(' ') && !isInArray(yCurr, xCurr-1, pathArr)) {
                ArrayList<Integer[]> newArr = new ArrayList<>(pathArr);
                Integer[] newKoor = {yCurr, xCurr-1};
                newArr.add(newKoor);
                getShortestPath(yCurr, xCurr-1, yFinish, xFinish, newArr);
            }
        }

        else if (adaShortestPath && pathArr.size() < this.path.size()) {

            if (map.get(yCurr+1, xCurr).equals(' ') && !isInArray(yCurr+1, xCurr, pathArr)) {
                ArrayList<Integer[]> newArr = new ArrayList<>(pathArr);
                Integer[] newKoor = {yCurr+1, xCurr};
                newArr.add(newKoor);
                getShortestPath(yCurr+1, xCurr, yFinish, xFinish, newArr);
            }

            if (map.get(yCurr-1, xCurr).equals(' ') && !isInArray(yCurr-1, xCurr, pathArr)) {
                ArrayList<Integer[]> newArr = new ArrayList<>(pathArr);
                Integer[] newKoor = {yCurr-1, xCurr};
                newArr.add(newKoor);
                getShortestPath(yCurr-1, xCurr, yFinish, xFinish, newArr);
            }

            if (map.get(yCurr, xCurr+1).equals(' ') && !isInArray(yCurr, xCurr+1, pathArr)) {
                ArrayList<Integer[]> newArr = new ArrayList<>(pathArr);
                Integer[] newKoor = {yCurr, xCurr+1};
                newArr.add(newKoor);
                getShortestPath(yCurr, xCurr+1, yFinish, xFinish, newArr);
            }

            if (map.get(yCurr, xCurr-1).equals(' ') && !isInArray(yCurr, xCurr-1, pathArr)) {
                ArrayList<Integer[]> newArr = new ArrayList<>(pathArr);
                Integer[] newKoor = {yCurr, xCurr-1};
                newArr.add(newKoor);
                getShortestPath(yCurr, xCurr-1, yFinish, xFinish, newArr);
            }
        }
    }

    public ArrayList<Integer[]> getPath() {
        return path;
    }

    public boolean isInArray(int y, int x, ArrayList<Integer[]> arr) {

        for (Integer[] i: arr) {
            if (i[0] == y && i[1] == x) {
                return true;
            }
        }
        return false;
    }


}
