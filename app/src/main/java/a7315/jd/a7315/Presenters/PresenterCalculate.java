package a7315.jd.a7315.Presenters;

import android.content.Context;

import java.util.List;

import a7315.jd.a7315.Contracts.ContractCalculate;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemCost;
import a7315.jd.a7315.Models.LocalStorageData;
import a7315.jd.a7315.Models.ModelData;

/**
 * Created by Jesse on 1/23/2018.
 */

public class PresenterCalculate implements ContractCalculate.Presenter {
    private ContractCalculate.View view;
    private ModelData data;

    public PresenterCalculate(ContractCalculate.View view, Context context) {
        this.view = view;
        data = new LocalStorageData(context);

        view.setAidItems(data.getAidItems());
        view.setCostItems(data.getCostItems());
    }

    @Override
    public float calculate() {
        float net = 0;
        for (ItemCost i : data.getCostItems()) {
            if (i.isActive())
                net += i.getAmount();
        }
        for (ItemAid i : data.getAidItems()) {
            if (i.isActive())
                net -= i.getAmount();
        }
        return net;
    }
}
