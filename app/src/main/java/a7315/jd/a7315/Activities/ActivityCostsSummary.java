package a7315.jd.a7315.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import a7315.jd.a7315.Contracts.ContractCostsSummary;
import a7315.jd.a7315.Items.ItemCost;
import a7315.jd.a7315.Presenters.PresenterCostSummary;
import a7315.jd.a7315.R;

public class ActivityCostsSummary extends AppCompatActivity implements AddAidDialogFragment.AddDialogListener, ContractCostsSummary.View {

    Button btnAdd;
    ListView lvCost;

    BaseAdapter adapter;
    ContractCostsSummary.Presenter presenter;

    @Override
    public void setItems(List<ItemCost> items) {
        adapter = new DateAdapter(this, items);
        adapter.notifyDataSetChanged();
        lvCost.setAdapter(adapter);
    }

    @Override
    public void updateList() {
        adapter.notifyDataSetChanged();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costs);

        btnAdd = findViewById(R.id.btnAdd);
        lvCost = findViewById(R.id.lvCost);

        presenter = new PresenterCostSummary(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDialogFragment frag = new AddAidDialogFragment();
                frag.show(getSupportFragmentManager(), "add_aid");
            }
        });
    }

    @Override
    public void onAdd(AddDialog frag) {
        Map<String, String> map = frag.getInfo();
        String name = map.get("name");
        String amount = map.get("amount");
        presenter.addedItem(new ItemCost(name, Float.parseFloat(amount)));
        adapter.notifyDataSetChanged();
    }

    public class DateAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<ItemCost> mItems;

        public DateAdapter(Context context, List<ItemCost> items) {
            mContext = context;
            mItems = items;

            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public ItemCost getItem(int position) {
            return mItems.get(position);
        }

        //3
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get view for row item
            // TODO: Fix this inflater issue
            View view = mInflater.inflate(R.layout.list_item_deadline, parent, false);

            ItemCost item = getItem(position);

            TextView txtDate = view.findViewById(R.id.txtDate);
            TextView txtDeadline = view.findViewById(R.id.txtDeadline);

            String szAmount = item.getAmount() + "";
            String szName = item.getTitle();

            txtDate.setText(szAmount);
            txtDeadline.setText(szName);

            return view;
        }
    }
}
