package a7315.jd.a7315.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import a7315.jd.a7315.Contracts.ContractHome;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Items.ItemDate;
import a7315.jd.a7315.Items.ItemFinancials;
import a7315.jd.a7315.Presenters.PresenterHome;
import a7315.jd.a7315.R;

public class ActivityHome extends AppCompatActivity implements ContractHome.View {

    Button btnAid;
    Button btnCost;
    Button btnCalculate;
    Button btnDate;

    ListView lvDeadline;
    ListView lvSummary;

    ContractHome.Presenter presenter;

    DateAdapter dateAdapter;
    FinancialAdapter financialAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lvDeadline = findViewById(R.id.lvDeadlines);
        lvSummary = findViewById(R.id.lvSummary);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnAid = findViewById(R.id.btnAddAid);
        btnCost = findViewById(R.id.btnAddCost);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnDate = findViewById(R.id.btnAddDate);


        presenter = new PresenterHome(this, this);

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

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = LayoutInflater.from(context);
                View v = inflater.inflate(R.layout.dialog_date, null);

                final EditText etName = v.findViewById(R.id.etName);
                final CalendarView cDate = v.findViewById(R.id.cvDate);
                final GregorianCalendar gc = new GregorianCalendar();

                cDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                        gc.set(year, month, day);
                    }
                });

                AlertDialog.Builder alert = new AlertDialog.Builder(context)
                        .setView(v)
                        .setTitle("Add Deadline")
                        .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String szName = etName.getText().toString();
                                Date ldDate = gc.getTime();
                                ItemDate item = new ItemDate(szName, ldDate);
                                presenter.addedDate(item);
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                alert.create();
                alert.show();
            }
        });

        lvDeadline.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int index = i;
                ItemDate item = (ItemDate) adapterView.getItemAtPosition(index);

                LayoutInflater inflater = LayoutInflater.from(context);
                View v = inflater.inflate(R.layout.dialog_date,null);

                final EditText etName = v.findViewById(R.id.etName);
                final CalendarView cvDate = v.findViewById(R.id.cvDate);
                final GregorianCalendar gc = new GregorianCalendar();

                cvDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                        gc.set(year, month, day);
                    }
                });

                etName.setText(item.getTitle());
                cvDate.setDate(item.getDate().getTime(), true, false);

                AlertDialog.Builder alert = new AlertDialog.Builder(context)
                        .setView(v)
                        .setTitle("Edit Deadline")
                        .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                presenter.editedDate(index, etName.getText().toString(), gc.getTime());
                            }
                        })
                        .setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton(R.string.remove, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                presenter.removedItem(index);
                            }
                        });

                alert.create();
                alert.show();
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
    public void setSummaryItems(List<ItemFinancials> items) {
        financialAdapter = new FinancialAdapter(this, items);
        financialAdapter.notifyDataSetChanged();
        lvSummary.setAdapter(financialAdapter);
    }

    @Override
    public void updateSummaryList() {
        financialAdapter.notifyDataSetChanged();
    }

    @Override
    public void setDeadlines(List<ItemDate> items) {
        dateAdapter = new DateAdapter(this, items);
        dateAdapter.notifyDataSetChanged();
        lvDeadline.setAdapter(dateAdapter);
    }

    @Override
    public void updateDeadlineList() {
        dateAdapter.notifyDataSetChanged();
    }

    public class DateAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<ItemDate> mItems;

        public DateAdapter(Context context, List<ItemDate> items) {
            mContext = context;
            mItems = items;

            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public ItemDate getItem(int position) {
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
            View view = convertView;
            if (view == null)
                view = mInflater.inflate(R.layout.list_item_deadline, parent, false);

            ItemDate item = getItem(position);

            TextView txtDate = view.findViewById(R.id.txtDate);
            TextView txtDeadline = view.findViewById(R.id.txtDeadline);

            String szDate = item.getTitle();
            String szDeadline = SimpleDateFormat.getDateInstance().format(item.getDate());

            txtDate.setText(szDate);
            txtDeadline.setText(szDeadline);

            return view;
        }
    }


    @Override
    public String getUsername() {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return settings.getString("username", "");
    }

    public class FinancialAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<? extends ItemFinancials> mItems;

        public FinancialAdapter(Context context, List<ItemFinancials> items) {
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
        public View getView(int position, View view, ViewGroup parent) {
            // Get view for row item
            if (view == null) {
                view = mInflater.inflate(R.layout.list_item_deadline, parent, false);
            }

            ItemFinancials item = getItem(position);

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
