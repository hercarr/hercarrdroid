package mx.hercarr.hercarrdroid.presenter;

import android.content.Context;

import mx.hercarr.hercarrdroid.model.User;
import mx.hercarr.hercarrdroid.util.Constants;
import mx.hercarr.hercarrdroid.util.SharedPreferencesUtils;
import mx.hercarr.hercarrdroid.view.ILoginView;

public class LoginPresenter {

    private ILoginView view;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    public void validateUser(Context context, String username, String password) {
        if (username != null && !username.isEmpty()
            && password != null && !password.isEmpty()) {
            String localUsername = SharedPreferencesUtils.get(context, Constants.Keys.USERNAME, null);
            String localPassword = SharedPreferencesUtils.get(context, Constants.Keys.PASSWORD, null);
            if (username.equals(localUsername) && password.equals(localPassword)) {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                view.userFound(user);
            } else {
                view.userNotFound();
            }
        } else {
            view.emptyFields();
        }
    }

    public static void setLogin(Context context) {
        SharedPreferencesUtils.save(context, Constants.Keys.LOGGED, true);
    }

    public static void setLogout(Context context) {
        SharedPreferencesUtils.save(context, Constants.Keys.LOGGED, String.valueOf(false));
    }

    public static boolean isLogged(Context context) {
        return SharedPreferencesUtils.get(context, Constants.Keys.LOGGED);
    }

}