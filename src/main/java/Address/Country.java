package Address;

public enum Country {
    BRASIL("Brasil"),
    ARGENTINA("Argentina"),
    CHILE("Chile");

    private final String description;

    Country(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
