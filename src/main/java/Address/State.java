package Address;

public enum State {
    RIO_GRANDE_DO_SUL("Rio Grande do Sul"),
    SANTA_CATARINA("Santa Catarina"),
    PARANA("Parana");

    private final String description;

    State(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
