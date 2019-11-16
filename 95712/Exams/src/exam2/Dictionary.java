// Qiuchen Zhang
// qiuchenz

package exam2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Dictionary extends WordReference{
	public Dictionary(String filename) {
		// TODO Auto-generated constructor stub
		StringBuilder content = new StringBuilder();
		try {
			String line;
//			BufferedReader br;
//			br = new BufferedReader(new FileReader(filename));
//			int cnt = 0;
//			while ((line=br.readLine()) != null) {
//				content.append(line);
//				content.append("\n");
//				System.out.println(cnt++);
//			}
//			br.close();
			
			Scanner input = new Scanner(new File(filename));
			
//			int cnt = 0;
//			while(input.hasNextLine()) {
//				cnt++;
//				input.nextLine();
//			}
//			String [] contentArray = new String [cnt];
//			input = new Scanner(new File(filename));
//			cnt = 0;
//			while(input.hasNextLine()) {
//				contentArray[cnt++] = input.nextLine();
//			}
//			input.close();
			
			while(input.hasNextLine()) {
				content.append(input.nextLine());
				content.append("\n");
			}
			
			input.close();
			String [] contentArray = content.toString().split("\n");
			
			wordData = new String [contentArray.length][2];
			System.out.println(contentArray.length);
			for (int i = 0; i < wordData.length; i++) {
				line = contentArray[i];
				wordData[i][0] = line.split("[(]")[0].trim();
				wordData[i][1] = line.split("[)]")[1].trim();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	String[] lookup(String word) {
		// TODO Auto-generated method stub
		String output = "";
		for (String[] check : wordData) {
			if(check[0].trim().equalsIgnoreCase(word.trim())) {
				output += check[1] + "\n";
			}
		}
		if(output.length() == 0)
			return null;
		else {
			return output.split("\n");
		} 
	}

}
