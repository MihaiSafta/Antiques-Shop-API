package org.fasttrackit.onlineshop.transfer.product;

public class AddProductToCartRequest {

    private long id;
    private String name;
    private double price;
    private long customerId;
    private long productId;


    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }
}
