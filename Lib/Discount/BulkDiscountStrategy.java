package Lib.Discount;

import Lib.CartItem;
import Lib.DiscountStrategy;


/*
 * การซื้อสินค้าแบบ BULK ซื้อเยอะลดราคา
 */
public class BulkDiscountStrategy implements DiscountStrategy{
    private final int mininumQuantity;
    private final double discountPercentage;

    public BulkDiscountStrategy(int mininumQuantity, double discountPercentage){
        this.mininumQuantity = mininumQuantity;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(CartItem item){
        double orginalPrice = item.getProduct().getPrice() * item.getQuantity();
        if(item.getQuantity() >= mininumQuantity) {
            return orginalPrice * (1.0 - discountPercentage);
        }
        return orginalPrice;
    }
}
