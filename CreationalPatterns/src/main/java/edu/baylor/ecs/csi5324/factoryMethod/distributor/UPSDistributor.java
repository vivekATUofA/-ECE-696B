package edu.baylor.ecs.csi5324.factoryMethod.distributor;

import java.math.BigDecimal;
import java.net.URL;
import java.net.MalformedURLException;
import edu.baylor.ecs.csi5324.factoryMethod.cart.Cart;

public class UPSDistributor extends Distributor {

    @Override
    public BigDecimal getCharge() {
        return new BigDecimal("6.75");
    }

    @Override
    public double getRank() {
        return 4.5;
    }

    @Override
    public URL getTrackingLink() throws MalformedURLException {
        return new URL("https://www.ups.com/track");
    }

    @Override
    public void ship(Cart cart) throws Exception {
        shipTracing("UPS", cart);
    }
}
