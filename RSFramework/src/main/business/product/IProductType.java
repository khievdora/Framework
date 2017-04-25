package main.business.product;

import main.model.FRProductTypeModel;

import java.util.List;

/**
 * Created by Dora on 4/24/2017.
 */
public interface IProductType {
    public int saveProductType(FRProductTypeModel frProductTypeModel);
    public int updateProductType(FRProductTypeModel frProductTypeModel);
    public int deleteProductType(FRProductTypeModel frProductTypeModel);
    public int deleteProductTypeById(int productTypeId);
    public FRProductTypeModel getProductTypeById(int productTypeId);
    public List<FRProductTypeModel> getAllProductTypes();
}
