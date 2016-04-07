package mx.hercarr.hercarrdroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mx.hercarr.hercarrdroid.R;
import mx.hercarr.hercarrdroid.presenter.RegisterPresenter;
import mx.hercarr.hercarrdroid.view.IRegisterView;

public class RegisterActivity extends AppCompatActivity
    implements View.OnClickListener, IRegisterView {

    private RegisterPresenter presenter;

    private TextView txtUsername;
    private TextView txtPassword;
    private TextView txtFirstName;
    private TextView txtLastName;
    private TextView txtEmail;
    private TextView txtPhone;
    private Button btnSingUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init() {
        presenter = new RegisterPresenter(this);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        txtFirstName = (TextView) findViewById(R.id.txtFirstName);
        txtLastName = (TextView) findViewById(R.id.txtLastName);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        btnSingUp = (Button) findViewById(R.id.btnSingUp);
        btnSingUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnSingUp :
                presenter.registerUser(
                        this,
                        txtUsername.getText().toString(),
                        txtPassword.getText().toString(),
                        txtFirstName.getText().toString(),
                        txtLastName.getText().toString(),
                        txtEmail.getText().toString(),
                        txtPhone.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void registered(boolean result) {
        if (result) {
            showToast(R.string.msg_register_user_success);
            finish();
        } else {
            showToast(R.string.msg_register_user_error);
        }
    }

    @Override
    public void emptyFields() {
        showToast(R.string.msg_register_empty_fields);
    }

    private void showToast(int stringID) {
        Toast.makeText(this, stringID, Toast.LENGTH_LONG).show();
    }

}
