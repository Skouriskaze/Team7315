package a7315.jd.a7315.Presenters;

import a7315.jd.a7315.Contracts.ContractLogin;
import a7315.jd.a7315.Models.ModelLogin;

/**
 * Created by Jesse on 1/23/2018.
 */

public class PresenterLogin implements ContractLogin.Presenter {
    ContractLogin.View view;
    public PresenterLogin(ContractLogin.View view) {
        this.view = view;
    }

    public boolean login(String username, String password) {
        ModelLogin model = new ModelLogin();
        boolean result = model.checkCredentials(username, password);
        if (result) {
            view.onSuccessfulLogin();
        } else {
            view.onFailedLogin();
        }

        return result;
    }
}
