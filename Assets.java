import java.util.Scanner;
public class Assets extends InputMoney{

	
	Scanner keyboard = new Scanner(System.in);
	int asset;
	
	
	public void calPercent (Assets asset)
	{
		int categoryNum;
		int expenditure = asset.getExpenditure();
		int currentAsset = asset.getcurrentAsset();
		do {
			System.out.println("1:Food 2:Transportaion 3:Leisure 4:Communication 5:Medical 6:Lifecost 7:Etc 8: Finish");
			System.out.println("type a category number: ");
			categoryNum = keyboard.nextInt();
			if(categoryNum == 1) {
				System.out.println("Total expenditure = " + expenditure);
				System.out.println("Percent of food expenditure = " + 100 * asset.category[0] / expenditure + "%" );
			}
			else if(categoryNum == 2) {
				System.out.println("Total expenditure = " + expenditure);
				System.out.println("Percent of Tranportaion expenditure = " + 100 * asset.category[1] / expenditure + "%"  );
			}
			else if(categoryNum == 3) {
				System.out.println("Total expenditure = " + expenditure);
				System.out.println("Percent of Leisure expenditure = " + 100 * asset.category[2] / expenditure + "%" );
			}
			else if(categoryNum == 4) {
				System.out.println("Total expenditure = " + expenditure);
				System.out.println("Percent of Communication expenditure = " + 100 * asset.category[3] / expenditure + "%");
			}
			else if(categoryNum == 5) {
				System.out.println("Total expenditure = " + expenditure);
				System.out.println("Percent of Medical expenditure = " + 100 * asset.category[4] / expenditure + "%");
			}
			else if(categoryNum == 6) {
				System.out.println("Total expenditure = " + expenditure);
				System.out.println("Percent of Lifecost expenditure = " + 100 * asset.category[5] / expenditure + "%");
			}
			else if(categoryNum == 7) {
				System.out.println("Total expenditure = " + expenditure);
				System.out.println("Percent of Etc expenditure = " + 100 * asset.category[6] / expenditure + "%");
			}
			else if (categoryNum == 8) {
				System.out.println("Finished");
				break;
			}
			else {
				System.out.println("Error!!  Please re-enter");
				
			}
		} while(categoryNum != 8);
		

		
		
	}
	public void writeAssets(int asset)
	{
		System.out.println("current Assets = " + asset);
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assets assets = new Assets();
		assets.WriteOutput();
		
		assets.writeAssets(assets.getcurrentAsset());
		assets.calPercent(assets);
		
	}
	private void WriteOutput() {
		// TODO Auto-generated method stub
		
	}

}
