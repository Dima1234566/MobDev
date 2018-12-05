package e.dimas.lab7.network;


import java.util.List;

import e.dimas.lab7.model.Photo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/photos")
    Call<List<Photo>> getPhotos();
}
