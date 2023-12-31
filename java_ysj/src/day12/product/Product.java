package day12.product;

import lombok.Data;

@Data
public abstract class Product {
	String brand, name, code;
	
	public Product(String brand, String name, String code) {
		this.brand = brand;
		this.name = name;
		this.code = code;
	}
	
	public abstract void print();
	
}

class Tv extends Product {
	int size;
	
	public Tv(String brand, String name, String code, int size) {
		super(brand, name, code);
		this.size = size;
	}

	@Override
	public void print() {
		System.out.println("브랜드 : " + brand);
		System.out.println("제품코드 : " + code);
		System.out.println("제품명 : " + name);
		System.out.println("화면크기(cm) : " + size);
		System.out.println("----------------");
	}
}

class Airconditioner extends Product {
	int cool;
	
	public Airconditioner(String brand, String name, String code, int cool) {
		super(brand, name, code);
		this.cool = cool;
	}

	@Override
	public void print() {
		System.out.println("브랜드 : " + brand);
		System.out.println("제품코드 : " + code);
		System.out.println("제품명 : " + name);		
		System.out.println("냉방면적(m2) : " + cool);
		System.out.println("----------------");

	}
}

class Computer extends Product {
	int ram, cpu;
	
	public Computer(String brand, String name, String code, int ram, int cpu) {
		super(brand, name, code);
		this.ram = ram;
		this.cpu = cpu;
	}

	@Override
	public void print() {
		System.out.println("브랜드 : " + brand);
		System.out.println("제품코드 : " + code);
		System.out.println("제품명 : " + name);		
		System.out.println("RAM : " + ram + "G");
		System.out.println("CPU : " + cpu + "GHz");
		System.out.println("----------------");

	}

}