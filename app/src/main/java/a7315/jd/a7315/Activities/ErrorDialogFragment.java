package a7315.jd.a7315.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

import a7315.jd.a7315.R;

/**
 * Created by Jon on 2/9/2018.
 */

public class ErrorDialogFragment extends AppCompatDialogFragment{

    String errorMessage;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.nameError);
        builder.setTitle(R.string.error);
        return builder.create();
    }
}
