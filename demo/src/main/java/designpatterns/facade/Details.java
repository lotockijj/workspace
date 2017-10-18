package designpatterns.facade;

public class Details {
	private String details;
	private String description;

	public Details(String name, String description) {
		this.details = name;
		this.description = description;
	}

	public boolean isValid(){
		if(details.length() > 0 && description.length() > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean save(){
		if(isValid()){
			System.out.println(details + " || " + description);
			return true;
		} else {
			return false;
		}
	}
	
	public String getName() {
		return details;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.details = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
