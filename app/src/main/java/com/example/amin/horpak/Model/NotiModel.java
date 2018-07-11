package com.example.amin.horpak.Model;

import java.util.List;

public class NotiModel {

    /**
     * StatusID : 1
     * Detail : [{"ID_notis":"124","message":"กรุณาทำสัญญาเช่า","username":"root","method":"agreement","table_left":"rentel","leftno":"24","isActive":"0","link":"","time":"0000-00-00 00:00:00","ID_Mem":"1","ID_Room":"50","ID_rentel":"24","Rental_type":"รายวัน"}]
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
         * ID_notis : 124
         * message : กรุณาทำสัญญาเช่า
         * username : root
         * method : agreement
         * table_left : rentel
         * leftno : 24
         * isActive : 0
         * link :
         * time : 0000-00-00 00:00:00
         * ID_Mem : 1
         * ID_Room : 50
         * ID_rentel : 24
         * Rental_type : รายวัน
         */

        private String ID_notis;
        private String message;
        private String username;
        private String method;
        private String table_left;
        private String leftno;
        private String isActive;
        private String link;
        private String time;
        private String ID_Mem;
        private String ID_Room;
        private String ID_rentel;
        private String Rental_type;

        public String getID_notis() {
            return ID_notis;
        }

        public void setID_notis(String ID_notis) {
            this.ID_notis = ID_notis;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getTable_left() {
            return table_left;
        }

        public void setTable_left(String table_left) {
            this.table_left = table_left;
        }

        public String getLeftno() {
            return leftno;
        }

        public void setLeftno(String leftno) {
            this.leftno = leftno;
        }

        public String getIsActive() {
            return isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getID_Mem() {
            return ID_Mem;
        }

        public void setID_Mem(String ID_Mem) {
            this.ID_Mem = ID_Mem;
        }

        public String getID_Room() {
            return ID_Room;
        }

        public void setID_Room(String ID_Room) {
            this.ID_Room = ID_Room;
        }

        public String getID_rentel() {
            return ID_rentel;
        }

        public void setID_rentel(String ID_rentel) {
            this.ID_rentel = ID_rentel;
        }

        public String getRental_type() {
            return Rental_type;
        }

        public void setRental_type(String Rental_type) {
            this.Rental_type = Rental_type;
        }
    }
}
