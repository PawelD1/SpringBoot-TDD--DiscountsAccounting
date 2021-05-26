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
        if(providedDiscountCode.equals("Sale-2021") && providedTotalPrice>=2000)
            return true;
        else
            return false;
    }
    public double calculateDiscount(String discountCode, double totalPrice, boolean acceptDiscount) {
        if(acceptDiscount && discountCode.equals("Sale-2021"))
            return totalPrice* 0.9;
        else
            return totalPrice;
    }
}