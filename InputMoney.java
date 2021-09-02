import java.io.*;
public class InputMoney extends Check implements Serializable {

	private int income;
	private int expenditure;
	private int currentAsset;
	
	File fileName1 = new File("InputMoneyData.txt"); //�씠踰덈떖 �닔�엯吏�異� �뙆�씪//
	File fileName2 = new File("lastMonthData.txt"); //��踰덈떖 �닔�엯吏�異� �뙆�씪//

	int [] category = {1,2,3,4,5,6,7};
	
	
	public void setIncome(int newIncome) { //�닔�엯 �꽕�젙//
		income = newIncome;
	}
	public void setExpenditure(int newExpenditure) { //吏�異� �꽕�젙//
		expenditure = newExpenditure;
	}

	public void setCategoryFood(int newCategoryFood) { //�떇鍮� �꽕�젙//
		category[0] = newCategoryFood; 
	}
	
	public void setCategoryTransportation(int newCategoryTransportation) { //援먰넻鍮� �꽕�젙 //
		category[1] = newCategoryTransportation; 
	}
	
	public void setCategoryLeisure(int newCategoryLeisure) { //�뿬媛�鍮� �꽕�젙//
		category[2] = newCategoryLeisure; 
	}
	
	public void setCategoryCommunication(int newCategoryCommunication) { //�넻�떊鍮� �꽕�젙//
		category[3] = newCategoryCommunication; 
	}
	
	public void setCategoryMedical(int newCategoryMedical) { //�쓽猷뚮퉬 �꽕�젙//
		category[4] = newCategoryMedical; 
	}
	
	public void setCategoryLifeCost(int newCategoryLifeCost) { //�깮�솢鍮� �꽕�젙//
		category[5] = newCategoryLifeCost; 
	}
	
	public void setCategoryEtc(int newCategoryEtc) { //湲고�鍮� �꽕�젙//
		category[6] = newCategoryEtc; 
	}
	
	public int getIncome() { 
		return this.income;
	}
	
	public int getExpenditure() {
		return this.expenditure ;
	}
	
	public int getcurrentAsset() { //�닚�닔�씡 (�닔�엯 - 吏�異�)  //
		
		return 	currentAsset = income - expenditure;
	}
	
	public int getCategoryFood() { //�떇鍮� //
		return category[0];
	}
	
	public int getCategoryTransportation() { //援먰넻鍮� //
		return category[1]; 
	}
	
	public int getCategoryLeisure() { //�뿬媛�鍮�//
		return category[2];
	}
	
	public int getCategoryCommunication() { //�넻�떊鍮� //
		return category[3];
	}
	
	public int getCategoryMedical() { //�쓽猷뚮퉬 //
		return category[4];
	}
	
	public int getCategoryLifeCost() { //�깮�솢鍮� //
		return category[5];
	}
	
	public int getCategoryEtc() { //湲고�鍮� //
		return category[6];
	}
	
	public void resetCurrentAssetIncome (String addIncome) { //異붽� �닔�엯 �꽕�젙//
		
		int addIncomeMoney = Integer.parseInt(addIncome);
		
		if (addIncomeMoney > 0) {
		currentAsset = currentAsset + addIncomeMoney;
		}
		else {
			System.out.println("please enter again range(1 ~ 7) : ");
		}
	}
	
	public void calEachCategoryTotal(String addExpenditure, String categoryNum) { //媛� 移댄뀒怨좊━蹂� 異붽� 吏�異쒓퀎�궛 method //
		
		int addExpenditureMoney = Integer.parseInt(addExpenditure);
		int categoryNumber = Integer.parseInt(categoryNum);
		
		if (addExpenditureMoney > 0) {
			currentAsset = currentAsset - addExpenditureMoney; //異붽� 吏�異� 鍮쇨린//
			
			if (categoryNumber == 1) {
				category[0] = category[0] - addExpenditureMoney;  //�떇鍮� 異붽� 吏�異� //
				}
			else if (categoryNumber == 2) {
				category[1] = category[1] - addExpenditureMoney; //援먰넻鍮� 異붽� 吏�異� //
				}
			else if (categoryNumber == 3) {
				category[2] = category[2] - addExpenditureMoney; //�뿬媛�鍮� 異붽� 吏�異�//
				}
			else if (categoryNumber == 4) {
				category[3] = category[3] - addExpenditureMoney; //�넻�떊鍮� 異붽� 吏�異�//
				}
			else if (categoryNumber == 5) {
				category[4] = category[4] - addExpenditureMoney; //�쓽猷뚮퉬 異붽� 吏�異�//
				}
			else if (categoryNumber == 6) {
				category[5] = category[5] - addExpenditureMoney; //�깮�솢鍮� 異붽� 吏�異�//
				}
			else if (categoryNumber == 7) {
				category[6] = category[6] - addExpenditureMoney;//湲고�鍮� 異붽� 吏�異� //
				}
			else {
				System.out.println("please enter again range(1 ~ 7) : "); //�삤瑜� 硫붿꽭吏� 異쒕젰//
			}
			
	}	
		
		
}
	public InputMoney() {
		try {
			/*
			 * ObjectOutputStream thisOutputStream = new ObjectOutputStream(new
			 * FileOutputStream (fileName1));//�씠踰덈떖 吏�異쒕궡�뿭 �엯�젰// InputMoney money = new
			 * InputMoney(); //�씠踰덈떖 吏�異쒕궡�뿭 珥덇린 �꽕�젙// money.setIncome(600000); //�닔�엯//
			 * money.setExpenditure(350000); //吏�異�// money.setCategoryFood(70000); //�떇鍮�//
			 * money.setCategoryTransportation(50000);//援먰넻鍮�//
			 * money.setCategoryLeisure(50000); //�뿬媛�鍮�//
			 * money.setCategoryCommunication(70000); //�넻�떊鍮�//
			 * money.setCategoryMedical(10000); //�쓽猷뚮퉬// money.setCategoryLifeCost(60000);
			 * //�깮�솢鍮�// money.setCategoryEtc(40000); //湲고� 鍮꾩슜//
			 * 
			 * thisOutputStream.writeObject(money); thisOutputStream.flush();
			 */
			
			ObjectInputStream thisInputStream = new ObjectInputStream(new FileInputStream (fileName1)); 
			InputMoney thisMonthOut = (InputMoney)thisInputStream.readObject(); //�씠踰덈떖 吏�異쒕궡�뿭 異쒕젰//
			System.out.println("Income: " + thisMonthOut.getIncome()); 
			System.out.println("Expenditure: " + thisMonthOut.getExpenditure()); 
			System.out.println("net profit: " + thisMonthOut.getcurrentAsset()); //�닚�닔�씡//
			System.out.println("Food: " + thisMonthOut.getCategoryFood());
			System.out.println("Transportation: " + thisMonthOut.getCategoryTransportation());
			System.out.println("Leisure: " + thisMonthOut.getCategoryLeisure());
			System.out.println("Communication: " + thisMonthOut.getCategoryCommunication());
			System.out.println("Medical: " + thisMonthOut.getCategoryMedical());
			System.out.println("LifeCost: " + thisMonthOut.getCategoryLifeCost());
			System.out.println("Etc: " + thisMonthOut.getCategoryEtc());			
			//thisOutputStream.close(); thisInputStream.close();
			
			ObjectOutputStream lastOutputStream = new ObjectOutputStream(new FileOutputStream (fileName2));		
			InputMoney lastMonth = new InputMoney(); //��踰덈떖 吏�異쒕궡�뿭 珥덇린 �꽕�젙//
			lastMonth.setIncome(60000); //�닔�엯//
			lastMonth.setExpenditure(45000); //吏�異�//
			lastMonth.setCategoryFood(8000); //�떇鍮�//
			lastMonth.setCategoryTransportation(5000); //援먰넻鍮�//
			lastMonth.setCategoryLeisure(8000);//�뿬媛�鍮�//
			lastMonth.setCategoryCommunication(7000);//�넻�떊鍮�//
			lastMonth.setCategoryMedical(5000); //�쓽猷뚮퉬//
			lastMonth.setCategoryLifeCost(8000); //�깮�솢鍮�//
			lastMonth.setCategoryEtc(4000); //湲고�鍮꾩슜//
			lastOutputStream.writeObject(lastMonth);
			lastOutputStream.flush();
			
			ObjectInputStream lastInputStream = new ObjectInputStream(new FileInputStream (fileName2)); //��踰덈떖 吏�異쒕궡�뿭 異쒕젰//
			InputMoney lastMonthOut = (InputMoney)lastInputStream.readObject();
			System.out.println("Income: " + lastMonthOut.getIncome());
			System.out.println("Expenditure: " + lastMonthOut.getExpenditure());
			System.out.println("Net profit:" + lastMonthOut.getcurrentAsset());
			System.out.println("Food: " + lastMonthOut.getCategoryFood());
			System.out.println("Transportation: " + lastMonthOut.getCategoryTransportation());
			System.out.println("Leisure: " + lastMonthOut.getCategoryLeisure());
			System.out.println("Communication: " + lastMonthOut.getCategoryCommunication());
			System.out.println("CategoryMedical: " + lastMonthOut.getCategoryMedical()); 
			System.out.println("LifeCost: " + lastMonthOut.getCategoryLifeCost());
			System.out.println("Etc: " + lastMonthOut.getCategoryEtc());
			
			lastOutputStream.close(); lastInputStream.close(); //�뙆�씪 close //
			
	}

	catch (IOException e) {
		System.out.println("Error opening the file ");
		e.printStackTrace();
		System.exit(0);
	}	
	catch (ClassNotFoundException e) {
		System.out.println("Error");
		 e.printStackTrace();
		System.exit(0);
	}	
	
}
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		InputMoney inputMoney = new InputMoney();
		inputMoney.setVisible(true);
		
	}
	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

		

}
