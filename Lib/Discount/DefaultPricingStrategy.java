package Lib.Discount;

import Lib.CartItem;
import Lib.DiscountStrategy;

public class DefaultPricingStrategy implements DiscountStrategy{
    @Override
    public double calculatePrice(CartItem item){
        return item.getProduct().getPrice() * item.getQuantity();
    }
}
