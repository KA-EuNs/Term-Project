import java.util.Scanner;
public class inputMoneyData {

	private int income;
	private int expenditure;
	private int currentAsset;

	int [] category = {1,2,3,4,5,6,7};
	
	Scanner keyboard = new Scanner(System.in);
	
	public void setCurrentAsset(int assets) {
		
	}
	public void setIncome(int newIncome) {
		income = newIncome;
	}
	public void setExpenditure(int newExpenditure) {
		expenditure = newExpenditure;
	}

	public void setCategoryFood(int newCategoryFood) {
		category[0] = newCategoryFood; 
	}
	
	public void setCategoryTransportation(int newCategoryTransportation) {
		category[1] = newCategoryTransportation; 
	}
	
	public void setCategoryLeisure(int newCategoryLeisure) {
		category[2] = newCategoryLeisure; 
	}
	
	public void setCategoryCommunication(int newCategoryCommunication) {
		category[3] = newCategoryCommunication; 
	}
	
	public void setCategoryMedical(int newCategoryMedical) {
		category[4] = newCategoryMedical; 
	}
	
	public void setCategoryLifeCost(int newCategoryLifeCost) {
		category[5] = newCategoryLifeCost; 
	}
	public void setCategoryEtc(int newCategoryEtc) {
		category[6] = newCategoryEtc; 
	}
	
	public int getIncome() {
		return this.income;
	}
	
	public int getExpenditure() {
		return this.expenditure ;
	}
	
	public int getcurrentAsset() {
		
		return 	currentAsset = income - expenditure;
	}
	
	public void resetCurrentAssetIncome (int addIncome) {
		
		currentAsset = currentAsset + addIncome;
	}
	
	public void resetCurrentAssetExpenditure (int addExpenditure) {
		
		currentAsset = currentAsset - addExpenditure;
	}
	
	public void calEachCategoryTotal(int addExpenditure, int categoryNum) {
		
		if (categoryNum == 1) {
			category[0] = category[0] - addExpenditure;
			}
		else if (categoryNum == 2) {
			category[1] = category[1] - addExpenditure;
			}
		else if (categoryNum == 3) {
			category[2] = category[2] - addExpenditure;
			}
		else if (categoryNum == 4) {
			category[3] = category[3] - addExpenditure;
			}
		else if (categoryNum == 5) {
			category[4] = category[4] - addExpenditure;
			}
		else if (categoryNum == 6) {
			category[5] = category[5] - addExpenditure;
			}
		else if (categoryNum == 7) {
			category[6] = category[6] - addExpenditure;
			}
		else {
			System.out.println("please enter again range(1 ~ 7) : ");
		}
				
	}
	public void WriteOutput() {
		
		System.out.println("Enter your input : ");
		int FirstIncome= keyboard.nextInt();
		
		System.out.println("Enter your Food expenditure :");
		int categoryFood = keyboard.nextInt();
		System.out.println("Enter your Transportation expenditure :");
		int categoryTransportation = keyboard.nextInt();
		System.out.println("Enter your Leisure expenditure :");
		int categoryLeisure = keyboard.nextInt();
		System.out.println("Enter your Communication expenditure :");
		int categoryCommunication = keyboard.nextInt();
		System.out.println("Enter your Medical expenditure :");
		int categoryMedical = keyboard.nextInt();
		System.out.println("Enter your LifeCost expenditure :");
		int categoryLifeCost = keyboard.nextInt();
		System.out.println("Enter your Etc expenditure :");
		int categoryEtc = keyboard.nextInt();
		
		int TotalExpenditure = categoryFood + categoryTransportation + categoryLeisure + categoryCommunication + categoryMedical + categoryLifeCost + categoryEtc;     
		
		System.out.println("Enter your additional income : ");
		int AddIncome = keyboard.nextInt();
		System.out.println("Enter your additional expenditure : ");
		int AddExpenditure = keyboard.nextInt();
		System.out.println("Enter the kind of expenditure : ");
		int AddCategoryNum = keyboard.nextInt();
		
		setIncome(FirstIncome);
		setExpenditure(TotalExpenditure);
		setCategoryFood(categoryFood);
		setCategoryLeisure(categoryLeisure);
		setCategoryCommunication(categoryCommunication);
		setCategoryMedical(categoryMedical);
		setCategoryLifeCost(categoryLifeCost);
		setCategoryEtc(categoryEtc);
		resetCurrentAssetExpenditure(AddExpenditure);
		resetCurrentAssetIncome(AddIncome);
		calEachCategoryTotal(AddExpenditure,AddCategoryNum);

	}

}