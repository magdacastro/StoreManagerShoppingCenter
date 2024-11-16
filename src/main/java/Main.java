import Shopping.ShoppingSystemControl;

public class Main {
    public static void main(String[] args) {

        ShoppingSystemControl systemControl = new ShoppingSystemControl();
        systemControl.register();
        systemControl.showAllInformation();

    }
}