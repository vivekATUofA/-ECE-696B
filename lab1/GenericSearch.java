package searchChallenge;

import java.util.List;

public abstract class GenericSearch<T, C extends Enum<C> & SortCriterion> implements ISearch {

	private String orderBy = null;

	protected Class<T> clazz = null;

	public GenericSearch(Class<T> clazz) {
		this.clazz = clazz;
	}

	// subclasses provide their enum values here
	protected abstract C[] getSortCriteriaValues();

	protected BiMap<String, String> getAllowedOrder() {
		BiMap<String, String> allowOrder = new BiMap<>();
		for (C c : getSortCriteriaValues()) {
			allowOrder.put(c.name(), c.getProp());
		}
		return allowOrder;
	}



	// naive search
	@Override
	public List<T> search() {
		List<String> criteriaArray = getCriteria();
		if (criteriaArray != null) {
			System.out.println("---Translated to---");
			System.out.println(" select * from "
					+ clazz.getSimpleName() + " where ");

			for (String criteria : criteriaArray) {
				if (criteria.equals(criteriaArray.get(criteriaArray.size() - 1))) {
					System.out.println(criteria + " ");
				} else {
					System.out.println(criteria + ", ");
				}
			}
			System.out.println(" order by " + orderBy);
			System.out.println("---comments---");
			System.out
					.println("--Our framework would supply the real values for #{params}");

			// here would be database search
			List<T> out = new java.util.ArrayList<>();
			return out;
		} else {
			return null;
		}
	}

	// subclasses provide criteria
	protected abstract List<String> getCriteria();

	@Override
	public String getOrderBy() {
		return getAllowedOrder().getKey(orderBy);
	}

	@Override
	public void setOrderBy(String orderBy) {
		this.orderBy = getAllowedOrder().getValue(orderBy);
	}
}
