package com.kodilla.good.patterns.food.store;

public class GoodGrains implements FoodProducer {

    private static final String AVAILABLE = "Company: \"%s\", ordered product: \"%s\" (%d pieces per %.2f zl).";
    private static final String NOTAVAILABLE = "Order cannot be executed.\nOrdered: %d piece(s) of \"%s\". " +
            "Left in stock: %d piece(s).";

    private String name = "Good Grains Co.";
    private GoodGrainsProductRepository repository = new GoodGrainsProductRepository();

    public GoodGrainsProductRepository getProducts() {
        return repository;
    }

    @Override
    public boolean process(OrderRequest orderRequest) {
        if (repository.checkSupplies(orderRequest)) {
            repository.updateSupplies(orderRequest);
            System.out.println(String.format(AVAILABLE, name, orderRequest.getProduct().getName(), orderRequest.getQuantity(),
                    orderRequest.getProduct().getPrice()));
            return true;
        }
        System.out.println(String.format(NOTAVAILABLE, orderRequest.getQuantity(), orderRequest.getProduct().getName(),
                repository.getProducts().get(orderRequest.getProduct())));
        return false;
    }
}