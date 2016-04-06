package mx.hercarr.hercarrdroid.presenter;

import mx.hercarr.hercarrdroid.view.ILoginView;

public class LoginPresenter {

    private ILoginView view;

    private static final String LOCAL_USERNAME = "hercarr";
    private static final String LOCAL_PASSWORD = "secret";

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    public void validateUser(String username, String password) {
        if (username != null && !username.isEmpty()
            && password != null && !password.isEmpty()) {
            if (username.equals(LOCAL_USERNAME) && password.equals(LOCAL_PASSWORD)) {
                view.userFound();
            } else {
                view.userNotFound();
            }
        } else {
            view.emptyFields();
        }
    }

}