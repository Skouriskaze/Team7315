package a7315.jd.a7315.Presenters;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import a7315.jd.a7315.Contracts.ContractAidSummary;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Models.DummyData;
import a7315.jd.a7315.Models.ModelData;

/**
 * Created by Jesse on 1/22/2018.
 */

public class PresenterAidSummary implements ContractAidSummary.Presenter {

    ContractAidSummary.View view;
    private ModelData data;

    public PresenterAidSummary(ContractAidSummary.View view, Context context) {
        this.view = view;
        data = new DummyData(context);
        view.setItems(data.getAidItems());
    }

    @Override
    public void addedItem(ItemAid item) {
        data.addAidItem(item);
        view.updateList();
    }

    @Override
    public void editedItem(int itemIndex, String newName, Float newValue) {
        ItemAid item = data.getAidItems().get(itemIndex);
        item.setTitle(newName);
        item.setAmount(newValue);

        view.updateList();
    }

    @Override
    public void removedItem(int itemIndex) {
        data.getAidItems().remove(itemIndex);
        view.updateList();
    }
}
