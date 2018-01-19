package com.test.talekar.rushikesh.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rushikesh_Talekar on 20-01-2018.
 */

public class CountryNews implements Parcelable {
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("rows")
  @Expose
  private List<Row> rows = null;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Row> getRows() {
    return rows;
  }

  public void setRows(List<Row> rows) {
    this.rows = rows;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.title);
    dest.writeList(this.rows);
  }

  public CountryNews() {
  }

  protected CountryNews(Parcel in) {
    this.title = in.readString();
    this.rows = new ArrayList<Row>();
    in.readList(this.rows, Row.class.getClassLoader());
  }

  public static final Parcelable.Creator<CountryNews> CREATOR =
      new Parcelable.Creator<CountryNews>() {
        @Override
        public CountryNews createFromParcel(Parcel source) {
          return new CountryNews(source);
        }

        @Override
        public CountryNews[] newArray(int size) {
          return new CountryNews[size];
        }
      };
}
