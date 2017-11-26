package a7315.jd.a7315;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jesse on 11/26/2017.
 */

public class AddAidDialogFragment extends AppCompatDialogFragment implements AddDialog {
    EditText etName;
    EditText etAmount;

    AddDialogListener mListener;

    public interface AddDialogListener {
        void onAdd(AddDialog dialog);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final AddDialog context = this;

        builder.setView(inflater.inflate(R.layout.dialog_aid, null))
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onAdd(context);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
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
            mListener = (AddDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must be a AddDialogListener");
        }
    }

    @Override
    public Map<String, String> getInfo() {
        Map<String, String> map = new HashMap<>();
        etName = getDialog().findViewById(R.id.etName);
        etAmount = getDialog().findViewById(R.id.etAmount);
        map.put("name", etName.getText().toString());
        map.put("amount", etAmount.getText().toString());

        return map;
    }
}

interface AddDialog {
    Map<String, String> getInfo();
}
