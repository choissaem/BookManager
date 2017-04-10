import java.io.IOException;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		Manager mg = new Manager();
		
		int choice = -1;
		
		System.out.println("안녕하세요");
		
		while(choice != 0){
			
			choice = Display.selectMenu();

			switch (choice) {
			case 1:
				mg.printBooks();
				break;
			case 2:
				mg.searchBook();
				break;
			case 3:
				mg.insertBook();
				break;
			case 4:
				mg.deleteBook();
				break;
			case 0:
				System.out.println("醫낅즺 �빀�땲�떎.");
				System.exit(0);
				break;
			
			default:
				System.out.println("�떎�떆 �엯�젰�빐二쇱꽭�슂");
			}
		}
			
			
			
		
		
		
	}
}
