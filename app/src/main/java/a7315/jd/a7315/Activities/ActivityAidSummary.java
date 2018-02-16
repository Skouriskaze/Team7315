package a7315.jd.a7315.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import a7315.jd.a7315.Contracts.ContractAidSummary;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.Presenters.PresenterAidSummary;
import a7315.jd.a7315.R;

public class ActivityAidSummary extends AppCompatActivity implements ContractAidSummary.View{

    Button btnAdd;
    ListView lvAid;
    ContractAidSummary.Presenter presenter;

    BaseAdapter adapter;
    final Context context = this;

    @Override
    public void setItems(List<ItemAid> items) {
        adapter = new DateAdapter(this, items);
        adapter.notifyDataSetChanged();
        lvAid.setAdapter(adapter);
    }

    @Override
    public void updateList() {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aid);


        btnAdd = findViewById(R.id.btnAdd);
        lvAid = findViewById(R.id.lvAid);
        presenter = new PresenterAidSummary(this, this);

        lvAid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int index = i;
                ItemAid item = (ItemAid) adapterView.getItemAtPosition(index);

                LayoutInflater inflater = LayoutInflater.from(context);
                View v = inflater.inflate(R.layout.dialog_aid, null);

                final EditText etName = v.findViewById(R.id.etName);
                final EditText etAmount = v.findViewById(R.id.etAmount);

                etName.setText(item.getTitle());
                etAmount.setText(String.valueOf(item.getAmount()));

                AlertDialog.Builder alert = new AlertDialog.Builder(context)
                        .setView(v)
                        .setTitle("Edit Aid")
                        .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                presenter.editedItem(index, etName.getText().toString(),
                                        Float.parseFloat(etAmount.getText().toString()));
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

        // Add button functionality
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = LayoutInflater.from(context);
                View v = inflater.inflate(R.layout.dialog_aid, null);

                final EditText etName = v.findViewById(R.id.etName);
                final EditText etAmount = v.findViewById(R.id.etAmount);

                AlertDialog.Builder alert = new AlertDialog.Builder(context)
                        .setView(v)
                        .setTitle("Add Aid")
                        .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ItemAid item = new ItemAid(etName.getText().toString(),
                                        Float.parseFloat(etAmount.getText().toString()));
                                presenter.addedItem(item);
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
    }

    public class DateAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<ItemAid> mItems;

        public DateAdapter(Context context, List<ItemAid> items) {
            mContext = context;
            mItems = items;

            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public ItemAid getItem(int position) {
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

            ItemAid item = getItem(position);

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

