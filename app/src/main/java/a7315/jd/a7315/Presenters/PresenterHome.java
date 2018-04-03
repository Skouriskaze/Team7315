package a7315.jd.a7315.Presenters;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import a7315.jd.a7315.Contracts.ContractHome;
import a7315.jd.a7315.Items.ItemDate;
import a7315.jd.a7315.Items.ItemFinancials;
import a7315.jd.a7315.Models.LocalStorageData;
import a7315.jd.a7315.Models.ModelData;

/**
 * Created by Jesse on 1/23/2018.
 */

public class PresenterHome implements ContractHome.Presenter {
    private ContractHome.View view;
    private ModelData data;
    public PresenterHome(ContractHome.View view, Context context ) {
        this.view = view;
        data = new LocalStorageData(context, view.getUsername());
        Log.d("this is me", view.getUsername());
        Log.d("THIS IS ME", data.getDateItems().size()+ "");
        view.setDeadlines(data.getDateItems());

        List<ItemFinancials> items = new ArrayList<>();
        items.addAll(data.getAidItems());
        items.addAll(data.getCostItems());
        view.setSummaryItems(items);
    }

    @Override
    public void addedDate(ItemDate item) {
        data.addDateItem(item);
        view.updateDeadlineList();
    }

    @Override
    public void editedDate(int itemIndex, String newName, Date newDate) {
        data.editDateItem(itemIndex, newName, newDate);
        view.updateDeadlineList();
    }

    @Override
    public void removedItem(int itemIndex) {
        data.removeDateItem(itemIndex);
        view.updateDeadlineList();
    }
}
