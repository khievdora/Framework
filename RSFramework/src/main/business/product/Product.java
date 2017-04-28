package main.business.product;

import main.model.FRProductModel;
import java.util.List;

/**
 * Created by Dora on 4/24/2017.
 */
public abstract class Product {
    public abstract int saveProduct(FRProductModel frProductModel);
    public abstract int updateProduct(FRProductModel frProductModel);
    public abstract int deleteProduct(FRProductModel frProductModel);
    public abstract int deleteProductById(int productId);
    public abstract FRProductModel getProductById(int productId);
    public abstract List<FRProductModel> getAllProducts();
    public abstract void test();
}
