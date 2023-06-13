package assignment8;
import java.util.*;
public class Statistics{
	/** 
	 * Polymorphically computes and returns the sum
	 * of all the salaries of all the staff/teachers in the list.
	 */
	public static double computeSumOfSalaries(List<EmployeeData> aList) {
		int sumSalary = 0;

		for(EmployeeData tmp : aList)
			sumSalary += tmp.getSalary();

		return sumSalary;
		//implement
		//compute sum of all salaries of people in aList and return
	}
}
