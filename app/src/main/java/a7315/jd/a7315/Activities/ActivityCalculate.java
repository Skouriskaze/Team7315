package a7315.jd.a7315.Activities;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import a7315.jd.a7315.Contracts.ContractCalculate;
import a7315.jd.a7315.Presenters.PresenterCalculate;
import a7315.jd.a7315.R;

public class ActivityCalculate extends AppCompatActivity implements ContractCalculate.View {

    Button btnCalculate;
    ListView lvAid;
    ListView lvCost;
    TextView txtResult;

    ContractCalculate.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        presenter = new PresenterCalculate(this);

        btnCalculate = findViewById(R.id.btnCalculate);
        lvCost = findViewById(R.id.lvCost);
        lvAid = findViewById(R.id.lvAid);
        txtResult = findViewById(R.id.txtResult);

        List<String> aAidItems = new ArrayList<>();
        List<String> aCostItems = new ArrayList<>();

        aAidItems.add("$5,000|HOPE");
        aAidItems.add("$2,000|Misc");
        aAidItems.add("$2,000|More Misc");

        aCostItems.add("$5,000|Tuition");
        aCostItems.add("$2,000|Housing");
        aCostItems.add("$2,000|Misc");

        BaseAdapter adapterAid = new CheckBoxAdapter(this, aAidItems);
        BaseAdapter adapterCost = new CheckBoxAdapter(this, aCostItems);

        lvCost.setAdapter(adapterCost);
        lvAid.setAdapter(adapterAid);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setText(getResources().getString(R.string.costTemplate, 1000));
            }
        });
    }

    public class CheckBoxAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<String> mItems;

        public CheckBoxAdapter(Context context, List<String> items) {
            mContext = context;
            mItems = items;

            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public String getItem(int position) {
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
            View view = mInflater.inflate(R.layout.list_item_check, parent, false);

            String item = getItem(position);

            CheckBox cbItem = view.findViewById(R.id.cbItem);
            TextView txtAmount = view.findViewById(R.id.txtAmount);

            String szAmount = item.split("[|]")[0];
            String szName = item.split("[|]")[1];
            cbItem.setText(szName);
            txtAmount.setText(szAmount);

            return view;
        }
    }
}
