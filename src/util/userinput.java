package util;

import java.util.Scanner;

public class userinput {
	// 接收用户输入的内容String

	public String getString(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public int getInt(String msg) {
		while (true) {
			try {
				System.out.print(msg);
				Scanner sc = new Scanner(System.in);
				return sc.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("请正确输入id");
			}
		}
	}

	public double getDouble(String msg) {
		while (true) {
			try {
				System.out.print(msg);
				Scanner sc = new Scanner(System.in);
				return sc.nextDouble();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("请正确输入浮点型成绩");
			}
		}

	}
}
