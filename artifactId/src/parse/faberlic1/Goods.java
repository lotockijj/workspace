package parse.faberlic1;

import java.math.BigDecimal;

public class Goods {
	
	String discount;
	int page;
	String article;
	String name;
	
	BigDecimal priceCatalog;
	BigDecimal theSame;
	String allowance;
	BigDecimal priceStore;
	float ballConsultant;
	BigDecimal priceBuyer;
	float ballBuyer;
	
	public Goods(){
		
	}
	
	public Goods(String discount, int page, String article, String name, 
			BigDecimal priceCatalog, BigDecimal theSame, String allowance, 
			BigDecimal priceStore, float ballConsultant, BigDecimal priceBuyer, 
			float ballBuyer) {
		this.discount = discount;
		this.page = page;
		this.article = article;
		this.name = name;
		this.priceCatalog = priceCatalog;
		this.theSame = theSame;
		this.allowance = allowance;
		this.priceStore = priceStore;
		this.ballConsultant = ballConsultant;
		this.priceBuyer = priceBuyer;
		this.ballBuyer = ballBuyer;
	}

	public String getDiscount() {
		return discount;
	}

	public int getPage() {
		return page;
	}

	public String getArticle() {
		return article;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPriceCatalog() {
		return priceCatalog;
	}

	public BigDecimal getTheSame() {
		return theSame;
	}

	public String getAllowance() {
		return allowance;
	}

	public BigDecimal getPriceStore() {
		return priceStore;
	}

	public float getBallConsultant() {
		return ballConsultant;
	}

	public BigDecimal getPriceBuyer() {
		return priceBuyer;
	}

	public float getBallBuyer() {
		return ballBuyer;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPriceCatalog(BigDecimal priceCatalog) {
		this.priceCatalog = priceCatalog;
	}

	public void setTheSame(BigDecimal theSame) {
		this.theSame = theSame;
	}

	public void setAllowance(String allowance) {
		this.allowance = allowance;
	}

	public void setPriceStore(BigDecimal priceStore) {
		this.priceStore = priceStore;
	}

	public void setBallConsultant(float ballConsultant) {
		this.ballConsultant = ballConsultant;
	}

	public void setPriceBuyer(BigDecimal priceBuyer) {
		this.priceBuyer = priceBuyer;
	}

	public void setBallBuyer(float ballBuyer) {
		this.ballBuyer = ballBuyer;
	}

	@Override
	public String toString() {
		return "Goods [discount= " + discount + ", page= " + page + ", article= " + article + ", name= " + name
				+ ", priceCatalog= " + priceCatalog + ", theSame= " + theSame + ", allowance= " + allowance
				+ ", priceStore= " + priceStore + ", ballConsultant= " + ballConsultant + ", priceBuyer= " + priceBuyer
				+ ", ballBuyer= " + ballBuyer + "]";
	}

}
