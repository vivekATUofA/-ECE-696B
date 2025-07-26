package edu.baylor.ecs.csi5324.factoryMethod.store.strategy;

public class PickByRank implements DistributorPickStrategy {
    @Override
    public Distributor pick(List<Distributor> distributors) {
        return distributors.stream()
                .min(Comparator.comparingInt(Distributor::getRank))
                .orElse(null);
    }
}
