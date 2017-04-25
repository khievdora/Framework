package main.business.customer;

import main.model.FRCustomerModel;

/**
 * Created by Gize on 4/25/2017.
 */
public abstract class Customer{
        protected ICustomer iCustomer;

        public Customer(ICustomer iCustomer) {
            this.iCustomer = iCustomer;
        }


        public int saveCustomer(FRCustomerModel customerModel) {
            if (!validateAddress(customerModel)) {
                return 0;
            }
            return this.iCustomer.saveCustomer(customerModel);
        }

        public int updateCustomer(FRCustomerModel rModel) {
            if (!validateAddress(rModel)) {
                return 0;
            }
            return this.iCustomer.updateCustomer(rModel);
        }

        public int deleteCustomer(FRCustomerModel rModel) {
            if (!validateAddress(rModel)) {
                return 0;
            }
            return this.iCustomer.deleteCustomerById(rModel.getCode());
        }

        protected abstract boolean validateAddress(FRCustomerModel rModel);


}
