package a7315.jd.a7315.Activities;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import a7315.jd.a7315.Contracts.ContractCalculate;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemCost;
import a7315.jd.a7315.Items.ItemFinancials;
import a7315.jd.a7315.Presenters.PresenterCalculate;
import a7315.jd.a7315.R;

public class ActivityCalculate extends AppCompatActivity implements ContractCalculate.View {

    Button btnCalculate;
    ListView lvAid;
    ListView lvCost;
    TextView txtResult;

    ContractCalculate.Presenter presenter;

    CheckBoxAdapter adapterAid;
    CheckBoxAdapter adapterCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);


        btnCalculate = findViewById(R.id.btnCalculate);
        lvCost = findViewById(R.id.lvCost);
        lvAid = findViewById(R.id.lvAid);
        txtResult = findViewById(R.id.txtResult);

        presenter = new PresenterCalculate(this, this);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float net = presenter.calculate();
                displayNet(net);
            }
        });
    }

    @Override
    public void setAidItems(List<ItemAid> items) {
        adapterAid = new CheckBoxAdapter(this, items);
        adapterAid.notifyDataSetChanged();
        lvAid.setAdapter(adapterAid);
    }

    @Override
    public void updateAidList() {
        adapterAid.notifyDataSetChanged();
    }

    @Override
    public void setCostItems(List<ItemCost> items) {
        adapterCost = new CheckBoxAdapter(this, items);
        adapterCost.notifyDataSetChanged();
        lvCost.setAdapter(adapterCost);
    }

    @Override
    public void updateCostList() {
        adapterCost.notifyDataSetChanged();
    }

    @Override
    public void displayNet(float net) {
        txtResult.setText(getResources().getString(R.string.costTemplate, net));
    }

    public class CheckBoxAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<? extends ItemFinancials> mItems;

        public CheckBoxAdapter(Context context, List<? extends ItemFinancials> items) {
            mContext = context;
            mItems = items;

            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public ItemFinancials getItem(int position) {
            return mItems.get(position);
        }

        //3
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            // Get view for row item
            if (view == null) {
                view = mInflater.inflate(R.layout.list_item_check, parent, false);
            }

            ItemFinancials item = getItem(position);

            CheckBox cbItem = view.findViewById(R.id.cbItem);
            TextView txtAmount = view.findViewById(R.id.txtAmount);

            cbItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CheckBox cb = (CheckBox) view;
                    mItems.get(position).setActive(cb.isChecked());
                    Toast.makeText(ActivityCalculate.this, position + " checked " + cb.isChecked(), Toast.LENGTH_SHORT).show();
                }
            });

            cbItem.setChecked(mItems.get(position).isActive());

            float szAmount = item.getAmount();
            String szName = item.getTitle();
            cbItem.setText(szName);
            txtAmount.setText(szAmount + "");

            return view;
        }
    }
}
