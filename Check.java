import java.util.Scanner;


public class Check extends User{
   public String inputName; //입력받은 이름
   public int inputPW; //사용자에게 입력받은 비밀번호
   public int inputID;
   public int inputPhoneNum; //입력받은 생년월일 
   public int count; //오류 횟수 표시
   
   Scanner keyboard = new Scanner(System.in);
   
   public void setCount(int count) {
	   this.count = count;
   }
   
   /*
   public boolean comparePW(int inputPW) {  //설정되어있는 비밀번호와 입력받은 비밀번호가 같은지 확인
      int setPW = super.getPW();
      
      if(setPW == inputPW) { //비교해서 같으면 true
         return true;
      }
      else { //비교해서 다르면 false
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