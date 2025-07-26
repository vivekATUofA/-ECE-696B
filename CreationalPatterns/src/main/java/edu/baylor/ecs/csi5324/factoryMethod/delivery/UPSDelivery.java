package edu.baylor.ecs.csi5324.factoryMethod.delivery;

import java.math.BigDecimal;

public class UPSDelivery implements Delivery {
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("6.50");
    }

    @Override
    public int getRank() {
        return 3;
    }

    @Override
    public String getProviderName() {
        return "UPS";
    }
}
