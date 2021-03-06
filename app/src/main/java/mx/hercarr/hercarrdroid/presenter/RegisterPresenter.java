package mx.hercarr.hercarrdroid.presenter;

import android.content.Context;

import mx.hercarr.hercarrdroid.util.Constants;
import mx.hercarr.hercarrdroid.util.SharedPreferencesUtils;
import mx.hercarr.hercarrdroid.view.IRegisterView;

public class RegisterPresenter {

    private IRegisterView view;

    public RegisterPresenter(IRegisterView view) {
        this.view = view;
    }

    public void registerUser(Context context, String username, String password, String firstName, String lastName, String email, String phone) {
        if (username != null && !username.isEmpty()
                && password != null && !password.isEmpty()
                && firstName != null && !firstName.isEmpty()
                && lastName!= null && !lastName.isEmpty()
                && email!= null && !email.isEmpty()) {
            SharedPreferencesUtils.save(context, Constants.Keys.USERNAME, username);
            SharedPreferencesUtils.save(context, Constants.Keys.PASSWORD, password);
            SharedPreferencesUtils.save(context, Constants.Keys.FIRST_NAME, firstName);
            SharedPreferencesUtils.save(context, Constants.Keys.LAST_NAME, lastName);
            SharedPreferencesUtils.save(context, Constants.Keys.EMAIL, email);
            SharedPreferencesUtils.save(context, Constants.Keys.PHONE, phone);
            view.registered(true);
        } else {
            view.emptyFields();
        }
    }

}