package a7315.jd.a7315.Contracts;

import java.util.List;

import a7315.jd.a7315.Items.ItemAid;

/**
 * Created by Jesse on 1/22/2018.
 */

public interface ContractAidSummary {
    interface View {

        /**
         * Sets a list of items to be displayed in the ListView
         * @param items Items to be displayed
         */
        void setItems(List<ItemAid> items);

        /**
         * Notify that the list has been updated. Should be called every time the presenter adds an
         * item.
         */
        void updateList();

        void onAdd(AidDialog dialog);

        void onEdit(AidDialog dialog);

        void onRemove(AidDialog dialog);
    }

    interface Presenter {
        /**
         * Tells the presenter to add an item to the item list.
         * @param item
         */
        void addedItem(ItemAid item);

        /**
         * Tells the presenter to edit an item in the item list.
         * @param itemIndex The index of the item to edit
         * @param newName The updated item name
         * @param newValue The updated item value
         */
        void editedItem(int itemIndex, String newName, Float newValue);

        /**
         * Tells the presenter to
         * @param itemIndex The index of the item to remove
         */
        void removedItem(int itemIndex);
    }
}
