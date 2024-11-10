package Address;

public enum City {
    PORTO_ALEGRE("Porto Alegre"),
    SAO_LEOPOLDO("São Leopoldo"),
    NOVO_HAMBURGO("Novo Hamburgo");

    private final String description;

    City(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
