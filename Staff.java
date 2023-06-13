package assignment8;

public final class Staff implements EmployeeData {
	private String name;
	private double salary;
	private int numDependants;
	public Staff(String name, double salary, int numDependants) {
		this.name = name;
		this.salary = salary;
		this.numDependants = numDependants;
	}

	@Override
	public String getName() {
		return name;
	}
	@Override
	public double getSalary() {
		return salary;
	}
	@Override
	public int getNumDependants() {
		return numDependants;
	}

	@Override
	public double getBonus() {
		return 0;
	}
}
