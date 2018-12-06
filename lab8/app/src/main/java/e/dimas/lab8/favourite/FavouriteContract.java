package e.dimas.lab8.favourite;

import java.util.List;

public interface FavouriteContract {
    interface View {
        void display(List<String> listData);
    }

    interface Presenter {
        void setDataToListView();
    }

    interface Model {
        List<String> getFavouriteList();
    }
}


