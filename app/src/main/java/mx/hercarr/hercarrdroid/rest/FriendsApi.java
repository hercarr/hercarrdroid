package mx.hercarr.hercarrdroid.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FriendsApi {

    @GET("/?results=50")
    Call<ResponseBody> findFriends();

}