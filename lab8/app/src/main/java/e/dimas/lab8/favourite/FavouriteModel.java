package e.dimas.lab8.favourite;

import android.database.Cursor;

import e.dimas.lab8.ApplicationEx;
import e.dimas.lab8.data.FavoriteDbHelper;

import java.util.ArrayList;
import java.util.List;

public class FavouriteModel implements FavouriteContract.Model {
    FavoriteDbHelper mDatabaseHelper;


    public List<String> getFavouriteList() {

        mDatabaseHelper = new FavoriteDbHelper(ApplicationEx.getContext());
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add(data.getString(1));
        }
        return listData;
    }
}



