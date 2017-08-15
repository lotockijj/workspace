package designpatterns.seven;

public class Account implements ConstantDataManager{

	public String getAccountDataFile(){
		String file = ACCOUNT_DATA_FILE;
		return file;
	}
}
