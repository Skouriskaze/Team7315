package a7315.jd.a7315.Models;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import a7315.jd.a7315.Activities.InternalStorage;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemCost;

/**
 * Created by Jon on 2/18/2018.
 */

public class LocalStorageData implements ModelData {

    // LSD == LocalStorageData

    private Context context;

    private List<ItemAid> aAidItems;
    private List<ItemCost> aCostItems;

    public LocalStorageData(Context context) {
        this.context = context;
        aAidItems = new ArrayList<>();
        aCostItems = new ArrayList<>();

        try {
            Object a = InternalStorage.readObject(context, "aid.data");
            aAidItems = (List<ItemAid>) a;
            Object c = InternalStorage.readObject(context, "cost.data");
            aCostItems = (List<ItemCost>) c;

        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ItemAid> getAidItems() {
        return aAidItems;
    }

    @Override
    public List<ItemCost> getCostItems() {
        return aCostItems;
    }

    @Override
    public void addAidItem(ItemAid item) {
        aAidItems.add(item);
        try {
            InternalStorage.writeObject(context, "aid.data", aAidItems);
        } catch (IOException e) {
            Log.e("LSD.addAid", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void editAidItem(int index, String name, float amount) {
        aAidItems.get(index).setTitle(name);
        aAidItems.get(index).setAmount(amount);
        try {
            InternalStorage.writeObject(context, "aid.data", aAidItems);
        } catch (IOException e) {
            Log.e("LSD.editAid", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void removeAidItem(int index) {
        aAidItems.remove(index);
        try {
            InternalStorage.writeObject(context, "aid.data", aAidItems);
        } catch (IOException e) {
            Log.e("LSD.removeAid", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void addCostItem(ItemCost item) {
        aCostItems.add(item);
        try {
            InternalStorage.writeObject(context, "cost.data", aCostItems);
        } catch (IOException e) {
            Log.e("LSD.addCost", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void editCostItem(int index, String name, float amount) {
        aCostItems.get(index).setTitle(name);
        aCostItems.get(index).setAmount(amount);
        try {
            InternalStorage.writeObject(context, "cost.data", aCostItems);
        } catch (IOException e) {
            Log.e("LSD.editCost", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void removeCostItem(int index) {
        aCostItems.remove(index);
        try {
            InternalStorage.writeObject(context, "cost.data", aCostItems);
        } catch (IOException e) {
            Log.e("LSD.removeCost", e.getMessage());
            e.printStackTrace();
        }
    }
}

