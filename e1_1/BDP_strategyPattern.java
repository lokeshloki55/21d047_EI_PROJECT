package EI_Exercise1;
import java.util.Scanner;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card ending with " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal account " + email);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class BDP_strategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount to checkout: ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Choose payment method (1 for Credit Card, 2 for PayPal): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter Credit Card number: ");
            String cardNumber = scanner.nextLine();
            cart.setPaymentStrategy(new CreditCardPayment(cardNumber));
        } else if (choice == 2) {
            System.out.print("Enter PayPal email: ");
            String email = scanner.nextLine();
            cart.setPaymentStrategy(new PayPalPayment(email));
        } else {
            System.out.println("Invalid choice");
        }

        cart.checkout(amount);
    }
}
