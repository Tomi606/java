package kr.kh.account.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.account.model.vo.Category;
import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;
import kr.kh.account.pagenation.Criteria;

//3번
public interface AccountService {

	List<Type> getTypeList();

	//@param에 입력된 아이를 호출
	List<Category> getCategoryList(@Param("ty_name")String type);

	boolean insertItem(Item item);

	List<Item> getItemListByDate(String date);

	List<Item> getItemListByDate(Criteria cri);
	
	boolean updateItem(Item item);

	boolean deleteItem(int it_num);


}
