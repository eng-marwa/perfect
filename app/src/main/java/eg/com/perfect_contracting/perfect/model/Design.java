package eg.com.perfect_contracting.perfect.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by java on 17/10/2017.
 */

public class Design implements Parcelable {
    private String title;
    private int image;


    public Design() {
    }

    public Design(String title, int image) {
        this.title = title;
        this.image = image;
    }

    protected Design(Parcel in) {
        title = in.readString();
        image = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(image);
    }

    public static final Creator<Design> CREATOR = new Creator<Design>() {
        @Override
        public Design createFromParcel(Parcel in) {
            return new Design(in);
        }

        @Override
        public Design[] newArray(int size) {
            return new Design[size];
        }
    };

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
