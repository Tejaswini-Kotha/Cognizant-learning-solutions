public class FinancialForecast {

    public static double calculateRecursive(double amount, double rate, int years) {
        if (years == 0) {
            return amount;
        }
        return calculateRecursive(amount, rate, years - 1) * (1 + rate);
    }

    public static double calculateIterative(double amount, double rate, int years) {
        double result = amount;
        for (int i = 0; i < years; i++) {
            result *= (1 + rate);
        }
        return result;
    }

    public static void main(String[] args) {
        double initialAmount = 10000;
        double growthRate = 0.10;
        int years = 5;

        System.out.println(" Financial Forecast");
        System.out.println("\n Initial Amount -> " + initialAmount);
        System.out.println("Annual Growth Rate -> " + (growthRate * 100) + "%");
        System.out.println("Duration -> " + years + " years");

        double resultRecursive = calculateRecursive(initialAmount, growthRate, years);
        double resultIterative = calculateIterative(initialAmount, growthRate, years);

        System.out.println("\nResults:");
        System.out.printf("Recursive Calculation -> %.2f\n", resultRecursive);
        System.out.printf("Iterative Calculation -> %.2f\n", resultIterative);
    }
}
