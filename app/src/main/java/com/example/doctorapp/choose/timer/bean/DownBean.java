package com.example.doctorapp.choose.timer.bean;

import com.google.gson.annotations.SerializedName;

public class DownBean {


    /**
     * code : 200
     * msg :
     * data : {"id":"1290577259315032066","gmtCreate":"2020-08-04 05-13","gmtModified":"2020-08-04 05-13","businessId":"1","businessTitle":"执业药师","incident":"距离考试","endIncidentTime":"2021-10-25 12-00","statusId":1,"sort":1,"remark":"考试"}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    /**
     * id : 1290577259315032066
     * gmtCreate : 2020-08-04 05-13
     * gmtModified : 2020-08-04 05-13
     * businessId : 1
     * businessTitle : 执业药师
     * incident : 距离考试
     * endIncidentTime : 2021-10-25 12-00
     * statusId : 1
     * sort : 1
     * remark : 考试
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
        @SerializedName("id")
        private String id;
        @SerializedName("gmtCreate")
        private String gmtCreate;
        @SerializedName("gmtModified")
        private String gmtModified;
        @SerializedName("businessId")
        private String businessId;
        @SerializedName("businessTitle")
        private String businessTitle;
        @SerializedName("incident")
        private String incident;
        @SerializedName("endIncidentTime")
        private String endIncidentTime;
        @SerializedName("statusId")
        private int statusId;
        @SerializedName("sort")
        private int sort;
        @SerializedName("remark")
        private String remark;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public String getGmtModified() {
            return gmtModified;
        }

        public void setGmtModified(String gmtModified) {
            this.gmtModified = gmtModified;
        }

        public String getBusinessId() {
            return businessId;
        }

        public void setBusinessId(String businessId) {
            this.businessId = businessId;
        }

        public String getBusinessTitle() {
            return businessTitle;
        }

        public void setBusinessTitle(String businessTitle) {
            this.businessTitle = businessTitle;
        }

        public String getIncident() {
            return incident;
        }

        public void setIncident(String incident) {
            this.incident = incident;
        }

        public String getEndIncidentTime() {
            return endIncidentTime;
        }

        public void setEndIncidentTime(String endIncidentTime) {
            this.endIncidentTime = endIncidentTime;
        }

        public int getStatusId() {
            return statusId;
        }

        public void setStatusId(int statusId) {
            this.statusId = statusId;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
