package Lib;
import java.util.ArrayList;


public class ShoppingCart {
  //Rep Invariant (RI):
  // - ArrayList CartItem is not null.

   private final ArrayList<CartItem> items;
    private final PricingService pricingService;
    private final ProductCatalog productCatalog;



    public ShoppingCart(PricingService  pricingService,ProductCatalog productCatalog){
      this.items = new ArrayList<>();
      this.pricingService = pricingService;
      this.productCatalog = productCatalog;
      checkRep();
    }

 
   public void addItem(String productId , int quantity){
      Product product = productCatalog.findById(productId);
        if (product == null) {
            return ;
        }

        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                item.increaseQuantity(quantity);
                checkRep();
                return;
            }
        }

        items.add(new CartItem(product, quantity));
        checkRep();
    }
    public void removeItem(String productId){
       for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getProductId().equals(productId)) {
                items.remove(i);
                checkRep();
                break;
            }
       }
    }

    public double getTotalPrice(){

        double tatol = 0;
        for (CartItem item : items) {
            tatol += pricingService.calculateItemPrice(item);
        }
        return tatol;
    }


    public int getItemCount(){
        return items.size();
    }

    public void clearCart(){
        items.clear();
        checkRep();
    }
    private void checkRep() {
        if (items == null) {
            throw new RuntimeException("RI violated: items must not be null.");
        }

        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i).getProduct().equals(items.get(j).getProduct())) {
                    throw new RuntimeException("RI violated: duplicate products found in cart.");
                }
            }
        }
    }
}