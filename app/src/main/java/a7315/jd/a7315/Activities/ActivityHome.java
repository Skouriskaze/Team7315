package a7315.jd.a7315.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import a7315.jd.a7315.Contracts.ContractHome;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemCalendar;
import a7315.jd.a7315.Presenters.PresenterHome;
import a7315.jd.a7315.R;

public class ActivityHome extends AppCompatActivity implements ContractHome.View {

    Button btnAid;
    Button btnCost;
    Button btnCalculate;

    ContractHome.Presenter presenter;
    BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        presenter = new PresenterHome(this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<String> aDeadlines = new ArrayList<>();
        List<String> aSummary = new ArrayList<>();
        for (int i = 10; i < 20; i++) {
            aDeadlines.add("1/" + i + "|Something Due");
            aSummary.add("1/" + i + "|$" + i * 5);
        }

        CalendarAdapter oDeadlineAdapter = new CalendarAdapter(this, aDeadlines);
        CalendarAdapter oSummaryAdapter = new CalendarAdapter(this, aSummary);
        ListView lvDeadline = findViewById(R.id.lvDeadlines);
        ListView lvSummary = findViewById(R.id.lvSummary);
        lvDeadline.setAdapter(oDeadlineAdapter);
        lvSummary.setAdapter(oSummaryAdapter);

        btnAid = findViewById(R.id.btnAddAid);
        btnCost = findViewById(R.id.btnAddCost);
        btnCalculate = findViewById(R.id.btnCalculate);

        final Context context = this;

        btnAid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityAidSummary.class);
                startActivity(intent);
            }
        });
        btnCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityCostsSummary.class);
                startActivity(intent);
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityCalculate.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_calculate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setAidItems(List<ItemAid> items) {

    }

    @Override
    public void updateAidList() {

    }

    @Override
    public void setCalendarItems(List<ItemCalendar> cItems){
        adapter = new CalendarAdapter(this, cItems);
    }

    public class CalendarAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<ItemCalendar> mItems;

        public CalendarAdapter(Context context, List<ItemCalendar> items) {
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

            String szDate = item.split("[|]")[0];
            String szDeadline = item.split("[|]")[1];

            txtDate.setText(szDate);
            txtDeadline.setText(szDeadline);

            return view;
        }
    }
}
