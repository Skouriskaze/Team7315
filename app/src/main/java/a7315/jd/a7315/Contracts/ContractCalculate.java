package a7315.jd.a7315.Contracts;

import java.util.List;

import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemCost;
import a7315.jd.a7315.Items.ItemFinancials;

/**
 * Created by Jesse on 1/23/2018.
 */

public interface ContractCalculate {
    interface View {

        /**
         * Sets a list of items to be displayed in the Aid ListView
         * @param items Items to be displayed
         */
        void setAidItems(List<ItemAid> items);

        /**
         * Notify that the list has been updated. Should be called every time the presenter adds an
         * item.
         */
        void updateAidList();

        /**
         * Sets a list of items to be displayed in the Cost ListView
         * @param items Items to be displayed
         */
        void setCostItems(List<ItemCost> items);

        /**
         * Notify that the list has been updated. Should be called every time the presenter adds an
         * item.
         */
        void updateCostList();

        /**
         * Displays the calculated cost.
         */
        void displayNet(float net);
    }

    interface Presenter {

        /**
         * Given the aid and costs to calculate, calculate.
         * @return The net cost of the aids and costs.
         */
        float calculate();
    }
}
