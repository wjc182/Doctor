package com.example.doctorapp.login.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LoginBean implements Parcelable {

    /**
     * code : 200
     * msg :
     * data : {"userNo":"1354322907307130881","mobile":"18295574766","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTm8iOiIxMzU0MzIyOTA3MzA3MTMwODgxIiwiaXNzIjoiUk9OQ09PIiwiZXhwIjoxNjE0MzIyNzcxfQ.MPhG4VQ1_m1o7A7TYAEy7KXao4oVgCf-hu1UrX6HUMU"}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    /**
     * userNo : 1354322907307130881
     * mobile : 18295574766
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTm8iOiIxMzU0MzIyOTA3MzA3MTMwODgxIiwiaXNzIjoiUk9OQ09PIiwiZXhwIjoxNjE0MzIyNzcxfQ.MPhG4VQ1_m1o7A7TYAEy7KXao4oVgCf-hu1UrX6HUMU
     */

    @SerializedName("data")
    private DataDTO data;

    protected LoginBean(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<LoginBean> CREATOR = new Creator<LoginBean>() {
        @Override
        public LoginBean createFromParcel(Parcel in) {
            return new LoginBean(in);
        }

        @Override
        public LoginBean[] newArray(int size) {
            return new LoginBean[size];
        }
    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(msg);
    }

    public static class DataDTO implements Parcelable{
        @SerializedName("userNo")
        private String userNo;
        @SerializedName("mobile")
        private String mobile;
        @SerializedName("token")
        private String token;

        protected DataDTO(Parcel in) {
            userNo = in.readString();
            mobile = in.readString();
            token = in.readString();
        }

        public static final Creator<DataDTO> CREATOR = new Creator<DataDTO>() {
            @Override
            public DataDTO createFromParcel(Parcel in) {
                return new DataDTO(in);
            }

            @Override
            public DataDTO[] newArray(int size) {
                return new DataDTO[size];
            }
        };

        public String getUserNo() {
            return userNo;
        }

        public void setUserNo(String userNo) {
            this.userNo = userNo;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(userNo);
            dest.writeString(mobile);
            dest.writeString(token);
        }
    }
}
