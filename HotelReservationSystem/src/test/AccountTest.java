package test;

import main.dbsub.DBFacadeImpl;

/**
 * Created by gebre on 4/21/2017.
 */
public class AccountTest {
    public static void main(String[] args) {
        DBFacadeImpl df = new DBFacadeImpl();
        System.out.println(df.getAccountByUserNameAndPassword("gk","123"));

    }

}
