package a7315.jd.a7315.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
                Intent intent = new Intent(mContext, ActivityHome.class);
                startActivity(intent);
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ActivityRegister.class);
                startActivity(intent);
            }
        });
    }
}
