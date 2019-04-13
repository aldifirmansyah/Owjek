/**
 * Created by Aldi Firmansyah on 4/27/2017.
 */
public class OwjekRegular extends Owjek implements Payable {
    private final int first2KMCost = 3000;

    public OwjekRegular() {
        this.minYearAllowed = 2012;
        this.costPerKM = 1000;
        this.promo = 0.4;
    }

    @Override
    public int getCost(double distance) {
        return getHargaPertama(distance) + getKMSel(distance) - getPromo(distance);
    }

    @Override
    public int getPromo(double distance) {
        if (distance <= 8 && distance>2) {
            return (int)((distance-2)*this.promo*costPerKM);
        }
        else {
            return (int)(6*this.promo*costPerKM);
        }
    }

    public int getHargaPertama(double distance) {
        return first2KMCost;
    }

    public int getKMSel(double distance) {
        if (distance - 2 > 0) {
            return (int)((distance-2)*costPerKM);
        }
        else {
            return 0;
        }
    }
}
