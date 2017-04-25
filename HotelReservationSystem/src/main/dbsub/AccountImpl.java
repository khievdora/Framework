package main.dbsub;

import main.model.Account;
import main.model.FRAccountModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 4/21/2017.
 */
public class AccountImpl implements IAccount {

    private IDatabase iDatabase = Database.getInstance();

    @Override
    public int saveAccount(FRAccountModel account) {
        int accountId = 0;
        try{
            String query = "INSERT INTO account(username, password, status, userRole, accountStatus) VALUES(" +
                    "'"+account.getUserName()+"'," +
                    "'"+account.getPassword()+"'," +
                    "'"+account.getStatus()+"'," +
                    "'"+account.getUserRole()+"'," +
                    "'"+account.getAccountStatus()+"')";
            accountId = iDatabase.executeUpdate(query);
            if (accountId != 0) {
                account.setCode(accountId);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }

        return accountId;
    }

    @Override
    public int updateAccount(FRAccountModel account) {
        int result = 0;
        try{
            String query ="UPDATE account SET " +
                    "username='"+account.getUserName()+"', " +
                    "password='"+account.getPassword()+"', " +
                    "status='"+account.getStatus()+"', " +
                    "userRole='"+account.getUserRole()+"', " +
                    "accountStatus= '"+account.getAccountStatus()+"' " +
                    "WHERE idAccount="+account.getCode();
            result = iDatabase.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return result;
    }

    @Override
    public int deleteAccount(FRAccountModel account) {
        int result = 0;
        try{
            String sql = "DELETE FROM account WHERE idAccount = " + account.getCode();
            result = iDatabase.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return result;
    }


    @Override
    public int deleteAccountById(String accountId) {
        int result = 0;
        try{
            String query = "DELETE FROM account WHERE idAccount = "+accountId;
            result = iDatabase.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return result;
    }

    @Override
    public FRAccountModel getAccountById(String accountId) {
        String query = "SELECT * FROM account WHERE idAccount = "+ accountId;
        Account account = new Account();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()) {
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        iDatabase.closeConnection();
        return account;
    }

    @Override
    public FRAccountModel getAccountByUserName(String userName) {
        String query = "SELECT * FROM account WHERE username = '"+ userName +"'";
        Account account = new Account();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()) {
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        iDatabase.closeConnection();
        return account;
    }

    @Override
    public FRAccountModel getAccountByUserNameAndPassword(String userName, String password) {
        String query = "SELECT * FROM account WHERE username = '"+ userName +"' AND password = '" +password+"'";
        Account account = new Account();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()) {
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        iDatabase.closeConnection();
        return account;
    }

    @Override
    public List<FRAccountModel> getAccountByFirstName(String firstName) {
        String query = "SELECT * FROM account WHERE username = '"+ firstName +"'";
        List<FRAccountModel> accounts = new ArrayList<>();
        Account account=new Account();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()){
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
                accounts.add(account);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return accounts;
    }

    @Override
    public List<FRAccountModel> getAccountByLastName(String lastName) {
        String query = "SELECT * FROM account WHERE username = '"+ lastName +"'";
        List<FRAccountModel> accounts = new ArrayList<>();
        Account account=new Account();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()){
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
                accounts.add(account);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return accounts;
    }

    @Override
    public List<FRAccountModel> getAllAccount() {
        String query = "SELECT * FROM account";
        List<FRAccountModel> accounts = new ArrayList<>();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()){
                Account account=new Account();
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
                accounts.add(account);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return accounts;
    }
}
