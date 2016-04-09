package mx.hercarr.hercarrdroid.view;

import java.util.List;

import mx.hercarr.hercarrdroid.model.Friend;

public interface IFriendsView {

    void loadFriendList(List<Friend> friends);
    void showEmptyMessage();

}