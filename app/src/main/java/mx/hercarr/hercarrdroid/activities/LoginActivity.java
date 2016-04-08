package mx.hercarr.hercarrdroid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mx.hercarr.hercarrdroid.R;
import mx.hercarr.hercarrdroid.model.User;
import mx.hercarr.hercarrdroid.presenter.LoginPresenter;
import mx.hercarr.hercarrdroid.view.ILoginView;

public class LoginActivity extends AppCompatActivity
    implements View.OnClickListener, ILoginView {

    private LoginPresenter presenter;

    private TextView txtUsername;
    private TextView txtPassword;
    private Button btnLogin;
    private Button btnSingUp;

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
        btnSingUp = (Button) findViewById(R.id.btnSingUp);
        btnLogin.setOnClickListener(this);
        btnSingUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnLogin:
                presenter.validateUser(this, txtUsername.getText().toString(), txtPassword.getText().toString());
                break;
            case R.id.btnSingUp:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void userFound(User user) {
        /* TODO - here redirect to the activity main */
        Toast.makeText(this, "Hello  " + user.getUsername() + "!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void userNotFound() {
        showToast(R.string.msg_user_not_found);
    }

    @Override
    public void emptyFields() {
        showToast(R.string.msg_login_empty_fields);
    }

    private void showToast(int stringID) {
        Toast.makeText(this, stringID, Toast.LENGTH_LONG).show();
    }

}