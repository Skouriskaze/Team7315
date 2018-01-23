package a7315.jd.a7315.Presenters;

import a7315.jd.a7315.Contracts.ContractLogin;

/**
 * Created by Jesse on 1/23/2018.
 */

public class PresenterLogin implements ContractLogin.Presenter {
    ContractLogin.View view;
    public PresenterLogin(ContractLogin.View view) {
        this.view = view;
    }

    public boolean login(String username, String password) {
        return true;
    }
}
