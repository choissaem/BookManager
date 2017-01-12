import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Manager {
	
	String filePath = "c:\\Book.txt";
	BufferedReader br;
	Scanner scan = new Scanner(System.in);
	
	int countBooks() throws IOException {

		int count = 1;
		String str = "";

		br = new BufferedReader(new FileReader(filePath));
		while ((str = br.readLine()) != null) {
			count++;
		}
		br.close();
		return count;
	}

	public void insertBook() throws IOException {
		
		Book b = Display.InsertBook();
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
		
		try {
			bw.write(countBooks() + "/" + b.getName() + "/" + b.getAuthor() + "/" + b.getPublisher() + "/" + b.getCost());
			bw.newLine();
		} catch (IOException e) {
			System.out.println("책 정보 입력 중 오류가 발생하였습니다.");
			e.printStackTrace();
			System.exit(0);
		}		
		bw.close();
		System.out.println("책 정보가 정상적으로 입력되었습니다.");
	}

	public void printBooks() throws IOException {
		
		br = new BufferedReader(new FileReader(filePath));
	
		try {
			String str = "";
			while ((str = br.readLine()) != null){
				System.out.println(str);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("책 정보를 읽어 올 수 없습니다.");
			System.out.println("저장된 파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}

	public void searchBook() throws IOException {
		
		String select = "";
		int fieldNum = -1;
		
		do{
			System.out.println("1. 책이름 검색");
			System.out.println("2. 저자 검색");
			System.out.println("3. 다중 검색");
			
			System.out.print("선택하세요 : ");
			select = scan.nextLine();
		}while(!select.matches("[1-3]"));
		
		System.out.print("검색할 키워드를 입력하세요 : ");
		String bookName = scan.nextLine();
		
		br = new BufferedReader(new FileReader(filePath));
		
		if(select.equals("1")) fieldNum = 1;
		if(select.equals("2")) fieldNum = 2;
		
		try {
			String str;
			int lineCount = 0;
		
			while ((str = br.readLine()) != null) {

				if (select.equals("3")) {
					if (str.contains(bookName)) {
						System.out.println(++lineCount + " : " + str);
					}
				} else {
					String[] field = str.split("/");

					if (field[fieldNum].contains(bookName)) {
						System.out.println(++lineCount + " : " + str);
					}
				}
			}
			System.out.println("총 " + lineCount + "건 검색");

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("책 정보를 읽어 올 수 없습니다.");
			System.out.println("저장된 파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}

	public void deleteBook() throws IOException {

		String bookNum = "";
		String tmpFilePath = filePath + ".tmp";

		do {
			System.out.print("삭제할 책 번호를 입력하세요 : ");
			bookNum = scan.nextLine();
		} while (!bookNum.matches("[0-9]+"));

		br = new BufferedReader(new FileReader(filePath));

		String str = "";
		BufferedWriter bw = new BufferedWriter(new FileWriter(tmpFilePath));
		while ((str = br.readLine()) != null) {

			String[] fields = str.split("/");
			if (!fields[0].equals(bookNum)) {
				bw.write(fields[0] + "/" + fields[1] + "/" + fields[2] + "/" + fields[3] + "/" + fields[4]);
				bw.newLine();
			}
			
		}
		
		bw.close();
		br.close();

		FileInputStream fis =  new FileInputStream(tmpFilePath);
		FileOutputStream fos = new FileOutputStream(filePath);
		
		int data=0;
		while ((data=fis.read()) != -1){
			fos.write(data);
		}
		fis.close();
		fos.close();
	}
}
