package accountbook;

import java.util.List;

import program.Program;

public class AccountBookeProgram implements Program {

	List<Item> list;//수입 지출 내역
	
	private AccountBookService accountBookService = new AccountBookServiceImp();
	private Fileservice fileService = new FileServiceImp();
	
	@Override
	public void run() {
		
	}

	@Override
	public void printMenu() {
		
	}

	@Override
	public void runMenu(int menu) {
		
	}

}
