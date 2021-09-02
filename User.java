import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class User {
   public String name;
   private int ID;
   public static int PW;
   private String phoneNum;

   Scanner keyboard = new Scanner(System.in);

   public User() {
      name = "User";
      ID = 0;
      PW = 0;
      phoneNum = "010-0000-0000";
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setID(int ID) {
      this.ID = ID;
   }

   public void setPW(int PW) {
	   this.PW = PW;
   }

   public void setPhoneNum(String phoneNum) {
      this.phoneNum = phoneNum;
   }

   public void initInfo() {
      String inputFileName = "userInfo.txt";
      Scanner inputStream = null;

      try {
         inputStream = new Scanner(new File(inputFileName), "UTF-8");
         
         if(inputStream.hasNextLine()) {
        	String trash = inputStream.nextLine();
            String line = inputStream.nextLine();
            String[] arr = line.split(" ");

            name = arr[0];
            int initID = Integer.parseInt(arr[1]);
            int initPW = Integer.parseInt(arr[2]);
            String initPhoneNum = arr[3];

            setID(initID);
            setPW(initPW);
            setPhoneNum(initPhoneNum);
         }
         else {
            System.exit(0);
         }
      }
      catch(FileNotFoundException e) {
         System.out.println(e);
         System.exit(0);
      }
      finally {
         if(inputStream != null) {
            inputStream.close();
         }
      }
   }

   public String getName() { //return name
      return this.name;
   }

   public int getID() { //return ID
      return this.ID;
   }

   /*
   public int getPW() { //return PW
      return User.PW;
   }*/
   
   
   public String getPhoneNum() { //return phoneNum
      return this.phoneNum;
   }

   public void writeInfo() {
      System.out.println("User Information");
      System.out.println("Name : " + getName());
      System.out.println("ID : " + getID());
      System.out.println("PassWord : " + PW);
      System.out.println("Phone number : " + getPhoneNum());
   }

   //public static void main(String[] args) {
     // User user = new User();

      //user.initInfo();
     // user.writeInfo();
  // }//
}