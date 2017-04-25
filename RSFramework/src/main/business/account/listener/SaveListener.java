package main.business.account.listener;

import main.model.FRAccountModel;

/**
 * Created by Dora on 4/25/2017.
 */
public interface SaveListener<T> {
    public void onSaveSuccess(T object);
    public void onSaveFail(String errMessage);
}
