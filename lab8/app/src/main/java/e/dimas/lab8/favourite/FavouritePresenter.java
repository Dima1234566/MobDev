package e.dimas.lab8.favourite;


import java.util.List;

public class FavouritePresenter implements FavouriteContract.Presenter {
    FavouriteContract.View mView;
    FavouriteContract.Model mModel;

    public FavouritePresenter(FavouriteContract.View mView) {
        this.mView = mView;
        this.mModel = new FavouriteModel();
    }

    public void setDataToListView() {
        List<String> listData = mModel.getFavouriteList();
        mView.display(listData);
    }
}

