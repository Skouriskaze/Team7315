package a7315.jd.a7315.Presenters;

import a7315.jd.a7315.Contracts.ContractRegister;

/**
 * Created by Jesse on 1/23/2018.
 */

public class PresenterRegister implements ContractRegister.Presenter {
    ContractRegister.View view;

    public PresenterRegister(ContractRegister.View view) {
        this.view = view;
    }
    public boolean register(String username, String password ) {
        return true;
    }
}
