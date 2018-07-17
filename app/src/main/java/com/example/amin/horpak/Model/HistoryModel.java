package com.example.amin.horpak.Model;

import java.util.List;

public class HistoryModel {

    /**
     * StatusID : 1
     * Detail : [{"ID_Room":"61","No_Room":"202","Price":"3000","Floor":"2","Status":"noblank","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","ID_book":"30","Date_book":"2018-07-19","Date_checkin":"2018-07-21","date_checkout1":"0000-00-00","Date_deposit":"2018-07-19","Date_recheck":"0000-00-00","img_book":"1430748825-1119554110-o.jpg","status_book":"รับห้องพักเรียบร้อย","ID_Mem":"1"},{"ID_Room":"53","No_Room":"104","Price":"500","Floor":"1","Status":"blank","Rental_type":"รายวัน","Deposit":"250","Deposit_m":"500","ID_typeroom":"9","ID_book":"34","Date_book":"2018-07-16","Date_checkin":"2018-07-18","date_checkout1":"2018-07-19","Date_deposit":"2018-07-16","Date_recheck":"0000-00-00","img_book":"1430748825-1119554110-o.jpg","status_book":"รอการยืนยันการจ่ายค่ามัดจำ","ID_Mem":"1"}]
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
         * ID_Room : 61
         * No_Room : 202
         * Price : 3000
         * Floor : 2
         * Status : noblank
         * Rental_type : รายเดือน
         * Deposit : 300
         * Deposit_m : 6000
         * ID_typeroom : 9
         * ID_book : 30
         * Date_book : 2018-07-19
         * Date_checkin : 2018-07-21
         * date_checkout1 : 0000-00-00
         * Date_deposit : 2018-07-19
         * Date_recheck : 0000-00-00
         * img_book : 1430748825-1119554110-o.jpg
         * status_book : รับห้องพักเรียบร้อย
         * ID_Mem : 1
         */

        private String ID_Room;
        private String No_Room;
        private String Price;
        private String Floor;
        private String Status;
        private String Rental_type;
        private String Deposit;
        private String Deposit_m;
        private String ID_typeroom;
        private String ID_book;
        private String Date_book;
        private String Date_checkin;
        private String date_checkout1;
        private String Date_deposit;
        private String Date_recheck;
        private String img_book;
        private String status_book;
        private String ID_Mem;

        public String getID_Room() {
            return ID_Room;
        }

        public void setID_Room(String ID_Room) {
            this.ID_Room = ID_Room;
        }

        public String getNo_Room() {
            return No_Room;
        }

        public void setNo_Room(String No_Room) {
            this.No_Room = No_Room;
        }

        public String getPrice() {
            return Price;
        }

        public void setPrice(String Price) {
            this.Price = Price;
        }

        public String getFloor() {
            return Floor;
        }

        public void setFloor(String Floor) {
            this.Floor = Floor;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getRental_type() {
            return Rental_type;
        }

        public void setRental_type(String Rental_type) {
            this.Rental_type = Rental_type;
        }

        public String getDeposit() {
            return Deposit;
        }

        public void setDeposit(String Deposit) {
            this.Deposit = Deposit;
        }

        public String getDeposit_m() {
            return Deposit_m;
        }

        public void setDeposit_m(String Deposit_m) {
            this.Deposit_m = Deposit_m;
        }

        public String getID_typeroom() {
            return ID_typeroom;
        }

        public void setID_typeroom(String ID_typeroom) {
            this.ID_typeroom = ID_typeroom;
        }

        public String getID_book() {
            return ID_book;
        }

        public void setID_book(String ID_book) {
            this.ID_book = ID_book;
        }

        public String getDate_book() {
            return Date_book;
        }

        public void setDate_book(String Date_book) {
            this.Date_book = Date_book;
        }

        public String getDate_checkin() {
            return Date_checkin;
        }

        public void setDate_checkin(String Date_checkin) {
            this.Date_checkin = Date_checkin;
        }

        public String getDate_checkout1() {
            return date_checkout1;
        }

        public void setDate_checkout1(String date_checkout1) {
            this.date_checkout1 = date_checkout1;
        }

        public String getDate_deposit() {
            return Date_deposit;
        }

        public void setDate_deposit(String Date_deposit) {
            this.Date_deposit = Date_deposit;
        }

        public String getDate_recheck() {
            return Date_recheck;
        }

        public void setDate_recheck(String Date_recheck) {
            this.Date_recheck = Date_recheck;
        }

        public String getImg_book() {
            return img_book;
        }

        public void setImg_book(String img_book) {
            this.img_book = img_book;
        }

        public String getStatus_book() {
            return status_book;
        }

        public void setStatus_book(String status_book) {
            this.status_book = status_book;
        }

        public String getID_Mem() {
            return ID_Mem;
        }

        public void setID_Mem(String ID_Mem) {
            this.ID_Mem = ID_Mem;
        }
    }
}
