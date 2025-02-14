import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter a number: ");
            double number = scanner.nextDouble();
            
            if (number < 0) {
                throw new IllegalArgumentException("Square root of a negative number is not defined in real numbers.");
            }
            
            double squareRoot = Math.sqrt(number);
            System.out.println("Square root: " + squareRoot);
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
