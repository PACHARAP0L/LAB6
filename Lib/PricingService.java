package Lib;


import java.util.ArrayList;
import Lib.Discount.*;

public class PricingService {
  private record StrategyRule(String sku, DiscountStrategy strategy) {}  

  private final ArrayList<StrategyRule> strategies = new ArrayList<>();
  
  private final DiscountStrategy defaultStrategy = new DefaultPricingStrategy();

  /**
   * ลงทะเบียนกลยุทธืส่วนลดสำหรับสินค้า SKU ที่กำหนด
   * หากมีโปรโมชั่นสำหรับ SKU นี้อยู่แ้ลว จะถูกแทนที่ด้วยอันไหม่
   * @param sku รหัสสินค้าที่ต้องการผูกกับโปรชั่น
   * @param strategy กลยุทธ์ส่วนลดที่จะใช้
   */
   public void addStrategy(String sku, DiscountStrategy strategy) {
    StrategyRule ruleToRemove = null;
    for (StrategyRule rule : strategies) {
        if(rule.sku().equals(sku)) {
        ruleToRemove = rule;
        break;
        }
    }
    if (ruleToRemove != null){
        strategies.remove(ruleToRemove);
    }
    strategies.add(new StrategyRule(sku, strategy));
   }

   public double calculatePrice(CartItem item){
    String sku = item.getProduct().getProductId();
    for (StrategyRule rule : strategies){
        if (rule.sku().equals(sku)){
            return rule.strategy().calculatePrice(item);
        }
    }
    return defaultStrategy.calculatePrice(item);
   }

   public double calculateItemPrice(CartItem singleApple) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'calculateItemPrice'");
   }
}