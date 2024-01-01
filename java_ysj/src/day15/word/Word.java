package day15.word;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * word : 단어
 * mean : 뜻 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Word {
	private String word, mean;
	
	//단어 : 뜻 출력
	public void print() {
		System.out.println(word + " : " + mean);
	}
	
	//단어 수정
	public void updateWord(String word) {
		 this.word = word;
	}
	
	//뜻 수정
	public void updateMean(String mean) {
		this.mean = mean;
	}
	
}
