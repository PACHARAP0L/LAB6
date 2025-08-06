package Lib;
/*
 * ADT ที่ไม่เปลี่ยนรูป (Immutable) สำหรับเก็บข้อมูลสินค้า
 * คลาสนี้เป็น final เพื่อป้องกันการสืบทอดและรับประกัน Immutability
 */
public final class Product {
    private final String productId;
    private final String productName;
    private final double price;

    // Rep Invaraint (RI):
    // -productId and ProductName are not null or blank.
    // -price >=0.
    //
    // Abstraction Function (AF):
    // -AF(prpductId, productName, price) =A product with 
    // the given ID, name, and price.

    /*
     * ตรวจสอบว่า Rep Invaraint เป็นจริงหรือไม่
     */


    private void checkRep() {
        if(productId == null || productId.isBlank()){
            throw new RuntimeException("RI violated: productID is can not be null");
        }
        if(productName == null || productName.isBlank()){
            throw new RuntimeException("RI violated: productName is can not be null");
        }
        if(price < 0){
            throw new RuntimeException("RI violated: price is can not be negative");
        }
    }
    /**
     * สร้างอ็อบเจกต์ Product
     * @param productId รหัสสินค้า ห้ามเป็นค่าว่าง
     * @param productName ชื่อสินค้า ห้ามเป็นค่าว่าง
     * @param price ราคาสินค้าห้ามเป็นค่า
     */
    public Product(String productId, String productName, double price){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {return productId; }

    public String getProductName() {return productName; }

    public double getPrice() {return price; }

    /**
     * เปรียบเทียบ Product สองชิ้นโดยใช้ productId
     * @param obj อ็อบเจกต์ที่ต้องการเปรียบเทียบ
     * @return true หาห ProductId เหมือนกัน
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productId.equals(product.productId);
    }

}
