package designpatterns.seven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConstantDataManager2 {
	public String ACCOUNT_DATA_FILE;
	public int VALID_MIN_LNAME_LEN ;
	public String ADDRESS_DATA_FILE;
	public int VALID_ST_LEN;
	public String VALID_ZIP_CHARS;
	public String DEFAULT_COUNTRY;
	public String CC_DATA_FILE;
	public String VALID_CC_CHARS;
	public String MASTER;
	public String VISA;
	public String DISCOVER;

	private static final String FILENAME = "filename.txt";

	public void readDataFromFile(){

		try(FileReader fr = new FileReader(FILENAME);
				BufferedReader  br = new BufferedReader(fr)){
			ACCOUNT_DATA_FILE = br.readLine();
			VALID_MIN_LNAME_LEN = Integer.parseInt(br.readLine()); 
			ADDRESS_DATA_FILE = br.readLine();
			VALID_ST_LEN = Integer.parseInt(br.readLine());
			VALID_ZIP_CHARS = br.readLine();
			DEFAULT_COUNTRY = br.readLine();
			CC_DATA_FILE = br.readLine();
			VALID_CC_CHARS = br.readLine();
			MASTER = br.readLine();
			VISA = br.readLine(); 
			DISCOVER = br.readLine(); 
		} catch (IOException e){
			System.out.println(e);
		}
	}

}
