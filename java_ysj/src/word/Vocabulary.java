package word;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

//단어장
@Getter
@ToString
public class Vocabulary {

	private List<Word> list;//단어 리스트

	//단어장
	public Vocabulary(List<Word> list) {
		//비어있는 단어장이면
		if(list == null) {
			list = new ArrayList<Word>();
		}
		this.list = list;	//위 word에 this. 안붙이는 이유 : 그냥 위에서 넣고 여기서 바로 넣기위해(위에 넣으면 return 해야함)
	}
	
	//단어 추가 기능
	public boolean addWord(String word, List<Mean> newMeanList) {
		if(list == null) {
			return false;
		}
		int index = list.indexOf(new Word(word));
		
		//새로 추가된 단어이면 단어를 추가
		if(index < 0) {
			list.add(new Word(word, newMeanList));
			return true;
		}
		
		//등록된 단어를 가져옴
		Word selectedWord = list.get(index);
		
		//중복된 뜻이 있으면 중복 안된 뜻들을 확인
		//등록된 단어의 뜻을 가져옴
		List<Mean> selectedMeans = selectedWord.getMeanList();	//contains가 아닌애들(기존에 포함되지 않은 뜻들)
		//새로운 뜻에 중복되지 않은 뜻의 갯수
		int count = (int) newMeanList.stream().filter(m->!selectedMeans.contains(m)).count();
		//다 중복되면
		if(count == 0) {
			return false;
		}
		//하나라도 중복되지 않은 새 뜻이 있으면 기존 뜻에 추가
		newMeanList
		.stream()
		.filter(m->!selectedMeans.contains(m))
		.forEach(m->selectedMeans.add(m));;
			return true;
	}
	
	//단어 수정 기능
	public boolean setWord(String oldWord, String newWord) {
		//list가 없으면
		if(list == null) {
			return false;
		}
		//이미 등록된 단어이면
		if(list.contains(new Word(newWord))) {
			return false;
		}
		//수정할 단어가 없는 단어이면
		int index = list.indexOf(new Word(oldWord));
		if(index < 0) {
			return false;
		}
		//수정
		list.get(index).setWord(newWord);
			return true;
	}
	
	//단어 삭제 기능
	public boolean removeWord(String word) {
		//리스트가 비어있으면
		if(list == null) {
			return false;
		}
		//삭제 후 삭제 여부를 리턴
		return list.remove(new Word(word));
	}

	//뜻 추가
	public boolean addMean(String word, String partOfSpeech, String mean) {
		if(list == null) {
			return false;
		}
		//해당 단어 위치 검색
		int index = list.indexOf(new Word(word));
		//단어가 없으면
		if(index < 0) {
			return false;
		}
		//단어에 뜻을 추가 후 성공 여부를 알려줌.
		Word selectedWord = list.get(index);	//수정하려는 단어
		return selectedWord.addMean(partOfSpeech, mean);
		
	}

	//뜻 수정시 뜻 가져오기
	public Word getWord(String word) {
		int index = list.indexOf(new Word(word));
		/*if(index < 0) {
			return null;
		}
		return list.get(index);*/
		return index < 0 ? null : list.get(index);
	}

	//검색 단어 출력
	public void print(String word) {
		print(word, (w1, w2)->w1.getWord().compareTo(w2.getWord()));
	}
	
	//전체 출력
	public void print() {
		print("");
	}

	//최다 검색 단어
	public void printByViews() {
		print("", (w1,w2)->w2.getViews() - w1.getViews());
	}
	
	private void print(String word, Comparator<Word> c) {
	//여기에 부합하는 단어가 몇개인지
		int count = (int)list.stream().filter(w->w.getWord().contains(word)).count();
		if(count == 0) {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		list.sort(c);
		list.stream()
		//word가 포함된 객체들만 필터링
		.filter(w->w.getWord().contains(word))
		//선택된 반복문을 하나씩 꺼내 출력
		.forEach(w->{
			w.printWord();
			w.views();
		});
	}
}
