package day11.product;

public class Product {

	private String name;
	private int buyPrice, price, salePrice, amount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	//제품정보 출력
	public void print() {
		System.out.println("제품명 : " + name + ", 수량 : " + amount + ", 가격 : " + salePrice);
	}
	
	//할인금액 수정
	public void updateSalePrice(int price) {
		salePrice = price;
	}
	
	//개수 수정(새수량 누적)
	public void updateAmount(int amount) {
		this.amount += amount;
	}
	
	//입력한 제품명과 동일한지 확인
	public boolean equals(String name) {
		return this.name.equals(name);
	}
	
	//생성자
	public Product(String name, int amount, int buyPrice, int price) {
		this.name = name;
		this.amount = amount;
		this.buyPrice = buyPrice;
		this.price = price;
		this.salePrice = price;
	}
}
