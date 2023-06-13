package assignment8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Marketing {
	String employeename;
	String productname;
	double salesamount;

	Marketing(String eName, String pName, double amount) {
		this.employeename = eName;
		this.productname = pName;
		this.salesamount = amount;
	}

	public static void main(String[] args) {
		List<Marketing> marktingList = new ArrayList<>();
		marktingList.add(new Marketing("Dash", "NoteBook", 200000));
		marktingList.add(new Marketing("Billy", "Apple", 19000));
		marktingList.add(new Marketing("Jonhy", "Pen", 100));
		marktingList.add(new Marketing("White", "Bottle", 200));
		marktingList.add(new Marketing("Henry", "Watch", 12000));

		marktingList.sort(Comparator.comparing(Marketing::getSalesamount));

		System.out.println("Size of the list is : " + marktingList.size());
		for (Marketing tmp : marktingList)
			System.out.println(tmp);
		
		marktingList = listMoreThan1000(marktingList);
	
		for (Marketing tmp : marktingList)
			System.out.println(tmp);
		

	}

	public static List<Marketing> listMoreThan1000(List<Marketing> list) {

		list.sort(Comparator.comparing(Marketing::getEmployeename).thenComparingDouble(Marketing:: getSalesamount)
                .reversed());
	    
		list.removeIf(employee -> employee.getSalesamount() <= 1000.0);
		
		return list;
	}

	@Override
	public String toString() {
		return "Item: { " + "EmployeeName: " + employeename + " ProductName: " + productname + " SalesAmount: "
				+ salesamount + " }";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Marketing mark = (Marketing) obj;
		return Objects.equals(mark.employeename, this.employeename)
				&& Objects.equals(mark.productname, this.productname) && mark.salesamount == this.salesamount;

	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getSalesamount() {
		return salesamount;
	}

	public void setSalesamount(double salesamount) {
		this.salesamount = salesamount;
	}

}
