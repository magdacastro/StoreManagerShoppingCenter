import Address.Address;
import Date.Date;
import Employee.*;
import Address.*;
import Product.Product;
import Store.Store;


import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingSystemControl {
    Scanner scan = new Scanner(System.in);
    ArrayList<Store> stores = new ArrayList<>();


    public void register(){
        int option;
        do {
        System.out.println("\n--- Menu de Opções ---");
        System.out.println("1. Opção 1 - Criar uma loja");
        System.out.println("2. Opção 2 - Criar um produto");
        System.out.println("3. Opção 3 - Sair");
        System.out.print("Escolha uma opção: ");
        option = scan.nextInt();

            switch (option) {
                case 1:
                    this.createStore();
                    break;
                case 2:
                    this.createProduct();
                    break;
                case 3:
                    System.out.print("Saindo do programa... ");
                    scan.close();
                    return;
                default:
                    System.out.println("Error: Opção inválida.");

            }
        } while (option < 1 || option > 3);
    }

    private int getCommissionStore(){
        int commission;
        do {
            System.out.println("Digite o valor de comissão de vendas da loja: ");
            commission = scan.nextInt();

            if(commission < 0 || commission > 100) {
                System.out.println("O valor de comissão de vendas da loja precisa ser entre 0 e 100: ");
            }
        } while (commission < 0 || commission > 100);
        return commission;

    }

    private void createStore(){
        int addMore;
        do {
            int commission = this.getCommissionStore();
            scan.nextLine();

            System.out.println("Digite o nome da loja: ");
            String nameStore = scan.nextLine();

            Address address = storeAddrees();

            Date foundationDate = storeFoundationDate();

            System.out.println("Digite o número máximo de produtos: ");
            int maxProductsInStore = scan.nextInt();

            scan.nextLine();

            ArrayList<Employee> employees = this.addEmployee();

            Store store = new Store(nameStore, employees, commission, address, foundationDate, maxProductsInStore);

            System.out.println(store.getEmployees().toString());
            stores.add(store);

            int option;
            do {
                System.out.println("Deseja criar um produto para a loja?");
                System.out.println("Opção 1 - Sim\n" + "Opção 2 - Não");
                option = scan.nextInt();

                if(option == 1) {
                    this.createProduct();
                }

            } while (option != 1 && option != 2);


            System.out.println("Deseja criar outra loja?");
            System.out.println("Opção 1 - Sim\n" + "Opção 2 - Não");
            addMore = scan.nextInt();

            while (addMore != 1 && addMore != 2) {

                System.out.println("Erro: Opção inválida. Digite 1 para Sim ou 2 para Não.");
                System.out.println("Opção 1 - Sim\n" + "Opção 2 - Não");
                addMore = scan.nextInt();

            }


        } while (addMore == 1);

    }

    private int getDay(String message){
        int day;
        do {
            System.out.println(message);
            day = scan.nextInt();

            if (day < 1 || day > 31) {
                System.out.println("Erro: O dia deve estar entre 1 e 31. Tente novamente.");
            }
        } while (day < 1 || day > 31);
        return day;
    }

    private int getMonth(String message){
        int month;
        do {
            System.out.println(message);
            System.out.println("Opção 1 - Janeiro,\n" +
                    "Opção 2 - Fevereiro,\n" +
                    "Opção 3 - Março,\n" +
                    "Opção 4 - Abril,\n" +
                    "Opção 5 - Maio,\n" +
                    "Opção 6 - Junho,\n" +
                    "Opção 7 - Julho,\n" +
                    "Opção 8 - Agosto,\n" +
                    "Opção 9 - Setembro, \n" +
                    "Opção 10 - Outubro,\n" +
                    "Opção 11 - Novembro,\n" +
                    "Opção 12 - Dezembro");
            month = scan.nextInt();

            if (month < 1 || month > 12) {
                System.out.println("Error: Opção inválida.");
            }
        } while (month < 1 || month > 12);

        return month;

    }

    private Integer getYear(String message){
        String yearInput;
        Integer year = null;

        do {
            System.out.print(message);
            yearInput = scan.nextLine();
            
            if (yearInput.matches("\\d{4}")) {
                year = Integer.parseInt(yearInput);
            } else {
                System.out.println("Erro: O ano deve ter exatamente 4 dígitos. Tente novamente.");
            }

        } while(year == null);

       return year;
    }

    private Integer getZipCode(){
        String zipCodeInput;
        Integer zipCode = null;

        do {
            System.out.println("Digite o cep: ");
            zipCodeInput = scan.nextLine();

            if (zipCodeInput.matches("\\d{8}")) {
                zipCode = Integer.parseInt(zipCodeInput);
            } else {
                System.out.println("Error: O cep deve ter exatamente 8 dígitos. Tente novamente.");
            }
        } while(zipCode == null);

        return zipCode;

    }


    private Date storeFoundationDate(){
        int day = this.getDay("Digite o dia de fundação da loja: ");
        scan.nextLine();
        int month = this.getMonth("Escolha qual foi o mês de fundação da loja: ");
        scan.nextLine();
        int year = this.getYear("Digite o ano de fundação da loja (4 dígitos): ");
        return new Date(day, month, year);
    }



    private Address storeAddrees(){
        System.out.println("Digite o nome da rua onde fica a loja: ");
        String street = scan.nextLine();
        System.out.println("Digite o nome do bairro: ");
        String complement = scan.nextLine();
        System.out.println("Digite o número do prédio da loja: ");
        int number = scan.nextInt();
        scan.nextLine();
        int zipCode = this.getZipCode();


        System.out.println("Escolha a cidade: ");
        City city = chooseCity();
        System.out.println("Escolha o estado: ");
        State state = chooseState();
        System.out.println("Escolha o país: ");
        Country country = chooseCountry();
        return new Address(street, number, zipCode, complement, city, state, country);
    }

    private ArrayList<Employee> addEmployee(){
        int addMore;
        ArrayList<Employee> employees = new ArrayList<>();

        do {
            System.out.println("Digite o nome do funcionário da loja: ");
            String nameEmployee = scan.nextLine();
            System.out.println("Escolha o cargo do funcionário: ");
            Position position = choosePosition();

            employees.add(new Employee(nameEmployee, position));
            System.out.println("Funcionário adicionado com sucesso!" + "\n" + "Deseja adicionar outro funcionário? ");
            System.out.println("Opção 1 - Sim\n" + "Opção 2 - Não");

            addMore = scan.nextInt();

            while (addMore != 1 && addMore != 2) {
                System.out.println("Erro: Opção inválida. Digite 1 para Sim ou 2 para Não.");
                System.out.println("Opção 1 - Sim\n" + "Opção 2 - Não");
                addMore = scan.nextInt();
            }
            scan.nextLine();

        } while (addMore == 1);

        return employees;
    }

    private Position choosePosition(){
        int option;
        Position position = null;

        do {
            System.out.println("Opção 1 - Estagiário,\n" +
                    "Opção 2 - Vendedor,\n" +
                    "Opção 3 - Estoquista,\n" +
                    "Opção 4 - Supervisor,\n" +
                    "Opção 5 - Gerente");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    position = Position.INTERN;
                    break;
                case 2:
                    position = Position.SALESMAN;
                    break;
                case 3:
                    position = Position.STOCKIST;
                    break;
                case 4:
                    position = Position.SUPERVISOR;
                    break;
                case 5:
                    position = Position.MANAGER;
                    break;
                default:
                    System.out.println("Error: Opção inválida.");
            }
        } while (option < 1 || option > 5);

        return position;
    }

    private City chooseCity(){
        int option;
        City city = null;

        do {
            System.out.println("Opção 1 - Porto Alegre,\n" +
                    "Opção 2 - São Leopoldo,\n" +
                    "Opção 3 - Novo Hamburgo\n");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    city = City.PORTO_ALEGRE;
                    break;
                case 2:
                    city = City.SAO_LEOPOLDO;
                    break;
                case 3:
                    city = City.NOVO_HAMBURGO;
                    break;
                default:
                    System.out.println("Error: Opção inválida.");
            }

        } while(option < 1 || option > 3);

        return city;
    }

    private State chooseState(){
        int option;
        State state = null;
        do {
            System.out.println("Opção 1 - Rio Grande do Sul,\n" +
                    "Opção 2 - Santa Catarina,\n" +
                    "Opção 3 - Parana\n");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    state = State.RIO_GRANDE_DO_SUL;
                    break;
                case 2:
                    state = State.SANTA_CATARINA;
                    break;
                case 3:
                    state = State.PARANA;
                    break;
                default:
                    System.out.println("Error: Opção inválida.");
            }
        } while(option < 1 || option > 3);
      return state;
    }

    private Country chooseCountry(){
        int option;
        Country country = null;

        do {
            System.out.println("Opção 1 - Brasil,\n" +
                    "Opção 2 - Argentina,\n" +
                    "Opção 3 - Chile\n");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    country = Country.BRASIL;
                    break;
                case 2:
                    country = Country.ARGENTINA;
                    break;
                case 3:
                    country = Country.CHILE;
                    break;
                default:
                    System.out.println("Error: Opção inválida.");
            }
        } while (option < 1 || option > 3);

        return country;
    }

    private Date expirationDate(){
        int expirationDay = this.getDay("Precisamos da data de validade do produto. Digite o dia da validade: ");
        scan.nextLine();
        int expirationMonth = this.getMonth("Agora digite o mês da data de validade: ");
        scan.nextLine();
        int expirationYear = this.getYear("Por último, digite o ano da data de validade (4 dígitos): ");

        return new Date(expirationDay, expirationMonth, expirationYear);
    }

    private void createProduct(){
        int addMore;

        if(stores.isEmpty()) {
            System.out.println("Não há lojas cadastradas. Por favor, crie uma loja.");
            this.createStore();
        }

        do {
            scan.nextLine();

            System.out.println("Digite o nome do produto: ");
            String nameProduct = scan.nextLine();

            System.out.println("Digite o preço do produto: ");
            double priceProduct = scan.nextDouble();

            Date expirationDate = this.expirationDate();

            Product product = new Product(nameProduct, priceProduct, expirationDate);

            if(product.IsProductExpirationDate(expirationDate)) {
                System.out.println("Não será possível adicioná-lo a lista de produtos.");
            } else {
                Store lastCreatedStore = stores.getLast();
                lastCreatedStore.getStockProducts().add(product);
                System.out.println("Produto criado com sucesso!");

            }

            System.out.println("Deseja criar outro produto? ");
            System.out.println("Opção 1 - Sim\n" + "Opção 2 - Não");
            addMore = scan.nextInt();

            while (addMore != 1 && addMore != 2) {

                System.out.println("Erro: Opção inválida. Digite 1 para Sim ou 2 para Não.");
                System.out.println("Opção 1 - Sim\n" + "Opção 2 - Não");
                addMore = scan.nextInt();

            }

            for(Store store: stores){
                if(addMore == 1 && store.getStockProducts().size() >= store.getMaxProducts()) {
                    System.out.println("Quantidade máxima de produtos alcançada: " + store.getMaxProducts());
                    addMore = 2;
                }
            }

        } while (addMore == 1);

    }


    public void showAllInformation() {
        System.out.println(
                "O Sistema de Controle do Shopping possui ");
        for(Store store: stores){
            System.out.println(store.toString());
        }

    }
}
