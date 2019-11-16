package practice.practice13;

class County implements Comparable<County>{
    String countyName;
    int zipcodeCount;
    County (String countyName){
        this.countyName = countyName;
        zipcodeCount = 1;
    }
    void addZipcodeCount(){
        zipcodeCount++;
    }

    @Override
    public int compareTo(County o) {
        return this.zipcodeCount - o.zipcodeCount;
    }
}
