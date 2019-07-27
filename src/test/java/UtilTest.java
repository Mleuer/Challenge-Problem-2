import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

    @Test
    public void convertIncomeStringToIntShouldReturnIncomeAsAnInt() {
        String income = "$80,000";

        int actualIncome = Util.convertIncomeStringToInt(income);

        Assert.assertEquals(80000, actualIncome);
    }
}
