package searchChallenge;

public class Main  {
	
	public static void main(String[] args) {
		PersonSearch personSearch = new PersonSearch();
		personSearch.setOrderBy("FIRSTNAME");
		personSearch.getPerson().setLastName("%Bob%");
		personSearch.search();
		System.out.println(System.getProperty("line.separator"));
		CarSearch carSearch = new CarSearch();
		carSearch.setOrderBy("YEAR");
		carSearch.getCar().setBrand("%Ford%");
		carSearch.search();
	}
	
	
}
