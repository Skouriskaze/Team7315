package a7315.jd.a7315.Contracts;

import java.util.Date;
import java.util.List;

import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemDate;
import a7315.jd.a7315.Items.ItemFinancials;

/**
 * Created by Jesse on 1/23/2018.
 */

public interface ContractHome {
    interface View {
        void setSummaryItems(List<ItemFinancials> items);
        void updateSummaryList();

        void setDeadlines(List<ItemDate>  items);
        void updateDeadlineList();

        String getUsername();
    }

    interface Presenter {
        void addedDate(ItemDate item);

        void editedDate(int itemIndex, String newName, Date newDate);

        void removedItem(int itemIndex);
    }
}
