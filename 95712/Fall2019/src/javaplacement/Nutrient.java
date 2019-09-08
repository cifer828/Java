// Name: Qiuchen Zhang
// Andrew-ID: qiuchenz
package javaplacement;

import java.util.List;

public class Nutrient implements Comparable<Nutrient>{
	public String nutrientCode;
	public String nutrientName;
	private List<String> products;
	public Nutrient(String nutrientCode, String nutrientName){
		this.nutrientCode = nutrientCode;
		this.nutrientName = nutrientName;
	}
	@Override
	public int compareTo(Nutrient n) {
		// TODO Auto-generated method stub
		return this.nutrientCode.compareTo(n.nutrientCode);
	}
}
