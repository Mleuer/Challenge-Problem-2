public class Util {

    public static int convertIncomeStringToInt(String income) {
        StringBuilder newIncome = new StringBuilder(income);

        char currentChar = ' ';
        for (int i = 0; i < newIncome.length(); i++) {
            currentChar = newIncome.charAt(i);
            if (currentChar == '$' || currentChar == ',') {
                newIncome.deleteCharAt(i);
            }
        }
        String incomeAsString = newIncome.toString();
        int incomeAsInt = Integer.parseInt(incomeAsString);
        return incomeAsInt;
    }
}
