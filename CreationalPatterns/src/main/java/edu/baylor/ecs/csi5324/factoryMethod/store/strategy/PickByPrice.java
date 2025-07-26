package edu.baylor.ecs.csi5324.factoryMethod.store.strategy;

public class PickByPrice implements DistributorPickStrategy {
    @Override
    public Distributor pick(List<Distributor> distributors) {
        return distributors.stream()
                .min(Comparator.comparing(Distributor::getPrice))
                .orElse(null);
    }
}
