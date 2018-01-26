package a7315.jd.a7315.Contracts;

import java.util.List;

import a7315.jd.a7315.Items.ItemAid;

/**
 * Created by Jesse on 1/23/2018.
 */

public interface ContractHome {
    interface View {
        void setAidItems(List<ItemAid> items);
        void updateAidList();
    }

    interface Presenter {

    }
}
