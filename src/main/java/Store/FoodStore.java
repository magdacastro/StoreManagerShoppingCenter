package Store;

import Address.Address;
import Date.Date;
import Employee.Employee;

import java.util.ArrayList;

public class FoodStore extends Store{
    private Date permissionDate;

    public FoodStore(String nameStore, ArrayList<Employee> employees, double commissionOnSales, Address address, Date foundationDate, int maxProducts, Date permissionDate) {
        super(nameStore, employees, commissionOnSales, address, foundationDate, maxProducts);
        this.permissionDate = permissionDate;
    }

    public Date getPermissionDate() {
        return permissionDate;
    }

    public void setPermissionDate(Date permissionDate) {
        this.permissionDate = permissionDate;
    }

    @Override
    public String toString() {
        return "A loja " + this.getNameStore() + " foi fundada em " + this.getFoundationDate() +
                " no " + this.getAddress() + ". É uma " + this.formatSizeStore() + " de alimentação cuja data de alvará é "
                + this.getPermissionDate() + ". Possui "
                + this.getQuantityEmployees() + " empregados, "
                + this.getCommissionOnSales()+ "%" + " de comissão e " +
                this.salaryExpenses() + " com gastos de salário.";
    }
}
