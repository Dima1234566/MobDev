package e.dimas.lab8.list;

import java.util.List;

import e.dimas.lab8.entity.Photo;

public interface ListContract {
    interface View {
        void display(List<Photo> dataList);
    }

    interface Presenter {
        void getData();
    }

    interface Model {
        List<Photo> callRetrofit();
    }
}

