package com.mijiang.algo.sort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class RandomNumGen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] data = SortTestClient.genRandomInt(1000000);
		
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/mijiang/workspace/rtry/random_number2.txt"))));
			out.write("randomInt");
			out.newLine();
			System.out.println(data.length);
			for (Integer aInt: data){
				out.write(aInt + "");
				out.newLine();
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
