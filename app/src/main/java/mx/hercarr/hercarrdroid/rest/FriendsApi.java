package mx.hercarr.hercarrdroid.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FriendsApi {

    @GET("/")
    Call<ResponseBody> findFriends(@Query("results") int amount);

}