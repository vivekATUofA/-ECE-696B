package edu.baylor.ecs.csi5324.factoryMethod.store;

import java.util.Arrays;
import java.util.List;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.Distributor;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.UPSDistributor;

public class AmazonStore extends Store {
    private List<Distributor> distributors = Arrays.asList(new UPSDistributor());

    @Override
    public List<Distributor> getDistributorList() {
        return distributors;
    }
}
