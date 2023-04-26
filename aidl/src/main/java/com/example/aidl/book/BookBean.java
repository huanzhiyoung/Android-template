package com.example.aidl.book;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author yzh
 * @date 2023/2/9 17:59
 * @description
 */
public class BookBean implements Parcelable {

    private String bookId;
    private String bookName;

    protected BookBean(Parcel in) {
        bookId = in.readString();
        bookName = in.readString();
    }

    public static final Creator<BookBean> CREATOR = new Creator<BookBean>() {
        @Override
        public BookBean createFromParcel(Parcel in) {
            return new BookBean(in);
        }

        @Override
        public BookBean[] newArray(int size) {
            return new BookBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookId);
        dest.writeString(bookName);
    }

}
