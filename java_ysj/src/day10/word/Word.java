package day10.word;

public class Word {

	//멤버변수
	String word, mean;
	
	
	//입력된 단어 출력
	public void printWord(String word, String mean) {
		System.out.println(word + " : " + mean);
	}
	
	//단어추가
	public void update(String word, String mean) {
		this.word = word;
		this.mean = mean;
	}
}
