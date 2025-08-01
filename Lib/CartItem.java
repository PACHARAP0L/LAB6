package Lib;
//ADT ที่เปลี่ยนแปลงได้ (Mutable) สำหรับเก็บข้อมูลสินค้า 1 รายการในตะกร้า

public class CartItem{
    private Product product;
    private int quantity;
    // Rep Invariant (RI): 
    // -product are not null or blank
    // -quantity ต้องมากกว่า 0
    // 
    // Abstraction Function (AF):
    // -
    //

    public CartItem(Product apple, int i) {
        //TODO Auto-generated constructor stub
    }
    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep() {
        if (product == null){
            throw new RuntimeException("RI violated: product cannot be blank");
        }
        if (quantity <= 0) {
            throw new RuntimeException("RI violated: quantity must be blank or less 0");
        }
        
    }
    /**
     * สินค้าในตะกร้า
     * @param product อ็อบเจกต์สินค้า ห้ามเป็นค่าว่าง
     * @param quantity จำนวนสินค้าต้องมากกว่า0
     * @param product 

     */
public CartItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        checkRep();
    }
public Product getProduct() {
    return product;
}
public int getQuantity() {
    return quantity;
}
    
/**เพิ่มจำนวนสินค้าในรายการนี้
 * @param amount จำนวนที่ต้องการเพิ่ม
 */
public void increaseQuantity(int amount){
    if(amount > 0){
        this.quantity += amount;
    }
    checkRep(); //ตรวจสอบหลังเปลี่ยนแปลงสถานะ
}
}

