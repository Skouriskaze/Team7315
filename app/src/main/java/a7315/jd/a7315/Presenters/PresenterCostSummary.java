package a7315.jd.a7315.Presenters;

import android.content.Context;

import a7315.jd.a7315.Contracts.ContractCostsSummary;
import a7315.jd.a7315.Items.ItemCost;
import a7315.jd.a7315.Models.LocalStorageData;
import a7315.jd.a7315.Models.ModelData;

/**
 * Created by Jesse on 1/22/2018.
 */

public class PresenterCostSummary implements ContractCostsSummary.Presenter {

    private ContractCostsSummary.View view;
    private ModelData data;

    public PresenterCostSummary(ContractCostsSummary.View view, Context context) {
        this.view = view;
        data = new LocalStorageData(context, view.getUsername());
        view.setItems(data.getCostItems());
    }

    @Override
    public void addedItem(ItemCost item) {
        data.addCostItem(item);
        view.updateList();
    }

    @Override
    public void editedItem(int itemIndex, String newName, Float newValue) {
        data.editCostItem(itemIndex, newName, newValue);
        view.updateList();
    }

    @Override
    public void removedItem(int itemIndex) {
        data.removeCostItem(itemIndex);
        view.updateList();
    }
}
