import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class assetData {

	public assetData() {
		String fileName = "out.txt";
		PrintWriter outputStream = null;
		try // 
		{
			outputStream = new PrintWriter(fileName); /*�������� ��Ȳ
			�ǵ��Ѵ�� ���� �������� �ȵɶ��� ���� �� �ִ�
			*/ 
		}
		catch (FileNotFoundException e) /*������ ������ ������ �� �ȵǾ�����?*/
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
