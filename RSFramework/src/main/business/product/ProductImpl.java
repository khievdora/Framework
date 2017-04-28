package main.business.product;

import main.db.DBFacade;
import main.model.FRProductModel;

import java.util.List;

/**
 * Created by gebre on 4/25/2017.
 */
public class ProductImpl extends Product{
    protected DBFacade dbFacade=null;
    public ProductImpl(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }
    @Override
    public int saveProduct(FRProductModel frProductModel) {
        return 0;
    }

    @Override
    public int updateProduct(FRProductModel frProductModel) {
        return 0;
    }

    @Override
    public int deleteProduct(FRProductModel frProductModel) {
        return 0;
    }

    @Override
    public int deleteProductById(int productId) {
        return 0;
    }

    @Override
    public FRProductModel getProductById(int productId) {
        return null;
    }

    @Override
    public List<FRProductModel> getAllProducts() {
        return null;
    }

    @Override
    public void test() {

    }
}
