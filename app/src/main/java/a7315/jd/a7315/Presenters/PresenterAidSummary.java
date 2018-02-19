package a7315.jd.a7315.Presenters;

import android.content.Context;

import a7315.jd.a7315.Contracts.ContractAidSummary;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Models.LocalStorageData;
import a7315.jd.a7315.Models.ModelData;

/**
 * Created by Jesse on 1/22/2018.
 */

public class PresenterAidSummary implements ContractAidSummary.Presenter {

    ContractAidSummary.View view;
    private ModelData data;

    public PresenterAidSummary(ContractAidSummary.View view, Context context) {
        this.view = view;
        data = new LocalStorageData(context);
        view.setItems(data.getAidItems());
    }

    @Override
    public void addedItem(ItemAid item) {
        data.addAidItem(item);
        view.updateList();
    }

    @Override
    public void editedItem(int itemIndex, String newName, Float newValue) {
        data.editAidItem(itemIndex, newName, newValue);
        view.updateList();
    }

    @Override
    public void removedItem(int itemIndex) {
        data.removeAidItem(itemIndex);
        view.updateList();
    }
}
