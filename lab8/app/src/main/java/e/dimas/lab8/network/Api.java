package e.dimas.lab8.network;

import e.dimas.lab8.entity.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/photos")
    Call<List<Photo>> getPhotos();
}
