package day09.board;

public class Human {
	
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
	
	//사람 정보 출력
		public void humanInfo() {
			System.out.println("생년월일 6자리 입력 : " + id);
		}
	
		
	//결과치 정보 출력
		public void resultInfo() {
			System.out.println("[간기능]");
			System.out.println("총단백 : " + totalpro);
			System.out.println("알부민 : " + al);
			System.out.println("AST : " + ast);
			System.out.println("ALT : " + alt);
			System.out.println("ALP : " + alp);
			System.out.println();
			
			System.out.println("[콜레스테롤]");
			System.out.println("총콜레스테롤 : " + totalcho);
			System.out.println("HDL-콜레스테롤 : " + hdl);
			System.out.println("LDL-콜레스테롤 : " + ldl);
			System.out.println("중성지방 : " + fat);
			System.out.println();
			
			System.out.println("[당뇨검사]");
			System.out.println("공복혈당 : " + glucose);
			System.out.println("당화혈색소 : " + a1c);
		}
	//id와 hm[i]가 일치하면 결과를 출력
	
		
		
		
		
		
		
	public static void main(String [] args) {
		Human hm[] = new Human[5];
		
		
		
		
	}
}
