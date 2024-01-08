package word;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

//영어 단어의 "단어"를 의미하는 클래스로, 단어를 멤버로 가짐
@Data
@AllArgsConstructor
public class Word {

	private String word;	//단어
	private List<Mean> meanList;	//품사와 뜻 리스트(뜻은 여러개라서)
	private int views;	//조회수
	
	//단어만 똑같으면 같은 단어로 판별하기 위해 재정의, 단어 추가 수정할 때 편함
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}
	@Override
	public int hashCode() {
		return Objects.hash(word);
	}
	
	//단어와 뜻 리스트를 출력하는 메서드
	public void printWord() {
		System.out.println("단어 : " + word);
		//뜻 리스트가 null 이거나 뜻 리스트 사이즈가 0이면 nullPointException이 나올 수 있어서
		if(meanList == null || meanList.size() == 0) {
			System.out.println("등록된 뜻이 없습니다.");
		}
		//"1. 품사 뜻"(향상된 for문 X)으로 출력
		for(int i=0; i<meanList.size(); i++) {
			//toString을 오버라이딩 했기 때문에 Mean의 toString 양식대로 나옴.
			System.out.println((i+1) + ". " + meanList.get(i));
		}
	}
	
	//뜻을 추가하는 메서드
	public boolean addMean(String partOfSpeech, String mean) {
		//뜻을 저장하는 뜻리스트가 생성되어 있지 않으면
		if(meanList == null) {
			return false;
		}
		//이미 등록된 뜻이면
		if(meanList.contains(new Mean(null, mean))) {			
			return false;
		}
		//새 뜻을 추가
		meanList.add(new Mean(partOfSpeech, mean));
			return true;
	}
	
	//뜻을 수정하는 메서드, pos : 위치
	public boolean setMean(int pos, String partOfSpeech, String mean) {
		//뜻을 저장하는 뜻리스트가 생성되어 있지 않으면
		if(meanList == null) {
			return false;
		}
		//pos(위치)가 잘못된 경우(0보다 작거나 뜻리스트 사이즈보다 클 경우)
		if(pos < 0 || pos >= meanList.size()) {
			return false;
		}
		//이미 등록된 뜻이면
		if(meanList.contains(new Mean(mean))) {
			return false;
		}
		//수정
		meanList.set(pos, new Mean(partOfSpeech, mean));
			return true;
	}
	
	//뜻을 삭제하는 메서드
	public boolean removeMean(int pos) {
		//뜻을 저장하는 뜻리스트가 생성되어 있지 않으면
		if(meanList == null) {
			return false;
		}
		//pos(위치)가 잘못된 경우(0보다 작거나 뜻리스트 사이즈보다 클 경우)
		if(pos < 0 || pos >= meanList.size()) {
			return false;
		}
		meanList.remove(pos);		
		return true;
	}
	@Override
	public String toString() {
		return "단어 : " + word + "\n" + meanList + "\n조회수 : " + views;
	}
	
	public Word(String word) {
		this.word = word;
	}
	
	public Word(String word, String partOfSpeech, String mean) {
		this.word = word;
		meanList = new ArrayList<Mean>();
		meanList.add(new Mean(partOfSpeech, mean));
	}
	
	
}

/* 메서드는 "하나의 기능만" 하는게 좋다.
 * O : print() -> 출력하는 기능만
 * X : 뜻 추가 메서드 -> 뜻 추가 코드 + 출력 코드 -> 뜻 추가만하는 메서드인데 굳이 출력 코드까지 넣을 필요 없다.*/
