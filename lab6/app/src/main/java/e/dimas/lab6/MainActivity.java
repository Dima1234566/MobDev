package e.dimas.lab6;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    private List<Photo> mDataList = new ArrayList<>();
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.noData)
    TextView nodata;
    Adapter mAdapter;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage(getString(R.string.loading));
        mProgressDialog.show();
        initRecyclerView();
        makeCall();
    }

    public void makeCall() {
        Api api = ApiUser.getRetrofitInstance().create(Api.class);
        Call<List<Photo>> call = api.getPhotos();
        call.enqueue(new Callback<List<Photo>>() {

            @Override
            public void onResponse(@NonNull Call<List<Photo>> call, @NonNull Response<List<Photo>> response) {

                if(response.isSuccessful()) {
                    mProgressDialog.dismiss();
                    mDataList = response.body();
                    display();
                }
                else {
                    Toast.makeText(MainActivity.this, R.string.error,
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Photo>> call, @NonNull Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, R.string.fail,
                        Toast.LENGTH_LONG).show();
                noData();
            }
        });
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                makeCall();
                refresh.setRefreshing(false);
            }
        });
    }

    private void initRecyclerView() {
        mAdapter = new Adapter();
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(mAdapter);
        nodata.setVisibility(View.INVISIBLE);
    }

    private void display() {
        mAdapter.loadData(mDataList);
        mAdapter.notifyDataSetChanged();
        nodata.setVisibility(View.INVISIBLE);
    }
    private void noData() {
        nodata.setVisibility(View.VISIBLE);
        mAdapter.notifyDataSetChanged();
        recycleView.setVisibility(View.INVISIBLE);

    }


}
