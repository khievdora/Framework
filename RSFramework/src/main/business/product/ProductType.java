package main.business.product;

import main.model.FRProductTypeModel;

/**
 * Created by gebre on 4/25/2017.
 */
public abstract class ProductType {
    public IProductType iProductType;
    public ProductType(IProductType iProductType){
        this.iProductType=iProductType;
    }

    public abstract boolean validateProductType(IProductType iProductType);
}
