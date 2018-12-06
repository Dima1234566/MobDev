package e.dimas.lab8.list;

import android.support.annotation.NonNull;

import e.dimas.lab8.entity.Photo;
import e.dimas.lab8.network.Api;
import e.dimas.lab8.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListModel implements ListContract.Model {
    private List<Photo> mDataList;

    @Override
    public List<Photo> callRetrofit() {
        Api api = ApiClient.getRetrofitInstance().create(Api.class);
        Call<List<Photo>> call = api.getPhotos();
        call.enqueue(new Callback<List<Photo>>() {

            @Override
            public void onResponse(@NonNull Call<List<Photo>> call, @NonNull
                    Response<List<Photo>> response) {
                if (response.isSuccessful()) {
                    mDataList = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                mDataList = null;
            }
        });
        return mDataList;
    }

}
