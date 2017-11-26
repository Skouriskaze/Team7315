package a7315.jd.a7315;

import android.app.DialogFragment;
import android.content.Context;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ActivityAid extends AppCompatActivity implements AddAidDialogFragment.AddDialogListener{

    Button btnAdd;
    ListView lvAid;

    List<String> aAid;
    BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aid);


        btnAdd = findViewById(R.id.btnAdd);
        lvAid = findViewById(R.id.lvAid);


        aAid = new ArrayList<>();
        aAid.add("$5,000|HOPE");
        aAid.add("$2,000|Misc");
        aAid.add("$2,000|More Misc");
        adapter = new DateAdapter(this, aAid);
        lvAid.setAdapter(adapter);


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
        aAid.add("$" + amount + "|" + name);
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

