package com.example.amin.horpak.Model;

import java.util.List;

public class PostModel {

    /**
     * StatusID : 1
     * Detail : [{"ID_post":"1","num_post":"123","date_in":"2018-07-16","date_out":"0000-00-00","status_post":"รอรับ","name_post":"กก","user":"","ID_Room":"0","ID_Mem":"0"},{"ID_post":"2","num_post":"213","date_in":"2018-07-16","date_out":"0000-00-00","status_post":"รอรับ","name_post":"","user":"","ID_Room":"0","ID_Mem":"0"}]
     */

    private String StatusID;
    private List<DetailBean> Detail;

    public String getStatusID() {
        return StatusID;
    }

    public void setStatusID(String StatusID) {
        this.StatusID = StatusID;
    }

    public List<DetailBean> getDetail() {
        return Detail;
    }

    public void setDetail(List<DetailBean> Detail) {
        this.Detail = Detail;
    }

    public static class DetailBean {
        /**
         * ID_post : 1
         * num_post : 123
         * date_in : 2018-07-16
         * date_out : 0000-00-00
         * status_post : รอรับ
         * name_post : กก
         * user :
         * ID_Room : 0
         * ID_Mem : 0
         */

        private String ID_post;
        private String num_post;
        private String date_in;
        private String date_out;
        private String status_post;
        private String name_post;
        private String user;
        private String ID_Room;
        private String ID_Mem;

        public String getID_post() {
            return ID_post;
        }

        public void setID_post(String ID_post) {
            this.ID_post = ID_post;
        }

        public String getNum_post() {
            return num_post;
        }

        public void setNum_post(String num_post) {
            this.num_post = num_post;
        }

        public String getDate_in() {
            return date_in;
        }

        public void setDate_in(String date_in) {
            this.date_in = date_in;
        }

        public String getDate_out() {
            return date_out;
        }

        public void setDate_out(String date_out) {
            this.date_out = date_out;
        }

        public String getStatus_post() {
            return status_post;
        }

        public void setStatus_post(String status_post) {
            this.status_post = status_post;
        }

        public String getName_post() {
            return name_post;
        }

        public void setName_post(String name_post) {
            this.name_post = name_post;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getID_Room() {
            return ID_Room;
        }

        public void setID_Room(String ID_Room) {
            this.ID_Room = ID_Room;
        }

        public String getID_Mem() {
            return ID_Mem;
        }

        public void setID_Mem(String ID_Mem) {
            this.ID_Mem = ID_Mem;
        }
    }
}
