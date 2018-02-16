package a7315.jd.a7315.Models;

import java.util.ArrayList;
import java.util.List;

import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemCost;

/**
 * Created by Jesse on 2/15/2018.
 */

public class DummyData implements ModelData {

    private static List<ItemAid> aidItems = new ArrayList<>();
    private static List<ItemCost> costItems = new ArrayList<>();

    @Override
    public List<ItemAid> getAidItems() {
        return DummyData.getStaticAidList();
    }

    private static List<ItemAid> getStaticAidList() {
        if (aidItems.size() == 0) {
            aidItems.add(new ItemAid("HOPE", 5000));
            aidItems.add(new ItemAid("Misc", 2000));
            aidItems.add(new ItemAid("More Misc", 2000));
        }
        return aidItems;
    }

    @Override
    public void addAidItem(ItemAid item) {
        DummyData.addStaticAidItem(item);
    }

    @Override
    public void editAidItem(int index, String name, float amount) {
        aidItems.get(index).setTitle(name);
        aidItems.get(index).setAmount(amount);
    }

    @Override
    public void removeAidItem(int index) {
        aidItems.remove(index);
    }

    @Override
    public List<ItemCost> getCostItems() {
        return DummyData.getStaticCostList();
    }

    @Override
    public void addCostItem(ItemCost item) {
        addStaticCostItem(item);
    }

    @Override
    public void editCostItem(int index, String name, float amount) {
        costItems.get(index).setTitle(name);
        costItems.get(index).setAmount(amount);
    }

    @Override
    public void removeCostItem(int index) {
        costItems.remove(index);
    }


    private static List<ItemCost> getStaticCostList() {
        if (costItems.size() == 0) {
            costItems.add(new ItemCost("Tuition", 5000));
            costItems.add(new ItemCost("Housing", 2000));
            costItems.add(new ItemCost("Misc", 2000));
        }
        return costItems;
    }
    private static void addStaticAidItem(ItemAid item) {
        aidItems.add(item);
    }
    private static void addStaticCostItem(ItemCost item){
        costItems.add(item);
    }
}
