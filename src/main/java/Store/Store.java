package Store;

import Address.*;
import Date.*;
import Employee.Employee;
import Product.Product;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;


public class Store {
    private static int nextId = 1;
    private final int id;
    private String nameStore;
    private ArrayList<Employee> employees;
    private double commissionOnSales;
    private final int quantityEmployees;
    private Address address;
    private Date foundationDate;
    private ArrayList<Product> stockProducts;
    private final NumberFormat formatter;
    private int maxProducts;


    public Store(String nameStore, ArrayList<Employee> employees, double commissionOnSales, Address address, Date foundationDate, int maxProducts) {
        this.id = nextId++;

        LocalDate currentDate = LocalDate.now();
        LocalDate foundDate = LocalDate.of(foundationDate.getYear(), foundationDate.getMonth(), foundationDate.getDay());

        this.nameStore = nameStore;
        this.employees = employees;
        this.quantityEmployees = employees.size();
        this.commissionOnSales = commissionOnSales;

        for(Employee emp : employees){
            if(emp.getPosition().getDescription().equals("Vendedor") || emp.getPosition().getDescription().equals("Gerente")){
                double increaseSalary = emp.getPosition().getBaseSalary() * (commissionOnSales / 100);
                emp.getPosition().setIncreaseSalary(increaseSalary);
            }
        }

        this.address = address;

        if(foundDate.isAfter(currentDate)){
            System.out.println("Error: A data de fundação não pode ser após a data atual.");
            this.foundationDate.setDay(1);
            this.foundationDate.setMonth(1);
            this.foundationDate.setYear(2000);
        } else {
            this.foundationDate = foundationDate;
        }

        if(maxProducts <= 0){
            System.out.println("Você precisa ter no mínimo 1 como quantidade máxima de produtos na sua loja");
            this.maxProducts = 1;
        } else {
            this.maxProducts = maxProducts;
        }

        this.stockProducts = new ArrayList<>(maxProducts);

        formatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    }

    public int getId() {
        return id;
    }

    public String salaryExpenses(){
        double allSalaries = 0;
        for (Employee employee : employees) {
            allSalaries += employee.getPosition().getBaseSalary();
        }
        return formatter.format(allSalaries);
    }

    public char getStoreSize(){

        if(this.getQuantityEmployees() < 10) {
            return 'P';
        } else if (this.getQuantityEmployees() >= 10 && this.getQuantityEmployees() <= 30){
            return 'M';
        } else if (this.getQuantityEmployees() >= 31){
            return 'G';
        }

        return 'N';
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployeeToStore(Employee employee) {
        this.employees.add(employee);
    }

    public int getQuantityEmployees() {
        return quantityEmployees;
    }

    public double getCommissionOnSales() {
        return commissionOnSales;
    }

    public void setCommissionOnSales(double commissionOnSales) {
        this.commissionOnSales = commissionOnSales;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String formatSizeStore(){
        switch (this.getStoreSize()) {
            case 'P':
                return "loja pequena";
            case 'M':
                return "loja espaçosa";
            case 'G':
                return "loja grande";
        }
        return "tamanho não declarado";
    }

    public ArrayList<Product> getStockProducts() {
        return stockProducts;
    }

    public void setStockProducts(ArrayList<Product> stockProducts) {
        this.stockProducts = stockProducts;
    }

    public int getMaxProducts() {
        return maxProducts;
    }

    public void setMaxProducts(int maxProducts) {
        this.maxProducts = maxProducts;
    }

    public boolean dropProduct(String productName) {
        for (int i = 0; i < this.getStockProducts().size(); i++) {
            if (this.getStockProducts() != null && this.getStockProducts().get(i).getNameProduct().equals(productName)) {
                System.out.println("O produto " + this.getStockProducts().get(i).getNameProduct() + " foi removido com sucesso.");
                this.getStockProducts().remove(i);
                return true;
            }
        }

        return false;
    }

    public void showAllProducts(){
        System.out.println("Os produtos da loja são: ");
        for (Product product: stockProducts) {
            System.out.println(product.toString());
        }
    }



    @Override
    public String toString() {
        return "A loja " + this.getNameStore() + " foi fundada em " + this.getFoundationDate() +
                " no " + this.getAddress() +
                ". É uma " + this.formatSizeStore() + " com "
                + this.getStockProducts() + ", possui "
                + this.getQuantityEmployees() + " empregados, sendo eles "
                + this.getEmployees().toString() + " com "
                + this.getCommissionOnSales()+ "%" + " de comissão e "
                + this.salaryExpenses() + " com gastos de salário.";

    }
}
