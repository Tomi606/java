package day09.board;

public class CheckUp {

	//멤버변수
	private int id;	//생년월일
	//간기능
	private int totalpro, al, ast, alt, alp;
	//콜레스테롤
	private int totalcho, hdl, ldl, fat;
	//당뇨검사
	private int glucose,a1c;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalpro() {
		return totalpro;
	}

	public void setTotalpro(int totalpro) {
		this.totalpro = totalpro;
	}

	public int getAl() {
		return al;
	}

	public void setAl(int al) {
		this.al = al;
	}

	public int getAst() {
		return ast;
	}

	public void setAst(int ast) {
		this.ast = ast;
	}

	public int getAlt() {
		return alt;
	}

	public void setAlt(int alt) {
		this.alt = alt;
	}

	public int getAlp() {
		return alp;
	}

	public void setAlp(int alp) {
		this.alp = alp;
	}

	public int getTotalcho() {
		return totalcho;
	}

	public void setTotalcho(int totalcho) {
		this.totalcho = totalcho;
	}

	public int getHdl() {
		return hdl;
	}

	public void setHdl(int hdl) {
		this.hdl = hdl;
	}

	public int getLdl() {
		return ldl;
	}

	public void setLdl(int ldl) {
		this.ldl = ldl;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getGlucose() {
		return glucose;
	}

	public void setGlucose(int glucose) {
		this.glucose = glucose;
	}

	public int getA1c() {
		return a1c;
	}

	public void setA1c(int a1c) {
		this.a1c = a1c;
	}

	//메서드
	
	//범위 입력
	public static void liverInfo() {
		System.out.println("[간기능]");
		System.out.println("총단백 : 6.0-8.3g/dl");
		System.out.println("알부민 : 3.5-5.2g/dl");
		System.out.println("AST : 0-32IU/L");
		System.out.println("ALT : 0-34IU/L");
		System.out.println("ALP : 40-150IU/L");
	}
	public static void choInfo() {
		System.out.println("[콜레스테롤]");
		System.out.println("총콜레스테롤 : 120-199mg/dl");
		System.out.println("HDL-콜레스테롤 : 40-60mg/dl");
		System.out.println("LDL-콜레스테롤 : 50-129mg/dl");
		System.out.println("중성지방 : 50-149mg/dl");
	}
	public static void sugarInfo() {
		System.out.println("[당뇨검사]");
		System.out.println("공복혈당 : 70-99mg/dl");
		System.out.println("당화혈색소 : 4.4-6.4%");
	}

	
	
	
	//생성자
}
