/**
 * Created by Aldi Firmansyah on 4/28/2017.
 */
public class OwjekExclusive extends Owjek implements Payable {
    private final int minCC = 500;
    private final int fixedCost = 10000;
    private final double protectionCost = 0.05;

    public OwjekExclusive() {
        this.minYearAllowed = 2016;
        this.costPerKM = 5000;
        this.promo = 0.5;
    }
    //belum di implementasi
    @Override
    public int getCost(double distance) {
        return (int)(getHargaPertama(distance) + getKMSel(distance) - getPromo(distance) + getProteksi(distance));

    }

    @Override
    public int getPromo(double distance) {
        return (int)((getHargaPertama(distance) + getKMSel(distance)) * promo);
    }

    public int getHargaPertama(double distance) {
        return fixedCost;
    }

    public double getKMSel(double distance) {
        return distance * costPerKM;
    }

    public double getProteksi(double distance) {
        return (getHargaPertama(distance) + getKMSel(distance) + getPromo(distance)) * protectionCost;
    }
}
