package Lib;

import java.util.ArrayList;

import Lib.Discount.DefaultPricingStrategy;

public class PricingService {
    private record  StrategyRule(String sku, DiscountStrategy strategy) {};

    private final ArrayList<StrategyRule> strategies = new ArrayList<>();

    private final DiscountStrategy defaultStrategy = new DefaultPricingStrategy();

    /**
     * ลงทะเบียนกลยุทธ์ สำหรับส่วนลดสินค้า SKU ที่กําหนด
     * หากมีโปรโมชันสำหรับ SKU  นี้จะถูกแทนที่ด้วยอันใหม่
     * @param sku รหัสสินค้าที่ต้องการผูกโปรโมชัน
     * @param strategy กลยุทธ์ทีส่วนลดที่จะใช้
     */
    public void addStrategy(String sku, DiscountStrategy strategy){
      StrategyRule ruleToRemove = null;
      for(StrategyRule rule : strategies){
        if (rule.sku().equals(sku)) {
          ruleToRemove = rule;
          break;
        }
      }
      if (ruleToRemove != null) {
        strategies.remove(ruleToRemove);
        
      }
      strategies.add(new StrategyRule(sku, strategy));
    }
    /**
     * คำนวณราคาสุทธิของสินค้า 1 รายการโดยใช้กลยุทธ์ที่เหมาะสม
     * @param item รายการสินค้าที่ต้องการคำนวณราคา
     * @return ราคาสุทธิหลังหักส่วนลด
     */
    public double calculateItemPrice(CartItem item){
      String sku = item.getProduct().getProductId();
      for(StrategyRule rule : strategies){
        if (rule.sku().equals(sku)) {
          return rule.strategy().calculatePrice(item);
        }
      }
      return defaultStrategy.calculatePrice(item);
    }
    
}
