package day18.student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentProgram implements Program {
	
	private Scanner sc = new Scanner(System.in);
	private StudentManager sm = new StudentManager();
	private Socket socket = new Socket();
	private final int EXIT = 4;

	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	@Override
	public void run() {
		//클라이언트 ip,port
		String ip = "192.168.30.189";
		int port = 5001;
		//서버와 연결
		connectServer(ip, port);
		//텍스트 로드(불러오기)
		load();
		int menu = 0;
		do {
			printMenu();
			try {
			menu = sc.nextInt();
			runMenu(menu);
			} catch(InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
				sc.nextLine();
			}
		}while(menu != EXIT);
	}
	
	private void connectServer(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			System.out.println(socket);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			System.out.println("서버 연결 성공");
		} catch (IOException e) {
			System.out.println("서버 연결 실패");
		}
	}
	
	private void load() {
		if(socket == null) {
			System.out.println("서버에 연결되지 않아 불러올 수 없습니다.");
		}
		try {
			oos.writeUTF("LOAD");
			oos.flush();
			
			//읽어옴
			ArrayList<Student> list = (ArrayList<Student>)ois.readObject();
			sm = new StudentManager(list);
			System.out.println("불러오기 성공");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("불러오기 중 예외가 발생했습니다.");
		}
	}

	@Override
	public void printMenu() {
		System.out.println("---메뉴---");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 조회(전체)");
		System.out.println("3. 학생 수정(이름)");
		System.out.println("4. 종료");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1 : insertStudent();
			break;
			
		case 2 : sm.printStudent();
			break;
			
		case 3 : updateStudent();
			break;

		case 4 : 
			exit();
			System.out.println("프로그램을 종료합니다.");
			break;
			
		default : throw new InputMismatchException();
		}
	}

	private void updateStudent() {
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int num = sc.nextInt();
		System.out.print("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		Student std = new Student(grade, classNum, num, name);
		if(sm.updateStudent(std)) {
			System.out.println("이름을 수정했습니다.");
			sendUpdateStudent(std);
		} else {
			System.out.println("등록되지 않은 학생입니다.");
		}
		
		
	}

	private void sendUpdateStudent(Student std) {
		try {
			oos.writeUTF("UPDATE");
			oos.flush();
			oos.writeObject(std);
			oos.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void exit() {
		try {
			oos.writeUTF("SAVE");
			oos.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//1. 학생 등록
	private void insertStudent() {
		System.out.println("등록할 학생 학년, 반, 번호, 이름을 입력하세요.");
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int num = sc.nextInt();
		System.out.print("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		Student std = new Student(grade, classNum, num, name);
		
		if(sm.insertStudent(std)) {
			System.out.println("학생을 추가했습니다.");
			sendStudent(std);
		}
		System.out.println("이미 등록되있습니다.");
	}

	private void sendStudent(Student std) {
		if(socket == null) {
			System.out.println("서버에 연결되지 않아 학생 정보를 추가할 수 없습니다.");
		}
		try {
			oos.writeUTF("INSERT");
			oos.flush();
			oos.writeObject(std);
			oos.flush();
			System.out.println("서버에 학생 추가 성공");
		} catch (IOException e) {
			System.out.println("서버에 학생 추가 중 예외가 발생했습니다.");
		}
	}

}
