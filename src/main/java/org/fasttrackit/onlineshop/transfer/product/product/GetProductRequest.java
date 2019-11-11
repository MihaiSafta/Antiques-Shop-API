package org.fasttrackit.onlineshop.transfer.product.product;

public class GetProductRequest {
    private String partialName;
    //wrapper classes accept null values as wel
    private Integer minimumQuantity;


    public String getPartialName() {
        return partialName;
    }

    public void setPartialName(String partialName) {
        this.partialName = partialName;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    @Override
    public String toString() {
        return "GetProductRequest{" +
                "partialName='" + partialName + '\'' +
                ", minimumQuantity=" + minimumQuantity +
                '}';
    }
}
