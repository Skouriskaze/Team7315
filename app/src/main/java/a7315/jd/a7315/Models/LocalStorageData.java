package a7315.jd.a7315.Models;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import a7315.jd.a7315.Activities.InternalStorage;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemCost;
import a7315.jd.a7315.Items.ItemDate;

/**
 * Created by Jon on 2/18/2018.
 */

public class LocalStorageData implements ModelData {

    // LSD == LocalStorageData

    private Context context;

    private List<ItemAid> aAidItems;
    private List<ItemCost> aCostItems;
    private List<ItemDate> aDateItems;

    private String AIDFILE = "aid.data";
    private String COSTFILE = "cost.data";
    private String DATEFILE = "date.data";

    public LocalStorageData(Context context, String username) {
        Log.d("THIS IS ME", username);
        this.context = context;
        aAidItems = new ArrayList<>();
        aCostItems = new ArrayList<>();
        aDateItems = new ArrayList<>();
        setTags(username);

        try {
            Object a = InternalStorage.readObject(context, AIDFILE);
            aAidItems = (List<ItemAid>) a;
            Object c = InternalStorage.readObject(context, COSTFILE);
            aCostItems = (List<ItemCost>) c;
            Object d = InternalStorage.readObject(context, DATEFILE);
            aDateItems = (List<ItemDate>) d;

            Log.d("THIS IS ME", DATEFILE);
            Log.d("THIS IS ME", aDateItems.toString());
            if (aDateItems.size() == 0) {
                DatePopulator dp = new DatePopulator();
                for (ItemDate item : dp.populateDates()) {
                    addDateItem(item);
                }
            }

        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            initializeLists();
            if (aDateItems.size() == 0) {
                DatePopulator dp = new DatePopulator();
                for (ItemDate item : dp.populateDates()) {
                    addDateItem(item);
                }
            }
            e.printStackTrace();
        }
    }

    private void initializeLists() {
        aAidItems = new ArrayList<>();
        aCostItems = new ArrayList<>();
        aDateItems = new ArrayList<>();
        try {
            InternalStorage.writeObject(context, AIDFILE, aAidItems);
            InternalStorage.writeObject(context, COSTFILE, aCostItems);
            InternalStorage.writeObject(context, DATEFILE, aDateItems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the
     */
    private void setTags(String username) {
        username = username.toLowerCase();
        AIDFILE = username + "-" + AIDFILE;
        COSTFILE = username + "-" + COSTFILE;
        DATEFILE = username + "-" + DATEFILE;
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
    public List<ItemDate> getDateItems() { return aDateItems; }

    @Override
    public void addAidItem(ItemAid item) {
        aAidItems.add(item);
        try {
            Log.d("THIS IS ME", "writing aid");
            InternalStorage.writeObject(context, AIDFILE, aAidItems);
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
            InternalStorage.writeObject(context, AIDFILE, aAidItems);
        } catch (IOException e) {
            Log.e("LSD.editAid", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void removeAidItem(int index) {
        aAidItems.remove(index);
        try {
            Log.d("THIS IS ME", "removing aid");
            InternalStorage.writeObject(context, AIDFILE, aAidItems);
        } catch (IOException e) {
            Log.e("LSD.removeAid", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void addCostItem(ItemCost item) {
        aCostItems.add(item);
        try {
            InternalStorage.writeObject(context, COSTFILE, aCostItems);
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
            InternalStorage.writeObject(context, COSTFILE, aCostItems);
        } catch (IOException e) {
            Log.e("LSD.editCost", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void removeCostItem(int index) {
        aCostItems.remove(index);
        try {
            InternalStorage.writeObject(context, COSTFILE, aCostItems);
        } catch (IOException e) {
            Log.e("LSD.removeCost", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void addDateItem(ItemDate item) {
        aDateItems.add(item);
        Collections.sort(aDateItems);
        try {
            InternalStorage.writeObject(context, DATEFILE, aDateItems);
        } catch (IOException e) {
            Log.e("LSD.addDate", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void editDateItem(int index, String title, Date date) {
        aDateItems.get(index).setTitle(title);
        aDateItems.get(index).setDate(date);
        Collections.sort(aDateItems);
        try {
            InternalStorage.writeObject(context, DATEFILE, aDateItems);
        } catch (IOException e) {
            Log.e("LSD.editDate", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void removeDateItem(int index) {
        aDateItems.remove(index);
//        Collections.sort(aDateItems);
        try {
            InternalStorage.writeObject(context, DATEFILE, aDateItems);
        } catch (IOException e) {
            Log.e("LSD.removeDate", e.getMessage());
            e.printStackTrace();
        }
    }
}

