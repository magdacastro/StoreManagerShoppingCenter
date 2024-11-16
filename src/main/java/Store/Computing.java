package Store;

import Address.Address;
import Date.Date;
import Employee.Employee;

import java.util.ArrayList;

public class Computing extends Store{
    private double electronicsInsurance;

    public Computing(String nameStore, ArrayList<Employee> employees, double commissionOnSales, Address address, Date foundationDate, int maxProducts, double electronicsInsurance) {
        super(nameStore, employees, commissionOnSales, address, foundationDate, maxProducts);
        this.electronicsInsurance = electronicsInsurance;
    }

    public double getElectronicsInsurance() {
        return electronicsInsurance;
    }

    public void setElectronicsInsurance(double electronicsInsurance) {
        this.electronicsInsurance = electronicsInsurance;
    }

    @Override
    public String toString() {
        return "A loja " + this.getNameStore() + " foi fundada em " + this.getFoundationDate() +
                " no " + this.getAddress() + ". É uma " + this.formatSizeStore() + " de produtos eletrônicos com "
                + this.getElectronicsInsurance() + " de valor de seguro. Possui "
                + this.getQuantityEmployees() + " empregados, "
                + this.getCommissionOnSales()+ "%" + " de comissão e " +
                this.salaryExpenses() + " com gastos de salário.";
    }
}
