package Lib;

import java.util.ArrayList;

public class ProductCatalog {
    private ArrayList<Product> products =new ArrayList<>();

    //RI: produxts list is not null, contains no null elements,
    // and no duplicates products.
    //AF: AF(products) = A catalog of all availavle products.

    private void checkRep() {
        if(products == null){
            throw new RuntimeException("RI violated: products is can not be null");
        }
        // Check gor duplicate products 
        for (int i=0; i< products.size(); i++){
            for(int j=i+1; j< products.size(); j++){
                if (products.get(i).equals(products.get(j))){
                    throw new RuntimeException("RI violated : Product is can not be duplicate");
                }
            }
        }
    }

    public ProductCatalog() {
        checkRep();
    }
    /**
     * เพิ่มสินค้าใหม่เข้าสู่ Catalog
     * @param product สินค้าที่ต้องการเพิ่ม
     */
    public void addProduct(Product product){
        if (product !=null && !products.contains(product)){
             products.add(product);
        }
       checkRep();
    }
    /**
     * ค้นหาสินค้าจากรหัสสินค้า
     * @param productId รหัสสินค้าที่ต้องการค้นหา
     * @return อ็อบเจกต์ Product หากพบ, หรือ null หากไม่พบ
     */


    public Product findById(String productId){
        for (Product p : products){
            if(p.getProductId().equals(productId)){
                return p;
            }
        }
        return null;
    }
}
