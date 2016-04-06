package mx.hercarr.hercarrdroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mx.hercarr.hercarrdroid.R;
import mx.hercarr.hercarrdroid.presenter.LoginPresenter;
import mx.hercarr.hercarrdroid.view.ILoginView;

public class LoginActivity extends AppCompatActivity
    implements View.OnClickListener, ILoginView {

    private LoginPresenter presenter;

    private TextView txtUsername;
    private TextView txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        presenter = new LoginPresenter(this);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnLogin:
                presenter.validateUser(txtUsername.getText().toString(), txtPassword.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void userFound() {
        Log.d("TAG", "user found!!!");
    }

    @Override
    public void userNotFound() {
        showToast(R.string.msg_empty_fields);
    }

    @Override
    public void emptyFields() {
        showToast(R.string.msg_empty_fields);
    }

    private void showToast(int stringID) {
        Toast.makeText(this, stringID, Toast.LENGTH_LONG).show();
    }
}