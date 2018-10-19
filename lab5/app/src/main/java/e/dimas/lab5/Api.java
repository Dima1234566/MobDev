package e.dimas.lab5;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String Base_URL = "http://www.amiiboapi.com/api/amiibo/";

    @GET("list")
    Call<List<Photo>> getPhoto();


}
