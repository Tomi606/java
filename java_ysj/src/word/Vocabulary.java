package word;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

@ToString
public class Vocabulary {

	private List<Word> list;

	//단어장
	public Vocabulary(List<Word> list) {
		//비어있는 단어장이면
		if(list == null) {
			list = new ArrayList<Word>();
		}
		this.list = list;	//위 word에 this. 안붙이는 이유 : 그냥 위에서 넣고 여기서 바로 넣기위해(위에 넣으면 return 해야함)
	}
	
	//단어 추가 기능
	public boolean addWord(String word, String partOfSpeech, String mean) {
		if(list == null) {
			return false;
		}
		//이미 등록된 단어이고, 뜻도 등록되었으면
		int index = list.indexOf(new Word(word));
		//인덱스가 0보다 크거나 해당번지에 있는 뜻을. 뜻리스트에서 가져와서. 입력한 뜻과 같으면.
		if(index >= 0 && list.get(index).getMeanList().contains(new Mean(mean))) {
			return false;
		}
		//이미 등록된 단어이면
		if(index >= 0) {
			list.get(index).addMean(partOfSpeech, mean);
			return true;
		}
		//새로 추가된 단어이면(여기까지 왔다는게 새 단어라는 뜻)
		list.add(new Word(word, partOfSpeech, mean));
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
}
