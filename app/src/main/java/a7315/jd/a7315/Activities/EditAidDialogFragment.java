package a7315.jd.a7315.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import a7315.jd.a7315.Contracts.AidDialog;
import a7315.jd.a7315.Contracts.ContractAidSummary;
import a7315.jd.a7315.Items.ItemAid;
import a7315.jd.a7315.R;

/**
 * Created by Nat on 2/14/2018.
 */

public class EditAidDialogFragment extends AppCompatDialogFragment implements AidDialog{
    EditText etName;
    EditText etAmount;
    int nIndex;

    ContractAidSummary.View mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final AidDialog context = this;

        builder.setView(inflater.inflate(R.layout.dialog_aid, null))
                .setPositiveButton(R.string.edit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onAdd(context);
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
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            mListener = (ContractAidSummary.View) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must be a AddDialogListener");
        }
    }

    @Override
    public ItemAid getInfo() {
        etName = getDialog().findViewById(R.id.etName);
        etAmount = getDialog().findViewById(R.id.etAmount);

        ItemAid item = new ItemAid(etName.toString(), Float.valueOf(etAmount.toString()));

        return item;
    }
}