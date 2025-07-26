package edu.baylor.ecs.csi5324.factoryMethod.store.strategy;

public interface DistributorPickStrategy {
    Distributor pick(List<Distributor> distributors);
}
