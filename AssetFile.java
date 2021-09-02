import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException; 
import java.util.Scanner;
public class AssetFile {

	int cuAsset =0;
	String data[];
	String line;
	public AssetFile() {
		String fileName = "out.txt";
		Scanner inputStream = null;
		int count = 0;
		
		System.out.println("The file " + fileName + "\ncontains the following lines:\n");
		
		try
		{
			inputStream = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		while(inputStream.hasNextLine())
		{
			
			line = inputStream.nextLine();
			
			//data[count] = line;
			 
			System.out.println(line);
			
			count++;
		}
		inputStream.close();
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		AssetFile currAsset = new AssetFile();

	}
}

