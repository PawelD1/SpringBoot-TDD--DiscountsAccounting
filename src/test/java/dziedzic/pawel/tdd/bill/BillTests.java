package dziedzic.pawel.tdd.bill;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BillTests {

    @Test
    public void shouldCreateBill() {
        Bill bill = new Bill();
        Assertions.assertEquals(bill.getStartAmount(), 0);
        Assertions.assertEquals(bill.getDicountCode(), "");
    }
}