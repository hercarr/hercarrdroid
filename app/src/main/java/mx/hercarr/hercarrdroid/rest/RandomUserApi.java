package mx.hercarr.hercarrdroid.rest;

import retrofit2.Retrofit;

public class RandomUserApi {

    private static final String URL_BASE = "http://api.randomuser.me";
    private static Retrofit retrofit;
    private static FriendsApi friendsApi;

    private RandomUserApi() {

    }

    static {
        setupRetrofit();
        setupApis();
    }

    private static void setupRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(URL_BASE);
        retrofit = builder.build();
    }

    private static void setupApis() {
        friendsApi = retrofit.create(FriendsApi.class);
    }

    public static FriendsApi getFriendsApi() {
        return friendsApi;
    }

}