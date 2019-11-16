package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteAtSameTime {
	public static void main(String[] args) {
		String filename = "writeAtSameTime.txt";
		try {
			BufferedWriter bw1 = new BufferedWriter(new FileWriter(filename));
			BufferedWriter bw2 = new BufferedWriter(new FileWriter(filename));
			bw1.write("1-1111\n");
			bw2.write("2-1\n");
			bw1.flush();
			bw2.flush();
			bw1.write("1-2\n");
			bw2.write("2-2\n");
			bw1.flush();
			bw2.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
