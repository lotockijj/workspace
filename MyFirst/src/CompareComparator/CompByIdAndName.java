package CompareComparator;

import java.util.Comparator;

public class CompByIdAndName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		int flag = o1.getId() - o2.getId();
		
		if(flag == 0) o1.getName().compareTo(o2.getName());

		return flag;
	}
}
