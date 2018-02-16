package a7315.jd.a7315.Presenters;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import a7315.jd.a7315.Contracts.ContractAidSummary;
import a7315.jd.a7315.Contracts.ContractCostsSummary;
import a7315.jd.a7315.Items.ItemCost;
import a7315.jd.a7315.Models.DummyData;
import a7315.jd.a7315.Models.ModelData;

/**
 * Created by Jesse on 1/22/2018.
 */

public class PresenterCostSummary implements ContractCostsSummary.Presenter {

    private ContractCostsSummary.View view;
    private ModelData data;

    public PresenterCostSummary(ContractCostsSummary.View view, Context context) {
        this.view = view;
        data = new DummyData(context);
        view.setItems(data.getCostItems());
    }

    @Override
    public void addedItem(ItemCost item) {
        data.addCostItem(item);

        view.updateList();
    }

    @Override
    public void editedItem(int itemIndex, String newName, Float newValue) {
        ItemCost item = data.getCostItems().get(itemIndex);
        item.setTitle(newName);
        item.setAmount(newValue);

        view.updateList();
    }

    @Override
    public void removedItem(int itemIndex) {
        data.removeCostItem(itemIndex);

        view.updateList();
    }
}
