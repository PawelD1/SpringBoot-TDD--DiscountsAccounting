package dziedzic.pawel.tdd.bill;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BillTests {

    private Bill bill;

    @BeforeEach
    public void createBill() {
        this.bill = new Bill(0, "");
    }

    @Test
    public void shouldCreateBill() {
        Assertions.assertEquals(bill.getStartAmount(), 0);
        Assertions.assertEquals(bill.getDiscountCode(), "");
    }

    @Test
    public void shouldGetDiscount() {
        String discountCode = bill.provideDiscountCode("Sale-2021");
        double totalAmount = bill.provideTotalPrice(2000);
        boolean acceptDiscount = bill.checkDiscount(discountCode, totalAmount);
        double calculateDiscount = bill.calculateDiscount(totalAmount, acceptDiscount);

        Assertions.assertTrue(acceptDiscount);
        Assertions.assertEquals(1800, calculateDiscount);
    }

    @Test
    public void shouldNotGetDiscountDueToWrongCode() {
        String discountCode = bill.provideDiscountCode("Sale2021");
        double totalAmount = bill.provideTotalPrice(2000);
        boolean acceptDiscount = bill.checkDiscount(discountCode, totalAmount);
        double calculateDiscount = bill.calculateDiscount(totalAmount, acceptDiscount);

        Assertions.assertFalse(acceptDiscount);
        Assertions.assertEquals(2000, calculateDiscount);
    }

    @Test
    public void shouldNotGetDiscountDueToNotEnoughPrice() {
        String discountCode = bill.provideDiscountCode("Sale-2021");
        double totalAmount = bill.provideTotalPrice(1999);
        boolean acceptDiscount = bill.checkDiscount(discountCode, totalAmount);
        double calculateDiscount = bill.calculateDiscount(totalAmount, acceptDiscount);

        Assertions.assertFalse(acceptDiscount);
        Assertions.assertEquals(1999, calculateDiscount);
    }

    @Test
    public void shouldNotGetDiscountDueToNotEnoughPriceAndWrongCode() {
        String discountCode = bill.provideDiscountCode("Sale-2121");
        double totalAmount = bill.provideTotalPrice(100);
        boolean acceptDiscount = bill.checkDiscount(discountCode, totalAmount);
        double calculateDiscount = bill.calculateDiscount(totalAmount, acceptDiscount);

        Assertions.assertFalse(acceptDiscount);
        Assertions.assertEquals(100, calculateDiscount);
    }
}