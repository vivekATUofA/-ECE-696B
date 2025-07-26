package edu.baylor.ecs.csi5324.factoryMethod.product;

import java.math.BigDecimal;

public class AmazonProduct extends Product {

    public AmazonProduct(String name, String description, BigDecimal price) {
        super(name, description, price);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().multiply(new BigDecimal("0.90"));
    }
}
