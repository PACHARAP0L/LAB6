package Lib;
 /**
   *  Rep Invariant (RI):
   * -ArrayList ภายใน  CartItems ต้องไม่เป็น null
   * - Product ห้ามซ้ำกันใน CartItem  
   */

import java.util.ArrayList;

public class ShoppingCart {

  ArrayList<CartItem> cartItems;
  PricingService pricingService = new PricingService();
  ProductCatalog productCatalog = new ProductCatalog();

  public void checkRep(){
    if (cartItems == null) {
      throw new RuntimeException("RI violated : cartItems is can not be null");
    }
    for(int i = 0; i < cartItems.size(); i++){
      for(int j = i + 1; j < cartItems.size(); j++){
        if (cartItems.get(i).equals(cartItems.get(j))) {
          throw new RuntimeException("RI violated : Product is can not be duplicate");
          
        }
      }
    }
  }

  public ShoppingCart(PricingService pricingService, ProductCatalog productCatalog) {
    this.pricingService = pricingService;
    this.productCatalog = productCatalog;
    this.cartItems = new ArrayList<>();
    checkRep();
  }

  /**
   * เพิ่มสินค้าใหม่เข้าสู่ CartItems
   * @param productId รหัสสินค้าที่ต้องการเพิ่ม
   * @param quantity จำนวนสินค้าที่ต้องการเพิ่ม
   */
  public void addItem(String productId, int quantity) {
    Product product = productCatalog.findById(productId);
  if (product == null || quantity <= 0) {
    return;
  }
    for(CartItem items : cartItems){
      if (items.getProduct().getProductId().equals(productId)) {
        items.increasesQuantity(quantity);
        return;
        
      }
    }
    cartItems.add(new CartItem(product, quantity));
    checkRep();
  }

  /**
   * ลบสินค้าใน CartItems
   * @param ProductId รหัสสินค้าที่ต้องการลบ
   */
  public void removeItem(String ProductId){
    for(CartItem items : cartItems){
      if (items.getProduct().getProductId().equals(ProductId)) {
        cartItems.remove(items);
        return;
        
      }
    }
  }

  /**
   * จํานวนสินค้าในตะกร้า
   * @return จํานวนสินค้า
   */

  public int getItemCount(){
    return cartItems.size();
  }

  /**
   * ล้างสินค้าในตะกร้า
   */
  public void clearCart(){
    cartItems.clear();
    checkRep();
  }
/**
 * คำนวนค่ารวมทั้งหมดของสินค้าในตะกร้า
 * @return ค่ารวม
 */
  public double getTotalPrice(){
    double total = 0.0;
    for(CartItem items : cartItems){
        double price = pricingService.calculateItemPrice(items);
        total += price;
    }
    return total;
  }

  
  

}