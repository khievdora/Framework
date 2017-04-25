package main.business.product;

import main.model.FRProductModel;

import java.util.List;

/**
 * Created by Dora on 4/24/2017.
 */
public interface IProduct {
    public int saveProduct(FRProductModel frProductModel);
    public int updateProduct(FRProductModel frProductModel);
    public int deleteProduct(FRProductModel frProductModel);
    public int deleteProductById(int productId);
    public FRProductModel getProductById(int productId);
    public List<FRProductModel> getAllProducts();
}
