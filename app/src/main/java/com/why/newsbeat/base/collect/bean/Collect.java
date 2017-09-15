package com.why.newsbeat.base.collect.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.why.newsbeat.base.detail.DetailApi;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by lenovo on 2017/9/14.
 */
@Entity
public class Collect implements DetailApi,Parcelable{


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getUniquekey() {
		return uniquekey;
	}

	public void setUniquekey(String uniquekey) {
		this.uniquekey = uniquekey;
	}

	@Override
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	@Override
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String getThumbnail_pic_s() {
		return thumbnail_pic_s;
	}

	public void setThumbnail_pic_s(String thumbnail_pic_s) {
		this.thumbnail_pic_s = thumbnail_pic_s;
	}

	@Override
	public String getThumbnail_pic_s02() {
		return thumbnail_pic_s02;
	}

	public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
		this.thumbnail_pic_s02 = thumbnail_pic_s02;
	}

	@Override
	public String getThumbnail_pic_s03() {
		return thumbnail_pic_s03;
	}

	public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
		this.thumbnail_pic_s03 = thumbnail_pic_s03;
	}


	@Override
	public String toString() {
		return "History{" +
				"username='" + username + '\'' +
				", uniquekey='" + uniquekey + '\'' +
				", title='" + title + '\'' +
				", date='" + date + '\'' +
				", category='" + category + '\'' +
				", author_name='" + author_name + '\'' +
				", url='" + url + '\'' +
				", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
				", thumbnail_pic_s02='" + thumbnail_pic_s02 + '\'' +
				", thumbnail_pic_s03='" + thumbnail_pic_s03 + '\'' +
				'}';
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(username);
		dest.writeString(uniquekey);
		dest.writeString(title);
		dest.writeString(date);
		dest.writeString(category);
		dest.writeString(author_name);
		dest.writeString(url);
		dest.writeString(thumbnail_pic_s);
		dest.writeString(thumbnail_pic_s02);
		dest.writeString(thumbnail_pic_s03);

	}


	public Collect(Parcel source) {
		username = source.readString();
		uniquekey = source.readString();
		title = source.readString();
		date = source.readString();
		category = source.readString();
		author_name = source.readString();
		url = source.readString();
		thumbnail_pic_s = source.readString();
		thumbnail_pic_s02 = source.readString();
		thumbnail_pic_s03 = source.readString();

	}

	@Generated(hash = 1122077779)
	public Collect(String username, String uniquekey, String title, String date,
			String category, String author_name, String url, String thumbnail_pic_s,
			String thumbnail_pic_s02, String thumbnail_pic_s03) {
		this.username = username;
		this.uniquekey = uniquekey;
		this.title = title;
		this.date = date;
		this.category = category;
		this.author_name = author_name;
		this.url = url;
		this.thumbnail_pic_s = thumbnail_pic_s;
		this.thumbnail_pic_s02 = thumbnail_pic_s02;
		this.thumbnail_pic_s03 = thumbnail_pic_s03;
	}

	@Generated(hash = 1726975718)
	public Collect() {
	}
	private String username;
	@Unique@Id
	private String uniquekey;
	private String title;
	private String date;
	private String category;
	private String author_name;
	private String url;
	private String thumbnail_pic_s;
	private String thumbnail_pic_s02;
	private String thumbnail_pic_s03;
	public static final Creator<Collect> CREATOR = new Creator<Collect>() {
		@Override
		public Collect createFromParcel(Parcel source) {


			return new Collect(source);
		}

		@Override
		public Collect[] newArray(int size) {
			return new Collect[size];
		}
	};
}
