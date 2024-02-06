package kr.kh.account.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.account.dao.AccountDAO;
import kr.kh.account.model.vo.Category;
import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;

//4번
public class AccountServiceImp implements AccountService {

	//service는 dao에게 일을 시킴, 하지만 모두 dao에게 시키는 건 아님
	//서비스는 여러 다오는 일을 줄 수 있음
	private AccountDAO accountDao;
	
	public AccountServiceImp() {
		String resource = "kr/kh/account/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			accountDao = session.getMapper(AccountDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Type> getTypeList() {
		return accountDao.selectTypeList();
	}

	@Override
	public List<Category> getCategoryList(String type) {
		if(type == null) {
			return null;
		}
		return accountDao.selectCategoryList(type);
	}

	@Override
	public boolean insertItem(Item item) {
		if(item == null || item.getIt_ty_name() == null) {
			return false;
		}
		if(!checkCategoryNum(item.getIt_ty_name(), item.getIt_ca_num())) {
			return false;
		}
		//위의 if절이 이 구문을 대신해 주고 있다.
//		List<Category> categoryList = accountDao.selectCategoryList(item.getIt_ty_name());
////		System.out.println(categoryList); 확인용
////		System.out.println(item);
//		//type과 일치하지 않은 카테고리 체크
//		if(!categoryList.contains(new Category(item.getIt_ca_num()))) {
//			return false;
//		}
		return accountDao.insertItem(item);
	}

	@Override
	public List<Item> getItemListByDate(String dateStr) {
		if(dateStr == null) {
			return null;
		}
		//날짜 변환이 잘됬다면 (dateStr)를 가져오면서 return
		return accountDao.selectItemListByDate(dateStr);
	}

	@Override
	public boolean updateItem(Item item) {
		if(item == null || item.getIt_ty_name() == null) {
			return false;
		}
		if(!checkCategoryNum(item.getIt_ty_name(), item.getIt_ca_num())) {
			return false;
		}
		return accountDao.updateItem(item);
	}
	//카테고리 번호가 유효한지 아닌지 판별
	private boolean checkCategoryNum(String ty_name, int ca_num) {
		List<Category> categoryList = accountDao.selectCategoryList(ty_name);
		//type과 일치하지 않은 카테고리 체크
		return categoryList.contains(new Category(ca_num));
	}

	@Override
	public boolean deleteItem(int it_num) {
		return accountDao.deleteItem(it_num);
	}

}
