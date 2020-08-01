package entities;

public final class Company extends Contributors{

	private Integer numberEmployees;
	
	public Company() {
		super();
	}

	public Company(String name, Double annualIncome, Integer numberEmployees) {
		super(name, annualIncome);
		this.numberEmployees = numberEmployees;
	}

	
	public Integer getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(Integer numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	@Override
	public double taxPaid() {
		double tax = 0.0;
		if(numberEmployees < 10) {
			tax = getAnnualIncome() * 0.16;
		} else {
			tax = getAnnualIncome() * 0.14;
		}
		return tax;
	}

	@Override
	public String toString() {
		return getName()+": $"+String.format("%.2f", taxPaid());
	}
	

}
