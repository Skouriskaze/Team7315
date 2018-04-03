package a7315.jd.a7315.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import a7315.jd.a7315.Contracts.ContractLogin;
import a7315.jd.a7315.Presenters.PresenterLogin;
import a7315.jd.a7315.R;

/**
 * Created by Jesse on 11/16/2017.
 */

public class ActivityLogin extends AppCompatActivity implements ContractLogin.View {

    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;
    private Button mRegister;
    final private Context mContext = this;

    ContractLogin.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new PresenterLogin(this);


        mUsername = findViewById(R.id.etUsername);
        mPassword = findViewById(R.id.etPassword);
        mLogin = findViewById(R.id.btnLogin);
        mRegister = findViewById(R.id.btnRegister);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String szUsername = mUsername.getText().toString();
                String szPassword = mPassword.getText().toString();
                presenter.login(szUsername, szPassword);
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegisterRequest();
            }
        });
    }

    @Override
    public void onSuccessfulLogin() {
        Intent intent = new Intent(mContext, ActivityHome.class);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("username", mUsername.getText().toString());
        editor.apply();
        startActivity(intent);
    }

    @Override
    public void onFailedLogin() {

    }

    @Override
    public void onRegisterRequest() {
        Intent intent = new Intent(mContext, ActivityRegister.class);
        startActivity(intent);
    }
}
