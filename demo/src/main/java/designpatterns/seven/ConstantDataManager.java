package designpatterns.seven;

interface ConstantDataManager {
	String ACCOUNT_DATA_FILE = "ACCOUNT.TXT";
	int VALID_MIN_LNAME_LEN = 2;
	String ADDRESS_DATA_FILE = "ADDRESS.TXT";
	int VALID_ST_LEN = 2;
	String VALID_ZIP_CHARS = "0123456789";
	String DEFAULT_COUNTRY = "USA";
	String CC_DATA_FILE = "CC.TXT";
	String VALID_CC_CHARS = "0123456789";
	String MASTER = "MASTER";
	String VISA = "VISA";
	String DISCOVER = "DISCOVER";
}
