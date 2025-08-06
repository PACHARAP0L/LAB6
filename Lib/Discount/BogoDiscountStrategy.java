package Lib.Discount;

import Lib.CartItem;
import Lib.DiscountStrategy;

/*
 * การซื้อสินค้าแบบ ซื้อ1แถม1 
 */
public class BogoDiscountStrategy implements DiscountStrategy{
    @Override
    public double calculatePrice(CartItem item){
        int quantity = item.getQuantity();
        double price = item.getProduct().getPrice();
        int quantityToPay = (quantity / 2) + (quantity %2);  // % = หาเอาเศษ
        return price * quantityToPay;
    }
}
