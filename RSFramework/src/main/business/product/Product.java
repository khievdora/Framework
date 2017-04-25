package main.business.product;

import main.model.FRProductModel;

/**
 * Created by gebre on 4/25/2017.
 */
public abstract class Product {
    public IProduct iProduct;

    public Product(IProduct iProduct) {
        this.iProduct = iProduct;
    }
    public int savaProduct(FRProductModel productModel){
        if(!validateProduct(productModel)){
            return 0;
        }
        return  this.iProduct.saveProduct(productModel);
    }
    public abstract boolean validateProduct(FRProductModel productModel);
}
