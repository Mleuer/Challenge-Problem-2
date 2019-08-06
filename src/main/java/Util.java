import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class Util {

    public static Money parseStringIntoMoney(String moneyString) {
        StringBuilder moneyBuilder = new StringBuilder(moneyString);
        for (int i = 0; i < moneyBuilder.length(); i++) {
            char currentChar = moneyBuilder.charAt(i);
            if (currentChar == ',' || currentChar == '$') {
                moneyBuilder.deleteCharAt(i);
            }
        }
        double moneyValue = Double.parseDouble(moneyBuilder.toString());
        Money money = Money.of(CurrencyUnit.USD, moneyValue);
        return money;
    }
}
