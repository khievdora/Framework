package test;

import main.dbsub.AddressImpl;
import main.dbsub.IAddress;
import main.model.FRAddressModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 4/22/2017.
 */
public class AddressMainTest {

    public static void main(String[] args) {

        AddressMainTest main = new AddressMainTest();

        IAddress iAddress = new AddressImpl();

        // List all address
        List<FRAddressModel> addressList = new ArrayList<>();
        addressList = iAddress.getAllAddress();
        main.displayAllAddresses(addressList);

        // Add address
//        FRAddressModel address = new FRAddressModel(0, "52558", "12 K Kerkwood St", "Fairfield", "IOWA",
//                "USA");
//        iAddress.saveAddress(address);

        // Update address
//        FRAddressModel updateAddress = iAddress.getAddressById(3);
//        updateAddress.setState("TEXAS");
//        updateAddress.setZip("53443");
//        iAddress.updateAddress(updateAddress);
//        System.out.println(updateAddress.toString());

        // Delete FRAddressModel
        iAddress.deleteAddressById(3);
        addressList = iAddress.getAllAddress();
        main.displayAllAddresses(addressList);

    }

    public void displayAllAddresses(List<FRAddressModel> addressList) {
        System.out.println("-------------------------------");
        System.out.println("FRAddressModel List");
        System.out.println("-------------------------------");
        addressList.forEach(System.out::println);
    }
}
