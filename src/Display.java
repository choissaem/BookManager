import java.io.IOException;
import java.util.Scanner;

public class Display {

	static Scanner scan = new Scanner(System.in);

	public static void printMenu() {
		
		System.out.println("도서 관리 프로그램입니다");
		System.out.println("1. 전체 목록 출력");
		System.out.println("2. 도서 검색");
		System.out.println("3. 신규 도서 추가");
		System.out.println("4. 노후 도서 폐기");
		System.out.println("0. 프로그램 종료");
		
		System.out.println();

	}
	
	public static int selectMenu() throws IOException{
		
		System.out.println();
		printMenu();
		
		int choice = 0;
		System.out.print("선택하세요 : ");
		choice = scan.nextInt();
		
		// System.out.println("선택한 메뉴 : " + choice);
		
		return choice;
	}
	
	public static Book InsertBook(){
		//책이름, 저자, 출판사, 가격
		Book b = new Book();
		System.out.println("추가할 책의 정보를 입력해주세요");
		
		System.out.print("책 이름 : ");
		scan.nextLine();       // clear buffer
		b.setName(scan.nextLine());
		
		System.out.print("저   자 : ");
		b.setAuthor(scan.nextLine());

		System.out.print("출판사 : ");
		b.setPublisher(scan.nextLine());

		System.out.print("가   격 : ");
		b.setCost(scan.nextLine());
		
		return b;
	}

}
