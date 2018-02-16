package a7315.jd.a7315.Models;

import java.util.List;

import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemCost;

/**
 * Created by Jesse on 2/15/2018.
 */

public interface ModelData {

    /**
     * Get a list of aid items.
     * @return A list of aid items
     */
    List<ItemAid> getAidItems();

    /**
     * Adds an aid item to the list of aid items
     * @param item the item to be added
     */
    void addAidItem(ItemAid item);

    /**
     * Edits an aid item
     * @param index The index of the item in the list
     * @param name The new name
     * @param amount The new amount
     */
    void editAidItem(int index, String name, float amount);


    /**
     * Removes and aid item
     * @param index Index of the item to be removed
     */
    void removeAidItem(int index);

    /**
     * Gets a list of cost items
     * @return A list of cost items
     */
    List<ItemCost> getCostItems();

    /**
     * Adds a cost item to the list of cost items
     * @param item The item to be added
     */
    void addCostItem(ItemCost item);

    /**
     * Edits a cost item
     * @param index The index of the item in the list
     * @param name The new name
     * @param amount The new amount
     */
    void editCostItem(int index, String name, float amount);

    /**
     * Removes and aid item
     * @param index Index of the item to be removed
     */
    void removeCostItem(int index);

}
