package main.business.account.listener;

/**
 * Created by Dora on 4/25/2017.
 */
public interface DeleteListener<T> {
    public void onDeleteSuccess(T object);
    public void onDeleteFail(String errMessage);
}
