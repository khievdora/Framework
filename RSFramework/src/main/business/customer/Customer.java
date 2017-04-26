package main.business.customer;

import main.db.DBFacade;
import main.model.FRCustomerModel;

/**
 * Created by Gize on 4/25/2017.
 */
public abstract class Customer{
        protected DBFacade iCustomer;

        public Customer(DBFacade iCustomer) {
            this.iCustomer = iCustomer;
        }


        public int saveCustomer(FRCustomerModel customerModel) {
            if (!validateAddress(customerModel)) {
                return 0;
            }
            return this.iCustomer.saveFRCustomerModel(customerModel);
        }

        public int updateCustomer(FRCustomerModel rModel) {
            if (!validateAddress(rModel)) {
                return 0;
            }
            return this.iCustomer.updateFRCustomerModel(rModel);
        }

        public int deleteCustomer(FRCustomerModel rModel) {
            if (!validateAddress(rModel)) {
                return 0;
            }
            return this.iCustomer.deleteFRCustomerModelById(rModel.getCode());
        }

        protected abstract boolean validateAddress(FRCustomerModel rModel);


}
