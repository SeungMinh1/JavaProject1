package com.yedam.java.app;

import java.util.Scanner;

public class HumanResourceMng {
	Scanner sc = null; //new Scanner(System.in);
	
	// 생성자
		public HumanResourceMng() {
			sc = new Scanner(System.in);
		}
	
	public void run() {
		
		
		while(true) {
			
			int menu = selectMenu();
			
			if(menu ==1) {
				new EmpManagement().run();;
			}else if(menu ==2) {
				new Deptmanagement().run();;
			}else if(menu == 9) {
				end();
				break;
			}else {
				showError();
			}
		}
	}
	
	
	private void showError() {
		System.out.println("메뉴에서 선택하세요.");
	}
	private void end() {
		System.out.println("프로그램을 종료합니다.");
	}
	private int selectMenu() {
		System.out.print("선택 > ");
		return inputNumber();
	}
	private int inputNumber() {
		int num = 0;
		try {
			num = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하시오");
		}
		return num;
	}

}
