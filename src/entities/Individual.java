package entities;

public final class Individual extends Contributors {
	private Double healthSpending;

	public Individual() {
		super();
	}

	public Individual(String name, Double annualIncome, Double healthSpending) {
		super(name, annualIncome);
		this.healthSpending = healthSpending;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	@Override
	public double taxPaid() {
		double tax = 0.0;
		if (getAnnualIncome() <  20000.00 ) {
			tax = (getAnnualIncome() * 0.15) - (healthSpending * 0.5);
		} else {
			tax = (getAnnualIncome() * 0.25) - (healthSpending * 0.5);
		}
		return tax;
	}

	@Override
	public String toString() {
		return getName()+": $"+String.format("%.2f", taxPaid());
	}
	

}
