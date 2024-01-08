package word.service;

import java.util.List;

import word.Word;

public interface FileService {

	//로드
	List<Word> load(String fileName);

	//세이브
	boolean save(String fileName, List<Word> list);

	
}
