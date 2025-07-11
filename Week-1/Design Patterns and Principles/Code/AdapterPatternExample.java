interface PaymentProcessor {
    void process(double amount);
}

class PayPalService {
    public void send(double amount) {
        System.out.println("PayPal Payment Successful: " + amount);
    }
}

class StripeService {
    public void pay(double amount) {
        System.out.println("Stripe Payment Successful: " + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalService service;

    public PayPalAdapter(PayPalService service) {
        this.service = service;
    }

    public void process(double amount) {
        service.send(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeService service;

    public StripeAdapter(StripeService service) {
        this.service = service;
    }

    public void process(double amount) {
        service.pay(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalService());
        paypal.process(899.99);

        PaymentProcessor stripe = new StripeAdapter(new StripeService());
        stripe.process(1999.99);
    }
}
