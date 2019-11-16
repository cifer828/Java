package practice.practice13;

class Zipcode implements Comparable<Zipcode>{
    String zipcode;
    String city;
    String county;
    Zipcode(String zipcode, String city, String county) {
        this.zipcode = zipcode;
        this.city = city;
        this.county = county;
    }

    @Override
    public int compareTo(Zipcode o) {
        return this.county.compareTo(o.county);
    }
}
