package mx.hercarr.hercarrdroid.view;

import mx.hercarr.hercarrdroid.model.User;

public interface ILoginView {

    void userFound(User user);
    void userNotFound();
    void emptyFields();

}