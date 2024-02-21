package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpeding;
	private Double educationSpeding;

	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpeding,
			Double educationSpeding) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpeding = healthSpeding;
		this.educationSpeding = educationSpeding;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpeding() {
		return healthSpeding;
	}

	public void setHealthSpeding(Double healthSpeding) {
		this.healthSpeding = healthSpeding;
	}

	public Double getEducationSpeding() {
		return educationSpeding;
	}

	public void setEducationSpeding(Double educationSpeding) {
		this.educationSpeding = educationSpeding;
	}
	
	
	public Double salaryTax() {
		double taxSalary, monthlySalary;
		
		monthlySalary = salaryIncome / 12;
		
		if(monthlySalary >= 3000 && monthlySalary < 5000) {
			return taxSalary = salaryIncome * 0.1;
		} else if (monthlySalary >= 5000) {
			return taxSalary = salaryIncome * 0.2;
		} else {
			return null;
		}
	}
	
	public Double servicesTax() {
		double taxServices;
		
		return taxServices = servicesIncome * 0.15;
	}
	
	public Double capitalTax() {
		double taxCapital;
		
		return taxCapital = capitalIncome * 0.2;
	}
	
	public Double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public Double taxRebate() {
		double percentageRebateTax, rebateTax;
		
		percentageRebateTax = (healthSpeding + educationSpeding) / this.grossTax();
		rebateTax = this.grossTax() * 0.3;
		
		if(percentageRebateTax >= 0.3) {
			return rebateTax;
		} else {
			return healthSpeding + educationSpeding;
		}
	}
	
	public Double netTax() {
		return this.grossTax() - this.taxRebate();
	}

}
