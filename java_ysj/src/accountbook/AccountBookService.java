package accountbook;

import java.util.List;

public interface AccountBookService {

	//가계부(리스트)에 수입, 지출 내역을 추가하는 메서드
	boolean addItem(List<Item> list, Item item);
	
	//가계부(리스트)에 내역을 수정하는 메서드
	boolean updateItem(List<Item> list, String title, int money);
	
}
