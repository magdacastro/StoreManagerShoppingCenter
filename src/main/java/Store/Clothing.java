package Store;

import Address.Address;
import Date.Date;
import Employee.Employee;

import java.util.ArrayList;

public class Clothing extends Store{
    private boolean importedProducts;

    public Clothing(String nameStore, ArrayList<Employee> employees, double commissionOnSales, Address address, Date foundationDate, int maxProducts, boolean importedProducts) {
        super(nameStore, employees, commissionOnSales, address, foundationDate, maxProducts);
        this.importedProducts = importedProducts;
    }

    public boolean isImportedProducts() {
        return importedProducts;
    }

    public void setImportedProducts(boolean importedProducts) {
        this.importedProducts = importedProducts;
    }

    @Override
    public String toString() {
        return "A loja " + this.getNameStore() + " foi fundada em " + this.getFoundationDate() +
                " no " + this.getAddress() + ". É uma " + this.formatSizeStore() + " de roupas que podem ou nao ser importadas, "
                + this.getQuantityEmployees() + " empregados, "
                + this.getCommissionOnSales()+ "%" + " de comissão e " +
                this.salaryExpenses() + " com gastos de salário.";
    }
}
