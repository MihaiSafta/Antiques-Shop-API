package org.fasttrackit.onlineshop;

import org.fasttrackit.onlineshop.domain.Product;
import org.fasttrackit.onlineshop.exception.ResourceNotFoundException;
import org.fasttrackit.onlineshop.service.ProductService;
import org.fasttrackit.onlineshop.steps.ProductSteps;
import org.fasttrackit.onlineshop.transfer.product.SaveProductRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductSteps productSteps;
    @Test
    public void testCreateProduct_whenValidRequest_thenReturnCreatedProduct(){
        Product product = productSteps.createProduct();
    }



    @Test(expected = TransactionSystemException.class)
public void testCreateProduct_whenInvalidRequest_thenTrowException(){
        SaveProductRequest request = new SaveProductRequest();
        //not setting any values on the request, because we want to send an invalid request
        productService.createProduct(request);


}
@Test
public void testGetProduct_whenExistingEntity_thenReturnProduct() {
    Product createdProduct = productSteps.createProduct();
    Product retrievedProduct = productService.getProduct(createdProduct.getId());

    assertThat(retrievedProduct,notNullValue());
    assertThat(retrievedProduct.getId(), is(createdProduct.getId()));
    assertThat(retrievedProduct.getName(), is(createdProduct.getName()));

}
@Test(expected = ResourceNotFoundException.class)
public void testGetProduct_whenNonExistingEntity_thenTrowNotFoundException(){
        productService.getProduct(99999);
}
@Test
private void updateProduct_whenValidRequest_thenReturnUpdateProduct(){
    Product createdProduct = productSteps.createProduct();
    SaveProductRequest request = new SaveProductRequest();
    request.setName(createdProduct.getName() + "Updated");
    request.setPrice(createdProduct.getPrice() + 10);
    request.setQuantity(createdProduct.getQuantity() + 10);

    Product updatedProduct = productService.updateProduct(createdProduct.getId(), request);
    assertThat(updatedProduct, notNullValue());
    assertThat(updatedProduct.getId(), greaterThan(0L));
    assertThat(updatedProduct.getId(), is(createdProduct.getId()));
    assertThat(updatedProduct.getPrice(), is(request.getPrice()));
    assertThat(updatedProduct.getName(),is(request.getName()));
    assertThat(updatedProduct.getQuantity(), is(request.getQuantity()));


}






}

