package e.dimas.lab8.detail;

public interface DetailContract {

    interface Presenter {
        void makeFavorite();

        void removeFavorite();
    }

    interface Model {
        boolean addToFavorites(String title);

        void deleteFromFavourite(String title);
    }
}
