
public class PaymentAdapterTest {
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern Demo - Payment Processing System ===\n");

        StripeGateway stripeGateway = new StripeGateway();
        PayPalGateway payPalGateway = new PayPalGateway();

      
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalGateway);

        
        System.out.println("Processing payment with Stripe:");
        stripeAdapter.processPayment(100.50);

        System.out.println("\nProcessing payment with PayPal:");
        payPalAdapter.processPayment(75.25);

        System.out.println("\n=== All payments processed successfully! ===");
    }
}
