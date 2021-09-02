import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class assetData {

	public assetData() {
		String fileName = "out.txt";
		PrintWriter outputStream = null;
		try // 
		{
			outputStream = new PrintWriter(fileName); /*예외적인 상황
			의도한대로 파일 엑세스가 안될때가 있을 수 있다
			*/ 
		}
		catch (FileNotFoundException e) /*파일을 열려고 했을때 잘 안되었을때?*/
		{
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		System.out.println("Enter three lines of text: ");
		Scanner keyboard = new Scanner(System.in);
	//	for(int count =1; count <=3; count++)
	//	{
			String line = keyboard.nextLine();
			outputStream.println(line);
	//	}
		outputStream.close();
		System.out.println("Those lines were written to " + fileName);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assetData ass = new assetData()	;
	}

}
