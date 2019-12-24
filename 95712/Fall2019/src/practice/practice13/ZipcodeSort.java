package practice.practice13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class ZipcodeSort {
    private List<Zipcode> zipcodes = new ArrayList<>();
    private List<County> counties = new ArrayList<>();

    void readData(String filename){
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()){
                String [] oneLine = input.nextLine().split(",");
                zipcodes.add(new Zipcode(oneLine[0], oneLine[1], oneLine[2]));
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    List<Zipcode> sortZipcodes (){
        Collections.sort(zipcodes);
        return zipcodes;
    }

    List<County> sortCountiesReverse (){
        Collections.sort(counties, Collections.reverseOrder());
        return counties;
    }

    void buildCounties(){
        Map<String, County> countyMap = new HashMap<>();
        for (Zipcode z: zipcodes){
            if (countyMap.containsKey(z.county))
                countyMap.get(z.county).addZipcodeCount();
            else
                countyMap.put(z.county, new County(z.county));
        }
        counties = new ArrayList<>(countyMap.values());
    }

    public static void main(String[] args) {
        ZipcodeSort zs = new ZipcodeSort();
        System.out.println("Enter file name");
//        Scanner input = new Scanner(System.in);
//        zs.readData(input.next());
        zs.readData("Zipcodes.txt");
        zs.sortZipcodes(); // useless
        zs.buildCounties();
        List<County> counties = zs.sortCountiesReverse();
        System.out.printf("%2s. %s\t\t%s%n", "#", "County", "Count of Zipcodes");
        System.out.printf("*********************************\n");
        int num = 1;
        for (County c: counties) {
            System.out.printf("%2d. %-16s%s %-4d%n", num++, c.countyName, ":", c.zipcodeCount);
        }

    }

}
