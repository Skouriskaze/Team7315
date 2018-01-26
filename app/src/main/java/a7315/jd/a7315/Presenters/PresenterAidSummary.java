package a7315.jd.a7315.Presenters;

import java.util.ArrayList;
import java.util.List;

import a7315.jd.a7315.Contracts.ContractAidSummary;
import a7315.jd.a7315.Items.ItemAid;

/**
 * Created by Jesse on 1/22/2018.
 */

public class PresenterAidSummary implements ContractAidSummary.Presenter {

    ContractAidSummary.View view;
    List<ItemAid> aItems;

    public PresenterAidSummary(ContractAidSummary.View view) {
        this.view = view;
        aItems = new ArrayList<>();
        aItems.add(new ItemAid("HOPE", 5000));
        aItems.add(new ItemAid("Misc", 2000));
        aItems.add(new ItemAid("More Misc", 2000));
        view.setItems(aItems);
    }

    @Override
    public void addedItem(ItemAid item) {
        aItems.add(item);

        view.updateList();
    }
}
