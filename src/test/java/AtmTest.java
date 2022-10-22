import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtmTest {

    Atm underTest = new Atm(50, "1234");

    @Test
    public void shouldHaveDefaultBalanceof50() {
        int actualBalance = underTest.getBalance();
        assertEquals(50, actualBalance);
    }

    @Test
    public void shouldHaveDefaultBalanceof100() {
        Atm underTest = new Atm(100, "1234");
        int actualBalance = underTest.getBalance();
        assertEquals(100, actualBalance);
    }

    @Test
    public void depositof50ShouldIncreaseAnInitialBalanceOf50to100() {
        underTest.deposit(50);
        int actualBalance = underTest.getBalance();
        assertEquals(100, actualBalance);
    }

    @Test
    public void withdrawalOf50ShouldDecreaseAnInitialBalanceof50to0() {
        underTest.withdrawal(50);
        int actualBalance = underTest.getBalance();
        assertEquals(0, actualBalance);
    }

    @Test
    public void withdrawalof51ShouldReturnOriginalBalance0f50() {
        underTest.withdrawal(51);
        int actualBalance = underTest.getBalance();
        assertEquals(50, actualBalance);
    }

    @Test
    public void shouldAllowUserAccessWithCorrectPin() {
        boolean accessResult = underTest.allowAccess("1234");
        assertEquals(true, accessResult);
    }

    @Test
    public void shouldDenyUserAccessWithIncorrectPin() {
        boolean accessResult = underTest.allowAccess("1111");
        assertEquals(false, accessResult);
    }
}