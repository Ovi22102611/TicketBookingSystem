
/**
 * Write a description of class Promotion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Promotion {
    private String promoName;
    private double discount;

    public Promotion(String promoName, double discount) {
        this.promoName = promoName;
        this.discount = discount;
    }

    // Getters
    public double getDiscount() {
        return discount;
    }

    public String getPromoName() {
        return promoName;
    }

    // Setters
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }
}