package a7315.jd.a7315.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import a7315.jd.a7315.Contracts.ContractLogin;
import a7315.jd.a7315.Contracts.ContractRegister;
import a7315.jd.a7315.Presenters.PresenterLogin;
import a7315.jd.a7315.Presenters.PresenterRegister;
import a7315.jd.a7315.R;

public class ActivityRegister extends AppCompatActivity implements ContractRegister.View {

    private EditText mUsername;
    private EditText mPassword;
    private EditText mPasswordConfirmation;
    private Button mLogin;
    private Button mRegister;
    final private Context mContext = this;

    private ContractRegister.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presenter = new PresenterRegister(this);

        mUsername = findViewById(R.id.etUsername);
        mPassword = findViewById(R.id.etPassword);
        mLogin = findViewById(R.id.btnLogin);
        mRegister = findViewById(R.id.btnRegister);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.register(mUsername.getText().toString(), mPassword.getText().toString());
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginRequest();
            }
        });
    }

    @Override
    public void onRegisterComplete() {
        Intent intent = new Intent(mContext, ActivityHome.class);
        startActivity(intent);
    }

    @Override
    public void onLoginRequest() {
        Intent intent = new Intent(mContext, ActivityLogin.class);
        startActivity(intent);
    }
}
