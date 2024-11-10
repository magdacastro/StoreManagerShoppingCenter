package Employee;

import java.text.NumberFormat;
import java.util.Locale;

public enum Position {
    INTERN("Estagiário", 1200),
    SALESMAN("Vendedor", 2800),
    STOCKIST("Estoquista", 2300),
    SUPERVISOR("Supervisor", 3200),
    MANAGER("Gerente", 3500);

    private final String description;
    private double baseSalary;
    private final NumberFormat formatter;

    Position(String description, double baseSalary) {
        this.description = description;
        this.baseSalary = baseSalary;

        formatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    }

    public String getDescription() {
        return description;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getFormatSalary(){
        return formatter.format(getBaseSalary());
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setIncreaseSalary(double increase) {
        this.baseSalary += increase;
    }
}

