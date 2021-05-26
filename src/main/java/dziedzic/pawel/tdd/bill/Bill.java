package dziedzic.pawel.tdd.bill;

public class Bill {
    private final double startAmount;
    private final String discountCode;

    public Bill(double startAmount, String discountCode) {
        this.startAmount = startAmount;
        this.discountCode = discountCode;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public String getDiscountCode() {
        return discountCode;
    }
}