package day10.word;

public class Word {

	//멤버변수
	String word, mean;
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	//메서드
	//입력된 단어 출력
	public void printWord(String word, String mean) {
		System.out.println(word + " : " + mean);
	}
	
	//단어추가
	public void update(String word, String mean) {
		this.word = word;
		this.mean = mean;
	}
	static String a[] = new String[5];
	public static void main(String[] args) {
		for(int i=0;i<a[i].length();i++) {
			String[] Word = {"attack","advance","arm","age","art"};
			String[] Mean = {"폭행, 공격","전진, 발전","팔","나이,연령","미술,예술"};
		}
	}
}