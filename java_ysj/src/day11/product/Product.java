package day11.product;

public class Product {

	private String product;	//제품이름
	private int price, sale, productCount, totalPrice;	//가격, 세일, 제품수량, 총매출
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
	//메서드
	
	//제품이름 : 가격(원)  개수
	public Product(String product1, int price1, int productCount1) {
		this.product = product1;
		this.price = price1;
		this.productCount = productCount1;
		System.out.println(product1 + " : " + price1 + "원  " + productCount1 + "개");
	}
	
	//판 제품의 가격만큼 매출 증가
	public void sellProduct(String product1, int price1, int productCount1) {
		this.product = product1;
		this.price = price1;
		this.productCount = productCount1;
		System.out.println(product1 + "제품이 판매되었습니다.");
		System.out.println(price + "원 받았습니다.");
	}
	
	//제품명을 입력하면 가격을 수정하는 코드
	public void update(int price) {
		this.price = price;
	}
	
	//제품명을 입력하면 같은 제품인지 확인하는 코드 -> 맞는지 아닌지 = boolean
	public boolean equals(String product) {
		return this.product.equals(product);
	}
}
