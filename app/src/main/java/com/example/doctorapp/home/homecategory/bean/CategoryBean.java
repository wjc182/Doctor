package com.example.doctorapp.home.homecategory.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryBean {

    /**
     * code : 200
     * msg :
     * data : {"courseCategoryList":[{"id":"1280446584344457218","categoryName":"执业药师","floor":1,"remark":"执业药师","twoList":[{"id":"1321619889306652674","categoryName":"精讲课","floor":2,"remark":null,"threeList":[]},{"id":"1280677114797273089","categoryName":"提分课","floor":2,"remark":null,"threeList":[]},{"id":"1280677073386909697","categoryName":"押题课","floor":2,"remark":null,"threeList":[]},{"id":"1280677035923386370","categoryName":"冲刺课","floor":2,"remark":null,"threeList":[]},{"id":"1280676266012749825","categoryName":"真题课","floor":2,"remark":null,"threeList":[]}]},{"id":"1280446691664113666","categoryName":"执业医师","floor":1,"remark":"执业医师","twoList":[{"id":"1280678001045319682","categoryName":"中医执业","floor":2,"remark":null,"threeList":[]},{"id":"1280677923836571650","categoryName":"临床执业","floor":2,"remark":null,"threeList":[]},{"id":"1280677376446345217","categoryName":"中西医执业","floor":2,"remark":null,"threeList":[]},{"id":"1340902187243859970","categoryName":"中医助理","floor":2,"remark":null,"threeList":[]},{"id":"1340902216394272770","categoryName":"临床助理","floor":2,"remark":null,"threeList":[]},{"id":"1340902243338481665","categoryName":"中西医助理","floor":2,"remark":null,"threeList":[]},{"id":"1340902268097458178","categoryName":"乡村全科","floor":2,"remark":null,"threeList":[]}]},{"id":"1280446827450511361","categoryName":"药学职称","floor":1,"remark":"药学职称","twoList":[{"id":"1280680014109913090","categoryName":"初级(士)","floor":2,"remark":null,"threeList":[]},{"id":"1280679927149408258","categoryName":"初级(师)","floor":2,"remark":null,"threeList":[]},{"id":"1280679858002112514","categoryName":"中级","floor":2,"remark":null,"threeList":[]}]},{"id":"1280446939027386370","categoryName":"健康管理师","floor":1,"remark":"健康管理师","twoList":[{"id":"1340200316715806721","categoryName":"基础知识","floor":2,"remark":null,"threeList":[]},{"id":"1340200276421128194","categoryName":"专业技能","floor":2,"remark":null,"threeList":[]}]},{"id":"1280447166551601153","categoryName":"中医(专长)医师资格","floor":1,"remark":"中医(专长)医师资格","twoList":[]},{"id":"1280447212437286913","categoryName":"免费学习","floor":1,"remark":"","twoList":[{"id":"1340200390564917250","categoryName":"药学职称","floor":2,"remark":null,"threeList":[]},{"id":"1321620657279520769","categoryName":"健康管理师","floor":2,"remark":null,"threeList":[]},{"id":"1321620630624718850","categoryName":"执业医师","floor":2,"remark":null,"threeList":[]},{"id":"1280680373654040577","categoryName":"执业药师","floor":2,"remark":null,"threeList":[]}]}]}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
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
        /**
         * id : 1280446584344457218
         * categoryName : 执业药师
         * floor : 1
         * remark : 执业药师
         * twoList : [{"id":"1321619889306652674","categoryName":"精讲课","floor":2,"remark":null,"threeList":[]},{"id":"1280677114797273089","categoryName":"提分课","floor":2,"remark":null,"threeList":[]},{"id":"1280677073386909697","categoryName":"押题课","floor":2,"remark":null,"threeList":[]},{"id":"1280677035923386370","categoryName":"冲刺课","floor":2,"remark":null,"threeList":[]},{"id":"1280676266012749825","categoryName":"真题课","floor":2,"remark":null,"threeList":[]}]
         */

        @SerializedName("courseCategoryList")
        private List<CourseCategoryListDTO> courseCategoryList;

        public List<CourseCategoryListDTO> getCourseCategoryList() {
            return courseCategoryList;
        }

        public void setCourseCategoryList(List<CourseCategoryListDTO> courseCategoryList) {
            this.courseCategoryList = courseCategoryList;
        }

        public static class CourseCategoryListDTO {
            @SerializedName("id")
            private String id;
            @SerializedName("categoryName")
            private String categoryName;
            @SerializedName("floor")
            private int floor;
            @SerializedName("remark")
            private String remark;
            /**
             * id : 1321619889306652674
             * categoryName : 精讲课
             * floor : 2
             * remark : null
             * threeList : []
             */

            @SerializedName("twoList")
            private List<TwoListDTO> twoList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public int getFloor() {
                return floor;
            }

            public void setFloor(int floor) {
                this.floor = floor;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public List<TwoListDTO> getTwoList() {
                return twoList;
            }

            public void setTwoList(List<TwoListDTO> twoList) {
                this.twoList = twoList;
            }

            public static class TwoListDTO {
                @SerializedName("id")
                private String id;
                @SerializedName("categoryName")
                private String categoryName;
                @SerializedName("floor")
                private int floor;
                @SerializedName("remark")
                private Object remark;
                @SerializedName("threeList")
                private List<?> threeList;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getCategoryName() {
                    return categoryName;
                }

                public void setCategoryName(String categoryName) {
                    this.categoryName = categoryName;
                }

                public int getFloor() {
                    return floor;
                }

                public void setFloor(int floor) {
                    this.floor = floor;
                }

                public Object getRemark() {
                    return remark;
                }

                public void setRemark(Object remark) {
                    this.remark = remark;
                }

                public List<?> getThreeList() {
                    return threeList;
                }

                public void setThreeList(List<?> threeList) {
                    this.threeList = threeList;
                }
            }
        }
    }
}
