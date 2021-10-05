package com.mini.project;

import java.util.Scanner;

public class StudentMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StudentManage studentManage = new StudentManage();
		
		for(;;)
		{
			System.out.println("1 All Student Details \n2. Student Details By ID \n3.Update Deatils of students \n4. Delete \n5. exit");
			try {
				
				int option = sc.nextInt();
				
				switch (option) {
				case 1: studentManage.printAllStudentDetails();
					
					break;
				case 2 : studentManage.findById();
					break;
				case 3 : studentManage.Update();
					break;
				case 4 : studentManage.delete();
					break;
				case 5 : return;
				

				default:
					break;
				}
				
			} catch (Exception e) {
				System.out.println("Something thing went wrong");
				e.printStackTrace();
			}
			
		}
		
		
	}

}
