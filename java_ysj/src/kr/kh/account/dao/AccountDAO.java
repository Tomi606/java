package kr.kh.account.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.account.model.vo.Category;
import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;

//5번
public interface AccountDAO {

	List<Type> selectTypeList();

	List<Category> selectCategoryList(String type);

	boolean insertItem(@Param("item")Item item);

	List<Item> selectItemListByDate(@Param("it_date")String dateStr);

	//@Param에 item으로 들어갔기 때문에 item.으로 들어간다.
	boolean updateItem(@Param("item")Item item);

	boolean deleteItem(@Param("it_num")int it_num);

}
