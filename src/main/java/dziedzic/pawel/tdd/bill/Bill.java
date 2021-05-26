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

    public String provideDiscountCode(String discountCode) {
        return discountCode;
    }

    public double provideTotalPrice(double totalPrice) {
        return totalPrice;
    }

    public boolean checkDiscount(String discountCode, double totalPrice) {
        String providedDiscountCode = this.provideDiscountCode(discountCode) ;
        double providedTotalPrice = this.provideTotalPrice(totalPrice);
        return providedDiscountCode.equals("Sale-2021") && providedTotalPrice >= 2000;
    }
    public double calculateDiscount(double totalPrice, boolean acceptDiscount) {
        if(acceptDiscount)
            return totalPrice* 0.9;
        return totalPrice;
    }
}