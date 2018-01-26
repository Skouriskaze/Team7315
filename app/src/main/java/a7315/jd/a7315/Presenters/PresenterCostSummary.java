package a7315.jd.a7315.Presenters;

import java.util.ArrayList;
import java.util.List;

import a7315.jd.a7315.Contracts.ContractAidSummary;
import a7315.jd.a7315.Contracts.ContractCostsSummary;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemCost;

/**
 * Created by Jesse on 1/22/2018.
 */

public class PresenterCostSummary implements ContractCostsSummary.Presenter {

    ContractCostsSummary.View view;
    List<ItemCost> aItems;

    public PresenterCostSummary(ContractCostsSummary.View view) {
        this.view = view;
        aItems = new ArrayList<>();
        aItems.add(new ItemCost("Tuition", 5000));
        aItems.add(new ItemCost("Housing", 2000));
        aItems.add(new ItemCost("Misc", 2000));
        view.setItems(aItems);
    }

    @Override
    public void addedItem(ItemCost item) {
        aItems.add(item);

        view.updateList();
    }
}
