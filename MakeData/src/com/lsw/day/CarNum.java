package com.lsw.day;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CarNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		int count = 0, i = 0, carSign = 0, speed = 0, bearing = 0, occupied = 0;
		String carNumstr = "";
		char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		String record = null;
		// br=new BufferedReader(new FileReader(filepath));
		Random random = new Random();
		Set<String> carNum=new HashSet<String>();
		try {
			bw = new BufferedWriter(new FileWriter("E:\\GPSData\\Num.txt"));
			for (;carNum.size()<50;) {
				carSign = random.nextInt(90) % 26 + 65;
				carNumstr=(char)carSign+"";
				while (count < 5) {
					i = random.nextInt(10);
					carNumstr += str[i];
					count++;
				}
				carNum.add(carNumstr);
				carNumstr="";
				count=0;
				
			}
			
			for(String s:carNum){
				String str2="热"+s;
				bw.write(str2);
				bw.newLine();
				bw.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
