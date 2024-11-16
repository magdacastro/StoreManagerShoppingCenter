package Address;

public class Address {
    private String road;
    private int houseNumber;
    private int zipCode;
    private String complement;
    private City city;
    private State state;
    private Country country;

    public Address(String road, int houseNumber, int zipCode, String complement, City city, State state, Country country) {
        this.road = road;
        this.houseNumber = houseNumber;

        this.zipCode = zipCode;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    private String formatZipCode() {
        String zipCodeString = String.format("%08d", this.getZipCode());
        return zipCodeString.substring(0, 5) + "-" + zipCodeString.substring(5);
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public City getCity() {
        return city;
    }

    public State getState() {
        return state;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Endereço: " + this.getRoad() + "\n" +
                "número: " + this.getHouseNumber()+ "\n" +
                "cep: " + this.formatZipCode() +  "\n" +
                "complemento: " + this.getComplement() + "\n" +
                "na cidade de " + this.getCity().getDescription() + "\n" +
                "no estado de " +  this.getState().getDescription() + "\n" +
                "em " + this.getCountry().getDescription();
    }
}
