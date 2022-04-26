package monRdv.model;

public enum Convention {
	SECTEUR_1("sdqdsd"), SECTEUR_2("dsdsqsqd"), HN("qdsqsdds");
	
	private final String label;

	private Convention(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
	
	
}
