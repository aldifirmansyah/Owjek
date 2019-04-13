/**
 * Created by Aldi Firmansyah on 4/27/2017.
 */
public class OwjekSporty extends Owjek implements Payable {
    private final int minTopSpeed = 140;
    private final int first5KMCost = 20000;
    private final double protectionCost = 0.1;

    public OwjekSporty() {
        this.minYearAllowed = 2015;
        this.costPerKM = 3000;
        this.promo = 0.6;
    }

    @Override
    public int getCost(double distance) {
        return getHargaPertama(distance) + getKMSel(distance) - getPromo(distance) + getProteksi(distance);

    }

    @Override
    public int getPromo(double distance) {
        if (distance <= 13 && distance>5) {
            return (int)((distance-5)*this.promo*costPerKM);
        }
        else {
            return (int)(8*this.promo*costPerKM);
        }
    }

    public int getHargaPertama(double distance) {
        return first5KMCost;
    }

    public int getKMSel(double distance) {
        if (distance-5 > 0) {
            return (int)((distance-5) * costPerKM);
        }
        else {
            return 0;
        }
    }

    public int getProteksi(double distance) {
        return (int)((getHargaPertama(distance) + getKMSel(distance) - getPromo(distance)) * protectionCost);
    }
}
