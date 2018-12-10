package e.dimas.lab6;


import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("name")
    private final String mName;
    @SerializedName("image")
    private final String mImage;

    public Photo(String name, String image) {
        mName = name;
        mImage = image;
    }
    public String getTitle() {
        return mName;
    }
    public String getThumbnailUrl() {
        return mImage;
    }
}