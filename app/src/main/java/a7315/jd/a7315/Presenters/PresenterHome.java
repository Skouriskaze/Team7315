package a7315.jd.a7315.Presenters;

import a7315.jd.a7315.Contracts.ContractHome;

/**
 * Created by Jesse on 1/23/2018.
 */

public class PresenterHome implements ContractHome.Presenter {
    ContractHome.View view;
    public PresenterHome(ContractHome.View view ) {
        this.view = view;
    }
}
