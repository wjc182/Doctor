package com.example.doctorapp.home.gradeclass.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GradeClassBean implements Serializable {

    /**
     * code : 200
     * msg :
     * data : {"courseGradeList":[{"id":"1296253950331609277","gmtCreate":"2021-01-09","gmtModified":"2021-01-15","gradeName":"高端全程班-临床助理（网课+面授）","classLogo":"https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/c46308db9f0d4dbc94e8bb6a03c0b4b0.jpg","isFree":0,"price":"5500.00","discounts":"5500.00","courseNumber":0,"teacherNumber":0,"userNumber":1,"statusId":1,"sort":1,"categoryId1":1325280683323973633,"categoryId2":1325641143281934337,"categoryId3":0,"categoryName1":"执业医师","categoryName2":"临床助理","categoryName3":null,"lecturerUserNo":2020090911012470,"gradeTeacher":"","gradeSynopsis":null,"gradeContent":"笔试、技能精讲课程，冲刺课程，考前押题、考前面授","materialItem":"完整教材、面授讲义、押题","gradeCharacter":"网课+面授形式，考点一网打尽","serviceDuration":"1年","gradeScope":"学习时间充足，能参加面授，志在一年取证人群","promoPhoto":null,"isBroadcast":0,"broadcastTime":"0000-00-00 19:00","isBankShow":0},{"id":"1296253950331609276","gmtCreate":"2021-01-09","gmtModified":"2021-01-15","gradeName":"技能密训班-临床助理（网课+面授）","classLogo":"https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/51f469ef2648451586a1b320d4885ad7.jpg","isFree":0,"price":"680.00","discounts":"680.00","courseNumber":0,"teacherNumber":0,"userNumber":0,"statusId":1,"sort":1,"categoryId1":1325280683323973633,"categoryId2":1325641143281934337,"categoryId3":0,"categoryName1":"执业医师","categoryName2":"临床助理","categoryName3":null,"lecturerUserNo":2020090911012470,"gradeTeacher":"","gradeSynopsis":null,"gradeContent":"","materialItem":null,"gradeCharacter":"","serviceDuration":"","gradeScope":"","promoPhoto":null,"isBroadcast":0,"broadcastTime":"0000-00-00 19:00","isBankShow":0},{"id":"1296253950331609275","gmtCreate":"2021-01-09","gmtModified":"2021-01-15","gradeName":"技能精品班-临床助理（网课）","classLogo":"https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/105d0ca21d9244a09f5b3197c2ee31db.jpg","isFree":0,"price":"480.00","discounts":"480.00","courseNumber":0,"teacherNumber":0,"userNumber":0,"statusId":1,"sort":1,"categoryId1":1325280683323973633,"categoryId2":1325641143281934337,"categoryId3":0,"categoryName1":"执业医师","categoryName2":"临床助理","categoryName3":null,"lecturerUserNo":2020090911012470,"gradeTeacher":"","gradeSynopsis":null,"gradeContent":"","materialItem":null,"gradeCharacter":"","serviceDuration":"","gradeScope":"","promoPhoto":null,"isBroadcast":0,"broadcastTime":"0000-00-00 19:00","isBankShow":0},{"id":"1296253950331609274","gmtCreate":"2021-01-09","gmtModified":"2021-01-15","gradeName":"笔试精品班-临床助理（网课）","classLogo":"https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/9ad55f42964b4e3d98c5b0f859810951.jpg","isFree":0,"price":"1680.00","discounts":"1680.00","courseNumber":0,"teacherNumber":0,"userNumber":0,"statusId":1,"sort":1,"categoryId1":1325280683323973633,"categoryId2":1325641143281934337,"categoryId3":0,"categoryName1":"执业医师","categoryName2":"临床助理","categoryName3":null,"lecturerUserNo":2020090911012470,"gradeTeacher":"","gradeSynopsis":null,"gradeContent":"","materialItem":null,"gradeCharacter":"","serviceDuration":"","gradeScope":"","promoPhoto":null,"isBroadcast":0,"broadcastTime":"0000-00-00 19:00","isBankShow":0},{"id":"1296253950331609219","gmtCreate":"2020-11-11","gmtModified":"2021-01-15","gradeName":"笔试密训班-临床助理（网课+面授）","classLogo":"https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/f687407b87c54ae3b450d12b492f4e45.jpg","isFree":0,"price":"4980.00","discounts":"4980.00","courseNumber":0,"teacherNumber":0,"userNumber":1003,"statusId":1,"sort":1,"categoryId1":1325280683323973633,"categoryId2":1325641143281934337,"categoryId3":0,"categoryName1":"执业医师","categoryName2":"临床助理","categoryName3":null,"lecturerUserNo":2020082808331397,"gradeTeacher":"","gradeSynopsis":null,"gradeContent":"","materialItem":null,"gradeCharacter":"","serviceDuration":"","gradeScope":"","promoPhoto":null,"isBroadcast":0,"broadcastTime":"0000-00-00 19:00","isBankShow":0},{"id":"1296253950331609148","gmtCreate":"2020-10-13","gmtModified":"2021-01-15","gradeName":"无忧取证班-临床助理（网课）","classLogo":"https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/4a564191e3c74457a846af3c9b39a39c.jpg","isFree":0,"price":"1980.00","discounts":"1980.00","courseNumber":0,"teacherNumber":0,"userNumber":1009,"statusId":1,"sort":1,"categoryId1":1325280683323973633,"categoryId2":1325641143281934337,"categoryId3":0,"categoryName1":"执业医师","categoryName2":"临床助理","categoryName3":null,"lecturerUserNo":2018112015051635,"gradeTeacher":"","gradeSynopsis":null,"gradeContent":"","materialItem":null,"gradeCharacter":"","serviceDuration":"","gradeScope":"","promoPhoto":null,"isBroadcast":0,"broadcastTime":"0000-00-00 19:00","isBankShow":0}]}
     */

    private Integer code;
    private String msg;
    private DataBean data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        private List<CourseGradeListBean> courseGradeList;

        public List<CourseGradeListBean> getCourseGradeList() {
            return courseGradeList;
        }

        public void setCourseGradeList(List<CourseGradeListBean> courseGradeList) {
            this.courseGradeList = courseGradeList;
        }

        public static class CourseGradeListBean implements Serializable{
            /**
             * id : 1296253950331609277
             * gmtCreate : 2021-01-09
             * gmtModified : 2021-01-15
             * gradeName : 高端全程班-临床助理（网课+面授）
             * classLogo : https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/c46308db9f0d4dbc94e8bb6a03c0b4b0.jpg
             * isFree : 0
             * price : 5500.00
             * discounts : 5500.00
             * courseNumber : 0
             * teacherNumber : 0
             * userNumber : 1
             * statusId : 1
             * sort : 1
             * categoryId1 : 1325280683323973633
             * categoryId2 : 1325641143281934337
             * categoryId3 : 0
             * categoryName1 : 执业医师
             * categoryName2 : 临床助理
             * categoryName3 : null
             * lecturerUserNo : 2020090911012470
             * gradeTeacher :
             * gradeSynopsis : null
             * gradeContent : 笔试、技能精讲课程，冲刺课程，考前押题、考前面授
             * materialItem : 完整教材、面授讲义、押题
             * gradeCharacter : 网课+面授形式，考点一网打尽
             * serviceDuration : 1年
             * gradeScope : 学习时间充足，能参加面授，志在一年取证人群
             * promoPhoto : null
             * isBroadcast : 0
             * broadcastTime : 0000-00-00 19:00
             * isBankShow : 0
             */

            private String id;
            private String gmtCreate;
            private String gmtModified;
            private String gradeName;
            private String classLogo;
            private Integer isFree;
            private String price;
            private String discounts;
            private Integer courseNumber;
            private Integer teacherNumber;
            private Integer userNumber;
            private Integer statusId;
            private Integer sort;
            private String categoryId1;
            private String categoryId2;
            private String categoryId3;
            private String categoryName1;
            private String categoryName2;
            private Object categoryName3;
            private Long lecturerUserNo;
            private String gradeTeacher;
            private Object gradeSynopsis;
            private String gradeContent;
            private String materialItem;
            private String gradeCharacter;
            private String serviceDuration;
            private String gradeScope;
            private Object promoPhoto;
            private Integer isBroadcast;
            private String broadcastTime;
            private Integer isBankShow;

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

            public String getGradeName() {
                return gradeName;
            }

            public void setGradeName(String gradeName) {
                this.gradeName = gradeName;
            }

            public String getClassLogo() {
                return classLogo;
            }

            public void setClassLogo(String classLogo) {
                this.classLogo = classLogo;
            }

            public Integer getIsFree() {
                return isFree;
            }

            public void setIsFree(Integer isFree) {
                this.isFree = isFree;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getDiscounts() {
                return discounts;
            }

            public void setDiscounts(String discounts) {
                this.discounts = discounts;
            }

            public Integer getCourseNumber() {
                return courseNumber;
            }

            public void setCourseNumber(Integer courseNumber) {
                this.courseNumber = courseNumber;
            }

            public Integer getTeacherNumber() {
                return teacherNumber;
            }

            public void setTeacherNumber(Integer teacherNumber) {
                this.teacherNumber = teacherNumber;
            }

            public Integer getUserNumber() {
                return userNumber;
            }

            public void setUserNumber(Integer userNumber) {
                this.userNumber = userNumber;
            }

            public Integer getStatusId() {
                return statusId;
            }

            public void setStatusId(Integer statusId) {
                this.statusId = statusId;
            }

            public Integer getSort() {
                return sort;
            }

            public void setSort(Integer sort) {
                this.sort = sort;
            }


            public String getCategoryId1() {
                return categoryId1;
            }

            public void setCategoryId1(String categoryId1) {
                this.categoryId1 = categoryId1;
            }

            public String getCategoryId2() {
                return categoryId2;
            }

            public void setCategoryId2(String categoryId2) {
                this.categoryId2 = categoryId2;
            }

            public String getCategoryId3() {
                return categoryId3;
            }

            public void setCategoryId3(String categoryId3) {
                this.categoryId3 = categoryId3;
            }

            public String getCategoryName1() {
                return categoryName1;
            }

            public void setCategoryName1(String categoryName1) {
                this.categoryName1 = categoryName1;
            }

            public String getCategoryName2() {
                return categoryName2;
            }

            public void setCategoryName2(String categoryName2) {
                this.categoryName2 = categoryName2;
            }

            public Object getCategoryName3() {
                return categoryName3;
            }

            public void setCategoryName3(Object categoryName3) {
                this.categoryName3 = categoryName3;
            }

            public Long getLecturerUserNo() {
                return lecturerUserNo;
            }

            public void setLecturerUserNo(Long lecturerUserNo) {
                this.lecturerUserNo = lecturerUserNo;
            }

            public String getGradeTeacher() {
                return gradeTeacher;
            }

            public void setGradeTeacher(String gradeTeacher) {
                this.gradeTeacher = gradeTeacher;
            }

            public Object getGradeSynopsis() {
                return gradeSynopsis;
            }

            public void setGradeSynopsis(Object gradeSynopsis) {
                this.gradeSynopsis = gradeSynopsis;
            }

            public String getGradeContent() {
                return gradeContent;
            }

            public void setGradeContent(String gradeContent) {
                this.gradeContent = gradeContent;
            }

            public String getMaterialItem() {
                return materialItem;
            }

            public void setMaterialItem(String materialItem) {
                this.materialItem = materialItem;
            }

            public String getGradeCharacter() {
                return gradeCharacter;
            }

            public void setGradeCharacter(String gradeCharacter) {
                this.gradeCharacter = gradeCharacter;
            }

            public String getServiceDuration() {
                return serviceDuration;
            }

            public void setServiceDuration(String serviceDuration) {
                this.serviceDuration = serviceDuration;
            }

            public String getGradeScope() {
                return gradeScope;
            }

            public void setGradeScope(String gradeScope) {
                this.gradeScope = gradeScope;
            }

            public Object getPromoPhoto() {
                return promoPhoto;
            }

            public void setPromoPhoto(Object promoPhoto) {
                this.promoPhoto = promoPhoto;
            }

            public Integer getIsBroadcast() {
                return isBroadcast;
            }

            public void setIsBroadcast(Integer isBroadcast) {
                this.isBroadcast = isBroadcast;
            }

            public String getBroadcastTime() {
                return broadcastTime;
            }

            public void setBroadcastTime(String broadcastTime) {
                this.broadcastTime = broadcastTime;
            }

            public Integer getIsBankShow() {
                return isBankShow;
            }

            public void setIsBankShow(Integer isBankShow) {
                this.isBankShow = isBankShow;
            }
        }
    }
}
