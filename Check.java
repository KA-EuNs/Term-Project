import java.util.Scanner;


public class Check extends User{
   public String inputName; //�Է¹��� �̸�
   public int inputPW; //����ڿ��� �Է¹��� ��й�ȣ
   public int inputID;
   public int inputPhoneNum; //�Է¹��� ������� 
   public int count; //���� Ƚ�� ǥ��
   
   Scanner keyboard = new Scanner(System.in);
   
   public void setCount(int count) {
	   this.count = count;
   }
   
   /*
   public boolean comparePW(int inputPW) {  //�����Ǿ��ִ� ��й�ȣ�� �Է¹��� ��й�ȣ�� ������ Ȯ��
      int setPW = super.getPW();
      
      if(setPW == inputPW) { //���ؼ� ������ true
         return true;
      }
      else { //���ؼ� �ٸ��� false
    	 count++;
         return false;
      }
   }*/
   
   public void plusCount() {
	   ++this.count;
   }
   
   public int getCount() {
	   return this.count;
   }
   
   public void errorExcess() {
	   System.out.println("Enter your name to identification : ");
	   inputName = keyboard.nextLine();
	   
	   if(inputName.equals(super.getName())) {
		   System.out.print("Enter your ID to identification : ");
		   inputID = keyboard.nextInt();
		 
		   if(inputID == super.getID()) {
			   System.out.print("Hi, " + super.getName());
			   System.out.println("Set your PW again : ");
			   inputPW = keyboard.nextInt();
			   System.out.println("Your password has been reset. \nDon't forget~!");
			   this.setCount(0);
		   }
		   else {
			   System.out.println("ID is not correct.");
		   }
	   }
	   else {
		   System.out.println("User name is not the same.");
	   }
   }
  
}