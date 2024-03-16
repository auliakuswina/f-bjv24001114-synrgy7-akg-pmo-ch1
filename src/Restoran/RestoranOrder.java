package Restoran;
import java.util.Scanner;
public class RestoranOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Restaurant Order System!");

        // Example menu items with prices
        double burgerPrice = 8.99;
        double pizzaPrice = 12.50;
        double saladPrice = 5.99;

        // Variables to store order quantities
        int burgerQuantity = 0;
        int pizzaQuantity = 0;
        int saladQuantity = 0;

        // Order input
        System.out.print("Enter the quantity of burgers: ");
        burgerQuantity = scanner.nextInt();

        System.out.print("Enter the quantity of pizzas: ");
        pizzaQuantity = scanner.nextInt();

        System.out.print("Enter the quantity of salads: ");
        saladQuantity = scanner.nextInt();

        // Calculate total cost
        double totalCost = (burgerPrice * burgerQuantity) + (pizzaPrice * pizzaQuantity) + (saladPrice * saladQuantity);

        // Display order summary
        System.out.println("\nOrder Summary:");
        System.out.println("Burgers: " + burgerQuantity + " x $" + burgerPrice + " = $" + (burgerPrice * burgerQuantity));
        System.out.println("Pizzas: " + pizzaQuantity + " x $" + pizzaPrice + " = $" + (pizzaPrice * pizzaQuantity));
        System.out.println("Salads: " + saladQuantity + " x $" + saladPrice + " = $" + (saladPrice * saladQuantity));
        System.out.println("\nTotal Cost: $" + totalCost);

        // Close scanner
        scanner.close();
    }
}

