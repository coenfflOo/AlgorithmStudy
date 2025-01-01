package java_2024.June;

import java.text.SimpleDateFormat;
import java.util.Date;

public class selfProject {
	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat month = new SimpleDateFormat("M");
		String nowTime1 = year.format(now);
		String nowTime2 = month.format(now);
		System.out.println(nowTime1);
		System.out.println(nowTime2);
		int arr[] = {31,0,31,30,31,31,30,31,30,31,30,31};
		if(nowTime2.equals("2")) {
			int y = Integer.parseInt(nowTime1);
			if(y%4==0&&y%100!=0||y%400==0) {
				System.out.println(29);
			}
			else {
				System.out.println(28);
			}
		}
		else {
			System.out.println(arr[Integer.parseInt(nowTime2)]);
		}
	}
	
}
