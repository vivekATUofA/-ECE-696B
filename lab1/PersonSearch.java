package searchChallenge;

import java.util.Arrays;
import java.util.List;

public class PersonSearch extends GenericSearch<Person, PersonSearch.SortCriteria> {

	private static final String[] RESTRICTIONS = {
			"lower(" + SortCriteria.FIRSTNAME.getProp() + ") like concat(lower(#{personSearch.person.firstName}),'%')",
			"lower(" + SortCriteria.LASTNAME.getProp() + ") like concat(lower(#{personSearch.person.lastName}),'%')",
			"lower(" + SortCriteria.AGE.getProp() + ") like concat(lower(#{personSearch.person.age}),'%')",
	};

	private Person person = new Person();

	public enum SortCriteria implements SortCriterion {
		FIRSTNAME("person.firstName"),
		LASTNAME("person.lastName"),
		AGE("person.age");

		private final String prop;

		SortCriteria(String prop) {
			this.prop = prop;
		}

		@Override
		public String getProp() {
			return prop;
		}
	}

	public PersonSearch() {
		super(Person.class);
	}

	@Override
	protected SortCriteria[] getSortCriteriaValues() {
		return SortCriteria.values();
	}

	@Override
	protected List<String> getCriteria() {
		return Arrays.asList(RESTRICTIONS);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
