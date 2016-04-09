package mx.hercarr.hercarrdroid.presenter;

import java.util.ArrayList;
import java.util.List;

import mx.hercarr.hercarrdroid.model.Friend;
import mx.hercarr.hercarrdroid.view.IFriendsView;

public class FriendsPresenter {

    private IFriendsView view;

    public FriendsPresenter(IFriendsView view) {
        this.view = view;
    }

    public void findFriends() {
        List<Friend> friends = findLocalFriends();
        if (friends.isEmpty()) {
            view.showEmptyMessage();
        } else {
            view.loadFriendList(friends);
        }
    }

    private List<Friend> findLocalFriends() {
        List<Friend> friends = new ArrayList<>();

        Friend alberto = new Friend();
        alberto.setFirstName("Alberto");
        alberto.setLastName("Carrasco");
        alberto.setEmail("alberto.carrasco@gmail.com");
        alberto.setCell("5587345678");
        alberto.setPicture("https://s3.amazonaws.com/uifaces/faces/twitter/mghoz/128.jpg");
        friends.add(alberto);

        Friend david = new Friend();
        david.setFirstName("David");
        david.setLastName("Torres");
        david.setEmail("david.torres@gmail.com");
        david.setCell("5673342398");
        david.setPicture("https://s3.amazonaws.com/uifaces/faces/twitter/sauro/128.jpg");
        friends.add(david);

        Friend fatima = new Friend();
        fatima.setFirstName("Fatima");
        fatima.setLastName("Torruco");
        fatima.setEmail("fatima.torruco@gmail.com");
        fatima.setCell("5598020305");
        fatima.setPicture("https://s3.amazonaws.com/uifaces/faces/twitter/brynn/128.jpg");
        friends.add(fatima);

        Friend gerardo = new Friend();
        gerardo.setFirstName("Gerardo");
        gerardo.setLastName("Muñoz");
        gerardo.setEmail("gerardo.muñoz@gmail.com");
        gerardo.setCell("5534245576");
        gerardo.setPicture("https://s3.amazonaws.com/uifaces/faces/twitter/rogie/128.jpg");
        friends.add(gerardo);

        Friend lila = new Friend();
        lila.setFirstName("Lila");
        lila.setLastName("Hernández");
        lila.setEmail("lila.hernandez@gmail.com");
        lila.setCell("5512764597");
        lila.setPicture("https://s3.amazonaws.com/uifaces/faces/twitter/allisongrayce/128.jpg");
        friends.add(lila);

        Friend noemi = new Friend();
        noemi.setFirstName("Noemi");
        noemi.setLastName("Huerta");
        noemi.setEmail("noemi.huerta@gmail.com");
        noemi.setCell("5598356784");
        noemi.setPicture("https://s3.amazonaws.com/uifaces/faces/twitter/jeanniehuang/128.jpg");
        friends.add(noemi);

        Friend monica = new Friend();
        monica.setFirstName("Monica");
        monica.setLastName("Morales");
        monica.setEmail("monica.morales@gmail.com");
        noemi.setCell("5598753245");
        monica.setPicture("https://s3.amazonaws.com/uifaces/faces/twitter/chloepark/128.jpg");
        friends.add(monica);

        return friends;
    }

}