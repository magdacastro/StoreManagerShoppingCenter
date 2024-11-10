package Product;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

import Date.*;

public class Product {
    private static int nextId = 1;
    private final int id;
    private String nameProduct;
    private double price;
    private Date expirationDate;
    private final NumberFormat formatter;

    public Product(String nameProduct, double price, Date expirationDate) {
        this.id = nextId++;
        this.nameProduct = nameProduct;
        this.price = price;
        this.expirationDate = expirationDate;
        formatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    }

    public int getId() {
        return id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public String getFormatedPrice() {
        return formatter.format(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean IsProductExpirationDate(Date date) {
        LocalDate dateExpiration = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());

        LocalDate currentDate = LocalDate.now();

        if(currentDate.isBefore(dateExpiration) || currentDate.isEqual(dateExpiration)){
            System.out.println("Produto não vencido");
            return false;
        }

        System.out.println("Produto vencido");
        return true;
    }

    @Override
    public String toString() {
        return "O produto " + this.getNameProduct() + " custa " + this.getFormatedPrice() + " e expira em " + this.getExpirationDate();
    }
}
