package edu.baylor.ecs.csi5324.factoryMethod;

public class AmazonUserTest {
    public static void main(String[] args) throws Exception {
        Product soap = new AmazonProduct("Soap", "Gentle cleanser", new BigDecimal("5.00"));
        Product brush = new AmazonProduct("Brush", "Soft bristles", new BigDecimal("7.00"));

        AmazonStore store = new AmazonStore();
        store.selectDistributor(0); // Only UPS

        Cart cart = new Cart();
        cart.addLine(soap, 2); // $10 -> 10% off = $9
        cart.addLine(brush, 1); // $7 -> 10% off = $6.30

        store.process(cart);

        System.out.println("Total: " + cart.getTotal()); // Should be 15.30
    }
}
