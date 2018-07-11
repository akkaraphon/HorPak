package com.example.amin.horpak.Model;

import java.util.List;

public class RoomModel {
    /**
     * StatusID : 1
     * Detail : [{"ID_Room":"50","No_Room":"101","Price":"500","Floor":"1","Status":"blank","Rental_type":"รายวัน","Deposit":"250","Deposit_m":"500","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"51","No_Room":"102","Price":"500","Floor":"1","Status":"blank","Rental_type":"รายวัน","Deposit":"250","Deposit_m":"500","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"52","No_Room":"103","Price":"500","Floor":"1","Status":"blank","Rental_type":"รายวัน","Deposit":"250","Deposit_m":"500","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"53","No_Room":"104","Price":"500","Floor":"1","Status":"blank","Rental_type":"รายวัน","Deposit":"250","Deposit_m":"500","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"54","No_Room":"105","Price":"500","Floor":"1","Status":"blank","Rental_type":"รายวัน","Deposit":"250","Deposit_m":"500","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"55","No_Room":"106","Price":"300","Floor":"1","Status":"blank","Rental_type":"รายวัน","Deposit":"150","Deposit_m":"500","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"56","No_Room":"107","Price":"300","Floor":"1","Status":"blank","Rental_type":"รายวัน","Deposit":"150","Deposit_m":"500","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"57","No_Room":"108","Price":"300","Floor":"1","Status":"blank","Rental_type":"รายวัน","Deposit":"150","Deposit_m":"500","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"58","No_Room":"109","Price":"300","Floor":"1","Status":"blank","Rental_type":"รายวัน","Deposit":"150","Deposit_m":"500","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"59","No_Room":"110","Price":"300","Floor":"1","Status":"blank","Rental_type":"รายวัน","Deposit":"150","Deposit_m":"500","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"60","No_Room":"201","Price":"3000","Floor":"2","Status":"Reservations","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"61","No_Room":"202","Price":"3000","Floor":"2","Status":"Reservations","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"62","No_Room":"203","Price":"3000","Floor":"2","Status":"blank","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"63","No_Room":"204","Price":"3000","Floor":"2","Status":"blank","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"64","No_Room":"205","Price":"3000","Floor":"2","Status":"blank","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"65","No_Room":"206","Price":"2500","Floor":"2","Status":"blank","Rental_type":"รายเดือน","Deposit":"250","Deposit_m":"5000","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"66","No_Room":"207","Price":"2500","Floor":"2","Status":"blank","Rental_type":"รายเดือน","Deposit":"250","Deposit_m":"5000","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"67","No_Room":"208","Price":"2500","Floor":"2","Status":"blank","Rental_type":"รายเดือน","Deposit":"250","Deposit_m":"5000","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"68","No_Room":"209","Price":"2500","Floor":"2","Status":"blank","Rental_type":"รายเดือน","Deposit":"250","Deposit_m":"5000","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"69","No_Room":"210","Price":"2500","Floor":"2","Status":"blank","Rental_type":"รายเดือน","Deposit":"250","Deposit_m":"5000","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"70","No_Room":"301","Price":"3000","Floor":"3","Status":"blank","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"71","No_Room":"302","Price":"3000","Floor":"3","Status":"blank","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","name_typeroom":"ห้องแอร์"},{"ID_Room":"72","No_Room":"303","Price":"2500","Floor":"3","Status":"blank","Rental_type":"รายเดือน","Deposit":"250","Deposit_m":"5000","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"73","No_Room":"304","Price":"2500","Floor":"3","Status":"blank","Rental_type":"รายเดือน","Deposit":"250","Deposit_m":"5000","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"},{"ID_Room":"74","No_Room":"305","Price":"2500","Floor":"3","Status":"blank","Rental_type":"รายเดือน","Deposit":"250","Deposit_m":"5000","ID_typeroom":"11","name_typeroom":"ห้องพัดลม"}]
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
         * ID_Room : 50
         * No_Room : 101
         * Price : 500
         * Floor : 1
         * Status : blank
         * Rental_type : รายวัน
         * Deposit : 250
         * Deposit_m : 500
         * ID_typeroom : 9
         * name_typeroom : ห้องแอร์
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
        private String name_typeroom;

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

        public String getName_typeroom() {
            return name_typeroom;
        }

        public void setName_typeroom(String name_typeroom) {
            this.name_typeroom = name_typeroom;
        }
    }
}
