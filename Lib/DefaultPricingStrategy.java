package Lib;

import java.util.ArrayList;

import Lib.Discount.*;

public class DefaultPricingStrategy {
    private record  StrategyRule(String sku , DiscountStrategy strategy) {}
    private final ArrayList<StrategyRule> strategies = new ArrayList<>(null);
    private final DefaultPricingStrategy defailsrategy = new DefaultPricingStrategy();
    
 
    /*
     * ลงทะเบียนกลยุทธ์ส่วนลดสำหรับสินค้า SKU ที่กำหนด
     */
}
