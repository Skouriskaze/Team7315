package a7315.jd.a7315.Presenters;

import a7315.jd.a7315.Contracts.ContractCalculate;

/**
 * Created by Jesse on 1/23/2018.
 */

public class PresenterCalculate implements ContractCalculate.Presenter {
    ContractCalculate.View view;

    public PresenterCalculate(ContractCalculate.View view) {
        this.view = view;
    }
}
