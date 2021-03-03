package com.example.doctorapp.choose.bookpic.bean;

import com.google.gson.annotations.SerializedName;

public class ChooseBookBean {

    /**
     * code : 200
     * msg :
     * data : {"pic":"https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/6abf1ee60c9c272cda717cf99c2a08e.jpg"}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    /**
     * pic : https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/6abf1ee60c9c272cda717cf99c2a08e.jpg
     */

    @SerializedName("data")
    private DataDTO data;

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

    public static class DataDTO {
        @SerializedName("pic")
        private String pic;

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }







}
