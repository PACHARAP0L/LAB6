package Lib;
/* ADT ที่ไม่เปลี่ยนรูป (Immutable) สำหรับเก็บข้อมูลสินค้า
 * คลาสนี้เป็น final เพื่อป้องกันการสืบทอดและรับประกัน Immutability
 */
public final class Product {
    private final String productId;
    private final String productName;
    private final double price;
    //Rep Invariant (RI)
    // -productId and productName are not null or blank
    //price >= 0
    // Abstraction Function (AF):
    // - AF(productId, productName, price) = A product with the 
    //  the given Id, Name and price.
    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep(){
        if (productId == null || productId.isBlank()) {
            throw new RuntimeException("RI violated : ");
        }
        if (productName == null || productName.isBlank()) {
            throw new RuntimeException("RI violated : ");
        }
        if(price < 0){
            throw new RuntimeException("RI violated : ");
        }
    }
     /**
     * สร้างอ็อบเจกต์ Product
     * @param productId รหัสสินค้า ห้าทเป็นค่าว่าง
     * @param productName ชื่อสินค้า ห้ามเป็นค่าว่าง
     * @param price ราคา ต้องไม่ติดลบ
     */

     public Product(String productId, String productName, double price){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        checkRep();
     }
     public String getProductId() {
         return productId;
     }
     public String getProductName() {
         return productName;
     }
     public double getPrice() {
         return price;
     }
    /**
     * เปรียบเทียบ Product สองชิ้นโดยใช้ productId
     * @param obj อ็อบเจกต์ที่ต้องการเปรียบเทียบ
     * @return true หาก productId เหมือนกัน
     */
    
     public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productId.equals(product.productId); 
    }
        
  
}
