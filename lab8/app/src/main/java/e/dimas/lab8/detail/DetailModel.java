package e.dimas.lab8.detail;


import e.dimas.lab8.ApplicationEx;
import e.dimas.lab8.data.FavoriteDbHelper;

public class DetailModel implements DetailContract.Model {
    FavoriteDbHelper mDatabaseHelper;

    public DetailModel() {
        this.mDatabaseHelper = new FavoriteDbHelper(ApplicationEx.getContext());
    }

    public boolean addToFavorites(String title) {
        mDatabaseHelper.addToFavorites(ApplicationEx.getTitle());
        return true;
    }

    public void deleteFromFavourite(String title) {
        mDatabaseHelper.deleteFromFavourite(ApplicationEx.getTitle());
    }

}
