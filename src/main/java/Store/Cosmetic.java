package Store;

import Address.Address;
import Date.Date;
import Employee.Employee;

import java.util.ArrayList;

public class Cosmetic extends Store{
   private double commercializationTax;

    public Cosmetic(String nameStore, ArrayList<Employee> employees, double commissionOnSales, Address address, Date foundationDate, int maxProducts, double commercializationTax) {
        super(nameStore, employees, commissionOnSales, address, foundationDate, maxProducts);
        this.commercializationTax = commercializationTax;
    }

    public double getCommercializationTax() {
        return commercializationTax;
    }

    public void setCommercializationTax(double commercializationTax) {
        this.commercializationTax = commercializationTax;
    }

    @Override
    public String toString() {
        return "A loja " + this.getNameStore() + " foi fundada em " + this.getFoundationDate() +
                " no " + this.getAddress() + ". É uma " + this.formatSizeStore() + " de cosméticos com taxa de comercialização em "
                + this.getCommercializationTax() + ". Possui "
                + this.getQuantityEmployees() + " empregados, "
                + this.getCommissionOnSales()+ "%" + " de comissão e " +
                this.salaryExpenses() + " com gastos de salário.";
    }
}
