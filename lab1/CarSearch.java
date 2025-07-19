package searchChallenge;

import java.util.Arrays;
import java.util.List;

public class CarSearch extends GenericSearch<Car, CarSearch.SortCriteria> {

	private static final String[] RESTRICTIONS = {
			"lower(" + SortCriteria.BRAND.getProp() + ") like concat(lower(#{carSearch.car.brand}),'%')",
			"lower(" + SortCriteria.YEAR.getProp() + ") like concat(lower(#{carSearch.car.year}),'%')",
	};

	private Car car = new Car();

	public enum SortCriteria implements SortCriterion {
		BRAND("car.brand"),
		YEAR("car.year");

		private final String prop;

		SortCriteria(String prop) {
			this.prop = prop;
		}

		@Override
		public String getProp() {
			return prop;
		}
	}

	public CarSearch() {
		super(Car.class);
	}

	@Override
	protected SortCriteria[] getSortCriteriaValues() {
		return SortCriteria.values();
	}

	@Override
	protected List<String> getCriteria() {
		return Arrays.asList(RESTRICTIONS);
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
