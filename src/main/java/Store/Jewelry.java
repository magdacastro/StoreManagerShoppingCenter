package Store;

import Address.Address;
import Date.Date;
import Employee.Employee;

import java.util.ArrayList;

public class Jewelry extends Store{
    private double goalSales;


    public Jewelry(String nameStore, ArrayList<Employee> employees, double commissionOnSales, Address address, Date foundationDate, int maxProducts, double goalSales) {
        super(nameStore, employees, commissionOnSales, address, foundationDate, maxProducts);
        this.goalSales = goalSales;
    }

    public double getGoalSales() {
        return goalSales;
    }

    public void setGoalSales(double goalSales) {
        this.goalSales = goalSales;
    }

    @Override
    public String toString() {
        return "A loja " + this.getNameStore() + " foi fundada em " + this.getFoundationDate() +
                " no " + this.getAddress() + ". É uma " + this.formatSizeStore() + " de bijuterias cuja a meta de vendas é "
                + this.getGoalSales() + ". Possui "
                + this.getQuantityEmployees() + " empregados, "
                + this.getCommissionOnSales()+ "%" + " de comissão e " +
                this.salaryExpenses() + " com gastos de salário.";
    }
}
