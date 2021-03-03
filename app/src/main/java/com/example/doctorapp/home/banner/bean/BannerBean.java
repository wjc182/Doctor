package com.example.doctorapp.home.banner.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BannerBean {

    /**
     * code : 200
     * msg :
     * data : {"advList":[{"id":"1338665453302530049","sort":1,"advTitle":"app首页轮播","advImg":"https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/8d9d664da2ae4c1d92d6cf4305b19bca.jpg","advUrl":"http://xingtanedu.com","advTarget":"_blank","advLocation":7}]}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataDTO data;

    @Override
    public String toString() {
        return "BannerBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

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
        @Override
        public String toString() {
            return "DataDTO{" +
                    "advList=" + advList +
                    '}';
        }

        /**
         * id : 1338665453302530049
         * sort : 1
         * advTitle : app首页轮播
         * advImg : https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/8d9d664da2ae4c1d92d6cf4305b19bca.jpg
         * advUrl : http://xingtanedu.com
         * advTarget : _blank
         * advLocation : 7
         */

        @SerializedName("advList")
        private List<AdvListDTO> advList;

        public List<AdvListDTO> getAdvList() {
            return advList;
        }

        public void setAdvList(List<AdvListDTO> advList) {
            this.advList = advList;
        }

        public static class AdvListDTO {
            @SerializedName("id")
            private String id;
            @SerializedName("sort")
            private int sort;
            @SerializedName("advTitle")
            private String advTitle;
            @SerializedName("advImg")
            private String advImg;
            @SerializedName("advUrl")
            private String advUrl;
            @SerializedName("advTarget")
            private String advTarget;
            @SerializedName("advLocation")
            private int advLocation;

            @Override
            public String toString() {
                return "AdvListDTO{" +
                        "id='" + id + '\'' +
                        ", sort=" + sort +
                        ", advTitle='" + advTitle + '\'' +
                        ", advImg='" + advImg + '\'' +
                        ", advUrl='" + advUrl + '\'' +
                        ", advTarget='" + advTarget + '\'' +
                        ", advLocation=" + advLocation +
                        '}';
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getAdvTitle() {
                return advTitle;
            }

            public void setAdvTitle(String advTitle) {
                this.advTitle = advTitle;
            }

            public String getAdvImg() {
                return advImg;
            }

            public void setAdvImg(String advImg) {
                this.advImg = advImg;
            }

            public String getAdvUrl() {
                return advUrl;
            }

            public void setAdvUrl(String advUrl) {
                this.advUrl = advUrl;
            }

            public String getAdvTarget() {
                return advTarget;
            }

            public void setAdvTarget(String advTarget) {
                this.advTarget = advTarget;
            }

            public int getAdvLocation() {
                return advLocation;
            }

            public void setAdvLocation(int advLocation) {
                this.advLocation = advLocation;
            }
        }
    }
}

