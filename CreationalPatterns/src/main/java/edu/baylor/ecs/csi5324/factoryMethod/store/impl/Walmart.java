package edu.baylor.ecs.csi5324.factoryMethod.store.impl;

import java.util.Arrays;
import java.util.List;

import edu.baylor.ecs.csi5324.factoryMethod.cart.Cart;
import edu.baylor.ecs.csi5324.factoryMethod.cart.CartLineItem;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.Distributor;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.impl.USPS;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.impl.DPD;
import edu.baylor.ecs.csi5324.factoryMethod.product.Product;
import edu.baylor.ecs.csi5324.factoryMethod.store.Store;

public class Walmart extends Store {

	private List<Distributor> distributorList = null;

	public Walmart() {
		Distributor[] distributors = { new USPS(), new DPD() };
		distributorList = Arrays.asList(distributors);
	}

	public Walmart(List<Distributor> distributorList) {
		this.distributorList = distributorList;
	}

	@Override
	public List<Distributor> getDistributorList() {
		return distributorList;
	}

	@Override
	protected void hookProcess(Cart order) throws Exception {
		System.out.println(Walmart.class.getSimpleName() + " is happy for your order");
		for (CartLineItem line : order.getOrderList()) {
			Product product = line.getProduct();
			System.out.println("+ " + product.getName() + " " + line.getQuantity() + "x " + product.getPrice());

		}
		System.out.println("Total: " + order.getTotal());

	}

}
