import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

    @Test
    public void parseStringIntoMoneyShouldReturnMoneyObjectWithValueOfThreeHundredThousandDollars() {
        String moneyString = "$300,000";

        Money money = Util.parseStringIntoMoney(moneyString);

        Assert.assertEquals(Money.of(CurrencyUnit.USD, 300000), money);
    }
}
