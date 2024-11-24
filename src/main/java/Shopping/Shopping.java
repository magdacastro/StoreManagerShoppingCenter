package Shopping;

import Address.*;
import Store.*;

import java.util.ArrayList;

public class Shopping {
    private String shoppingName;
    private Address shoppingAddress;
    private ArrayList<Store> stores;
    private int maxStores;

    public Shopping(String shoppingName, Address shoppingAddress, int maxStores) {
        this.shoppingName = shoppingName;
        this.shoppingAddress = shoppingAddress;

        if(maxStores <= 0) {
            System.out.println("Você precisa ter no mínimo 1 como quantidade máxima de lojas no shopping.");
            this.maxStores = 1;
        } else {
            this.maxStores = maxStores;
        }

        this.stores = new ArrayList<>(maxStores);
    }


    public String getShoppingName() {
        return shoppingName;
    }

    public void setShoppingName(String shoppingName) {
        this.shoppingName = shoppingName;
    }

    public Address getShoppingAddress() {
        return shoppingAddress;
    }

    public void setShoppingAddress(Address shoppingAddress) {
        this.shoppingAddress = shoppingAddress;
    }

    public ArrayList<Store> getShoppingStores() {
        return stores;
    }

    public void setShoppingStores(ArrayList<Store> shoppingStores) {
        this.stores = shoppingStores;
    }

    public int getMaxStores() {
        return maxStores;
    }

    public void setMaxStores(int maxStores) {
        this.maxStores = maxStores;
    }

    public boolean addStore(Store store){
        System.out.println("Adicionando loja: " + store.getNameStore());
            if(this.getShoppingStores().size() < this.getMaxStores()) {
                this.getShoppingStores().add(store);
                System.out.println("Loja adicionada com sucesso!");
                return true;
            }


        System.out.println("Quantidade máxima de lojas alcançada: " + this.getMaxStores());
        return false;
    }


    private boolean dropStoreShopping(String nameStore){
        for(int i = 0; i < this.getShoppingStores().size(); i++){
            if(this.getShoppingStores().get(i).getNameStore().equals(nameStore)){
                System.out.println("A loja " + this.getShoppingStores().get(i).getNameStore() + " foi removida com sucesso.");
                this.getShoppingStores().remove(i);
                return true;
            }
        }
        return false;
    }

    private int quantityStoresByType(String typeStore){
        int count = 0;

        for(Store store: stores) {
            if(typeStore.equalsIgnoreCase("Vestuário") && store instanceof Clothing) {
                count++;
            } else if (typeStore.equalsIgnoreCase("Cosmético") && store instanceof Cosmetic){
                count++;
            } else if (typeStore.equalsIgnoreCase("Alimentação") && store instanceof FoodStore){
                count++;
            } else if (typeStore.equalsIgnoreCase("Bijuteria") && store instanceof Jewelry){
                count++;
            } else if (typeStore.equalsIgnoreCase("Informática") && store instanceof Computing){
                count++;
            }
        }

        if (count == 0) {
            return -1;
        }

        return count;
    }


    public Store mostExpensiveInsuranceStore() {
        Store mostExpensiveStore = null;
        double highestInsuranceValue = 0;

        for(Store store: stores) {
            if (store instanceof Computing computingStore) {
                double insurance = computingStore.getElectronicsInsurance();

                if (insurance > highestInsuranceValue) {
                    highestInsuranceValue = insurance;
                    mostExpensiveStore = computingStore;
                }
            }
        }

        return mostExpensiveStore;
    }
}
