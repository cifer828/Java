// Name: Qiuchen Zhang
// Andrew-ID: qiuchenz
package javaplacement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataModel {
	private final String NUTRIENT_FILE = "Nutrients.csv";
	public List<Record> recordList=new ArrayList<>();
	public void readFile(){
		String line;
		String [] splitedLine;
		try{
			BufferedReader br;
			br = new BufferedReader(new FileReader(this.NUTRIENT_FILE));
			while ((line=br.readLine()) != null) {
				splitedLine = line.split(",");
				Record r = new Record(splitedLine[0], splitedLine[1], splitedLine[2]);
				recordList.add(r); 
			}
		}
		catch(Exception e){
			System.out.println("The file is not available.");
		}
	}
	public static void main(String args[]){
		DataModel dm = new DataModel();
		dm.readFile();
	}
}

