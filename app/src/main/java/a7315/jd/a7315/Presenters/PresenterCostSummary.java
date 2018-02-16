package a7315.jd.a7315.Presenters;

import java.util.ArrayList;
import java.util.List;

import a7315.jd.a7315.Contracts.ContractAidSummary;
import a7315.jd.a7315.Contracts.ContractCostsSummary;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemCost;
import a7315.jd.a7315.Models.DummyData;
import a7315.jd.a7315.Models.ModelData;

/**
 * Created by Jesse on 1/22/2018.
 */

public class PresenterCostSummary implements ContractCostsSummary.Presenter {

    private ContractCostsSummary.View view;
    private ModelData data;

    public PresenterCostSummary(ContractCostsSummary.View view) {
        this.view = view;
        data = new DummyData();
        view.setItems(data.getCostItems());
    }

    @Override
    public void addedItem(ItemCost item) {
        data.addCostItem(item);
        view.updateList();
    }
}
