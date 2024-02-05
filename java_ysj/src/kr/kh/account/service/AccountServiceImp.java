package kr.kh.account.service;

import java.io.IOException;
import java.io.InputStream;
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
	public boolean insertItem(Item item, String type) {
		if(item == null) {
			return false;
		}
		List<Category> categoryList = accountDao.selectCategoryList(type);
		System.out.println(categoryList);
		System.out.println(item);
		//type과 일치하지 않은 카테고리 체크
		if(!categoryList.contains(new Category(item.getIt_ca_num()))) {
			return false;
		}
		return accountDao.insertItem(item);
	}

}
