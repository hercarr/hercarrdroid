package mx.hercarr.hercarrdroid.presenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mx.hercarr.hercarrdroid.model.Friend;
import mx.hercarr.hercarrdroid.rest.RandomUserApi;
import mx.hercarr.hercarrdroid.util.Constants;
import mx.hercarr.hercarrdroid.view.IFriendsView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsPresenter {

    private IFriendsView view;

    public FriendsPresenter(IFriendsView view) {
        this.view = view;
    }

    public void findLocalFriends() {
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

        view.loadFriendList(friends);
    }

    public void findRemoteFriends() {
        Call<ResponseBody> call = RandomUserApi.getFriendsApi().findFriends(getRandomNumberOfFriends());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.loadFriendList(parseRandomUsers(response));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.showEmptyMessage();
            }
        });
    }

    private List<Friend> parseRandomUsers(Response<ResponseBody> response) {
        String json;
        List<Friend> friends = new ArrayList<>();
        try {
            json = response.body().string();
            JSONObject jsonResponse = new JSONObject(json);
            JSONArray jsonUsers = jsonResponse.getJSONArray(Constants.JsonKeys.RESULTS);
            JSONObject jsonUser;
            Friend friend;
            for (int i = 0; i < jsonUsers.length(); i++) {
                jsonUser = jsonUsers.getJSONObject(i);
                friend = new Friend();
                friend.setFirstName(jsonUser.getJSONObject(Constants.JsonKeys.NAME).getString(Constants.JsonKeys.FIRST));
                friend.setLastName(jsonUser.getJSONObject(Constants.JsonKeys.NAME).getString(Constants.JsonKeys.LAST));
                friend.setEmail(jsonUser.getString(Constants.JsonKeys.EMAIL));
                friend.setCell(jsonUser.getString(Constants.JsonKeys.CELL));
                friend.setPhone(jsonUser.getString(Constants.JsonKeys.PHONE));
                friend.setPicture(jsonUser.getJSONObject(Constants.JsonKeys.PICTURE).getString(Constants.JsonKeys.MEDIUM));
                friends.add(friend);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return friends;
    }

    private int getRandomNumberOfFriends() {
        int min = 10;
        int max = 100;
        int number = new Random().nextInt((max - min) + 1) + min;
        return number;
    }

}