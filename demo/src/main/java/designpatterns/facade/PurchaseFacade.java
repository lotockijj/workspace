package designpatterns.facade;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class PurchaseFacade {
	private String name;
	private BigDecimal price;
	private float weight;
	private float capacity;

	private String head;
	private Date date;

	private String details;
	private String description;

	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean savePurchaseData(){
		Item item;
		Header header;
		Details detail;

		boolean validData = true;
		String errorMessage = "";

		item = new Item(name, price, weight, capacity);
		if(item.isValid() == false){
			validData = false;
			errorMessage = "Invalid weight/capacity.";
		}
		header = new Header(head, date);
		if(header.isValid() == false){
			validData = false;
			errorMessage += " Invalid head/date. "; 
		} 
		detail = new Details(details, description);
		if(detail.isValid() == false){
			validData = false;
			errorMessage += " Invalid details, description. ";
		}
		if(!validData){
			System.out.println(errorMessage);
		}
		if(item.save() && header.save() && detail.save()){
			writeDataIntoPropertiesFile();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "PurchaseFacade [name=" + name + ", price=" + price + ", weight=" + weight + ", capacity=" + capacity
				+ ", head=" + head + ", date=" + date + ", details=" + details + ", description=" + description + "]";
	}

	public boolean getDataFromPropertiesFile() throws ParseException{
		Properties p = new Properties();
		boolean result = false;
		try {
			p.load(new FileInputStream("purchase.properties"));
			name = p.getProperty("name");
			price = new BigDecimal(p.getProperty("price"));
			weight = Float.valueOf(p.getProperty("weight"));
			capacity = Float.valueOf(p.getProperty("weight"));
			head = p.getProperty("head");
			date = convertFromStringToSqlDate(p.getProperty("date"));
			details = p.getProperty("date");;
			description = p.getProperty("date");
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return result;
	}

	public void writeDataIntoPropertiesFile() {
		Properties prop = new Properties();
		try (OutputStream output = new FileOutputStream("purchase.properties")){
			prop.setProperty("name", name);
			prop.setProperty("price", price.toString());
			prop.setProperty("weight", String.valueOf(weight));
			prop.setProperty("capacity", String.valueOf(capacity));
			prop.setProperty("head", head);
			prop.setProperty("date", converFromSqlDateToString(date));
			prop.setProperty("details", details);
			prop.setProperty("description", description);
			// save properties to project root folder
			prop.store(output, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Date convertFromStringToSqlDate(String strData) throws ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date date = sdf1.parse(strData);
		java.sql.Date sqlStartDate = new Date(date.getTime());
		return sqlStartDate;
	}

	private String converFromSqlDateToString(Date date){
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
		return DATE_FORMAT.format(date);
	}


}
