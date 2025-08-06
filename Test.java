import Lib.*;

public class Test {

    public static void main(String[] args) {
        Product apple = new Product("P001", "Apple", 10.0);
        Product soda = new Product("P002", "Soda", 5.0);
        Product bread = new Product("P003", "Bread", 20.0);

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(apple);
        catalog.addProduct(soda);
        catalog.addProduct(bread);

        CartItem item1 = new CartItem(catalog.findById("P001"), 2);
        CartItem item2 = new CartItem(soda, 2);

        
    }
}

