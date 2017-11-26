package a7315.jd.a7315;

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

public class ActivityCosts extends AppCompatActivity implements AddAidDialogFragment.AddDialogListener {

    Button btnAdd;
    ListView lvCost;

    List<String> aCost;
    BaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costs);


        btnAdd = findViewById(R.id.btnAdd);
        lvCost = findViewById(R.id.lvCost);


        aCost = new ArrayList<>();
        aCost.add("$5,000|Tuition");
        aCost.add("$2,000|Housing");
        aCost.add("$2,000|Misc");
        adapter = new DateAdapter(this, aCost);
        lvCost.setAdapter(adapter);


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
        aCost.add("$" + amount + "|" + name);
        adapter.notifyDataSetChanged();
    }

    public class DateAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<String> mItems;

        public DateAdapter(Context context, List<String> items) {
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
            View view = mInflater.inflate(R.layout.list_item_deadline, parent, false);

            String item = getItem(position);

            TextView txtDate = view.findViewById(R.id.txtDate);
            TextView txtDeadline = view.findViewById(R.id.txtDeadline);

            String szAmount = item.split("[|]")[0];
            String szName = item.split("[|]")[1];

            txtDate.setText(szAmount);
            txtDeadline.setText(szName);

            return view;
        }
    }
}
