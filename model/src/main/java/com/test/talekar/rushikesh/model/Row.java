package com.test.talekar.rushikesh.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rushikesh_Talekar on 20-01-2018.
 */

public class Row implements Parcelable {
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("description")
  @Expose
  private String description;
  @SerializedName("imageHref")
  @Expose
  private String imageHref;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageHref() {
    return imageHref;
  }

  public void setImageHref(String imageHref) {
    this.imageHref = imageHref;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.title);
    dest.writeString(this.description);
    dest.writeString(this.imageHref);
  }

  public Row() {
  }

  protected Row(Parcel in) {
    this.title = in.readString();
    this.description = in.readString();
    this.imageHref = in.readString();
  }

  public static final Parcelable.Creator<Row> CREATOR = new Parcelable.Creator<Row>() {
    @Override
    public Row createFromParcel(Parcel source) {
      return new Row(source);
    }

    @Override
    public Row[] newArray(int size) {
      return new Row[size];
    }
  };
}
