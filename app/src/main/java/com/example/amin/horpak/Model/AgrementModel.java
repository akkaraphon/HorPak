package com.example.amin.horpak.Model;

import java.util.List;

public class AgrementModel {

    /**
     * agm : {"ID_book":"83","Date_book":"2018-07-06","Date_checkin":"2018-07-10","date_checkout1":"0000-00-00","Date_deposit":"2018-07-06","Date_recheck":"0000-00-00","img_book":"1430748825-1119554110-o.jpg","status_book":"รับห้องพักเรียบร้อย","ID_Mem":"1","ID_Room":"60","Name_Mem":"สาม","Lname_Mem":"สี่ห้า","mem_address":"74 ดิแดง ดิแดง 10400","ID_Emp":"1","ID":"admin","Password":"123456789","Name_Emp":"admin","Lname_Emp":"admin","Address":"2038 ถนนลาดพร้าว แขวงวังทองหลาง เขตวังทองหลาง กรุงเทพ 10310","Tel":"0851245896","status1":"admin","IDCard":"8972694955433","PinCode":"0","Email":"dasd@111.com","imgemp":"","img_signature_lessor":"","ID_type_Emp":"3","No_Room":"201","Price":"3000","Floor":"2","Status":"Reservations","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","ID_Rentel":"22","date_rentel":"2018-07-06","date_checkout":"0000-00-00","typeren":"รายเดือน","img_signature_witness":"","img_signature_renter":"","deadline_pay":"5","name_witness":"","Lname_witness":"","img_card":"1430748825-1119554110-o.jpg","status_rentel":"รอยืนยันสัญญาเช่า","ID_Book":"83"}
     * fur : {"status_fur":"0","detail":[{"ID_fur_de":"30","amount":"1","ID_Room":"60","ID_furniture":"2","No_Room":"201","Price":"3000","Floor":"2","Status":"Reservations","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","name_fur":"เตียง","imgfur":"110022401.jpg","price_de":"500"},{"ID_fur_de":"31","amount":"1","ID_Room":"60","ID_furniture":"4","No_Room":"201","Price":"3000","Floor":"2","Status":"Reservations","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","name_fur":"ตู้","imgfur":"down.jpg","price_de":"700"}]}
     */

    private AgmBean agm;
    private FurBean fur;

    public AgmBean getAgm() {
        return agm;
    }

    public void setAgm(AgmBean agm) {
        this.agm = agm;
    }

    public FurBean getFur() {
        return fur;
    }

    public void setFur(FurBean fur) {
        this.fur = fur;
    }

    public static class AgmBean {
        /**
         * ID_book : 83
         * Date_book : 2018-07-06
         * Date_checkin : 2018-07-10
         * date_checkout1 : 0000-00-00
         * Date_deposit : 2018-07-06
         * Date_recheck : 0000-00-00
         * img_book : 1430748825-1119554110-o.jpg
         * status_book : รับห้องพักเรียบร้อย
         * ID_Mem : 1
         * ID_Room : 60
         * Name_Mem : สาม
         * Lname_Mem : สี่ห้า
         * mem_address : 74 ดิแดง ดิแดง 10400
         * ID_Emp : 1
         * ID : admin
         * Password : 123456789
         * Name_Emp : admin
         * Lname_Emp : admin
         * Address : 2038 ถนนลาดพร้าว แขวงวังทองหลาง เขตวังทองหลาง กรุงเทพ 10310
         * Tel : 0851245896
         * status1 : admin
         * IDCard : 8972694955433
         * PinCode : 0
         * Email : dasd@111.com
         * imgemp :
         * img_signature_lessor :
         * ID_type_Emp : 3
         * No_Room : 201
         * Price : 3000
         * Floor : 2
         * Status : Reservations
         * Rental_type : รายเดือน
         * Deposit : 300
         * Deposit_m : 6000
         * ID_typeroom : 9
         * ID_Rentel : 22
         * date_rentel : 2018-07-06
         * date_checkout : 0000-00-00
         * typeren : รายเดือน
         * img_signature_witness :
         * img_signature_renter :
         * deadline_pay : 5
         * name_witness :
         * Lname_witness :
         * img_card : 1430748825-1119554110-o.jpg
         * status_rentel : รอยืนยันสัญญาเช่า
         * ID_Book : 83
         */

        private String ID_book;
        private String Date_book;
        private String Date_checkin;
        private String date_checkout1;
        private String Date_deposit;
        private String Date_recheck;
        private String img_book;
        private String status_book;
        private String ID_Mem;
        private String ID_Room;
        private String Name_Mem;
        private String Lname_Mem;
        private String mem_address;
        private String ID_Emp;
        private String ID;
        private String Password;
        private String Name_Emp;
        private String Lname_Emp;
        private String Address;
        private String Tel;
        private String status1;
        private String IDCard;
        private String PinCode;
        private String Email;
        private String imgemp;
        private String img_signature_lessor;
        private String ID_type_Emp;
        private String No_Room;
        private String Price;
        private String Floor;
        private String Status;
        private String Rental_type;
        private String Deposit;
        private String Deposit_m;
        private String ID_typeroom;
        private String ID_Rentel;
        private String date_rentel;
        private String date_checkout;
        private String typeren;
        private String img_signature_witness;
        private String img_signature_renter;
        private String deadline_pay;
        private String name_witness;
        private String Lname_witness;
        private String img_card;
        private String status_rentel;
        private String ID_Book;

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

        public String getID_Room() {
            return ID_Room;
        }

        public void setID_Room(String ID_Room) {
            this.ID_Room = ID_Room;
        }

        public String getName_Mem() {
            return Name_Mem;
        }

        public void setName_Mem(String Name_Mem) {
            this.Name_Mem = Name_Mem;
        }

        public String getLname_Mem() {
            return Lname_Mem;
        }

        public void setLname_Mem(String Lname_Mem) {
            this.Lname_Mem = Lname_Mem;
        }

        public String getMem_address() {
            return mem_address;
        }

        public void setMem_address(String mem_address) {
            this.mem_address = mem_address;
        }

        public String getID_Emp() {
            return ID_Emp;
        }

        public void setID_Emp(String ID_Emp) {
            this.ID_Emp = ID_Emp;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }

        public String getName_Emp() {
            return Name_Emp;
        }

        public void setName_Emp(String Name_Emp) {
            this.Name_Emp = Name_Emp;
        }

        public String getLname_Emp() {
            return Lname_Emp;
        }

        public void setLname_Emp(String Lname_Emp) {
            this.Lname_Emp = Lname_Emp;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }

        public String getStatus1() {
            return status1;
        }

        public void setStatus1(String status1) {
            this.status1 = status1;
        }

        public String getIDCard() {
            return IDCard;
        }

        public void setIDCard(String IDCard) {
            this.IDCard = IDCard;
        }

        public String getPinCode() {
            return PinCode;
        }

        public void setPinCode(String PinCode) {
            this.PinCode = PinCode;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getImgemp() {
            return imgemp;
        }

        public void setImgemp(String imgemp) {
            this.imgemp = imgemp;
        }

        public String getImg_signature_lessor() {
            return img_signature_lessor;
        }

        public void setImg_signature_lessor(String img_signature_lessor) {
            this.img_signature_lessor = img_signature_lessor;
        }

        public String getID_type_Emp() {
            return ID_type_Emp;
        }

        public void setID_type_Emp(String ID_type_Emp) {
            this.ID_type_Emp = ID_type_Emp;
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

        public String getID_Rentel() {
            return ID_Rentel;
        }

        public void setID_Rentel(String ID_Rentel) {
            this.ID_Rentel = ID_Rentel;
        }

        public String getDate_rentel() {
            return date_rentel;
        }

        public void setDate_rentel(String date_rentel) {
            this.date_rentel = date_rentel;
        }

        public String getDate_checkout() {
            return date_checkout;
        }

        public void setDate_checkout(String date_checkout) {
            this.date_checkout = date_checkout;
        }

        public String getTyperen() {
            return typeren;
        }

        public void setTyperen(String typeren) {
            this.typeren = typeren;
        }

        public String getImg_signature_witness() {
            return img_signature_witness;
        }

        public void setImg_signature_witness(String img_signature_witness) {
            this.img_signature_witness = img_signature_witness;
        }

        public String getImg_signature_renter() {
            return img_signature_renter;
        }

        public void setImg_signature_renter(String img_signature_renter) {
            this.img_signature_renter = img_signature_renter;
        }

        public String getDeadline_pay() {
            return deadline_pay;
        }

        public void setDeadline_pay(String deadline_pay) {
            this.deadline_pay = deadline_pay;
        }

        public String getName_witness() {
            return name_witness;
        }

        public void setName_witness(String name_witness) {
            this.name_witness = name_witness;
        }

        public String getLname_witness() {
            return Lname_witness;
        }

        public void setLname_witness(String Lname_witness) {
            this.Lname_witness = Lname_witness;
        }

        public String getImg_card() {
            return img_card;
        }

        public void setImg_card(String img_card) {
            this.img_card = img_card;
        }

        public String getStatus_rentel() {
            return status_rentel;
        }

        public void setStatus_rentel(String status_rentel) {
            this.status_rentel = status_rentel;
        }

        public String getID_Book() {
            return ID_Book;
        }

        public void setID_Book(String ID_Book) {
            this.ID_Book = ID_Book;
        }
    }

    public static class FurBean {
        /**
         * status_fur : 0
         * detail : [{"ID_fur_de":"30","amount":"1","ID_Room":"60","ID_furniture":"2","No_Room":"201","Price":"3000","Floor":"2","Status":"Reservations","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","name_fur":"เตียง","imgfur":"110022401.jpg","price_de":"500"},{"ID_fur_de":"31","amount":"1","ID_Room":"60","ID_furniture":"4","No_Room":"201","Price":"3000","Floor":"2","Status":"Reservations","Rental_type":"รายเดือน","Deposit":"300","Deposit_m":"6000","ID_typeroom":"9","name_fur":"ตู้","imgfur":"down.jpg","price_de":"700"}]
         */

        private String status_fur;
        private List<DetailBean> detail;

        public String getStatus_fur() {
            return status_fur;
        }

        public void setStatus_fur(String status_fur) {
            this.status_fur = status_fur;
        }

        public List<DetailBean> getDetail() {
            return detail;
        }

        public void setDetail(List<DetailBean> detail) {
            this.detail = detail;
        }

        public static class DetailBean {
            /**
             * ID_fur_de : 30
             * amount : 1
             * ID_Room : 60
             * ID_furniture : 2
             * No_Room : 201
             * Price : 3000
             * Floor : 2
             * Status : Reservations
             * Rental_type : รายเดือน
             * Deposit : 300
             * Deposit_m : 6000
             * ID_typeroom : 9
             * name_fur : เตียง
             * imgfur : 110022401.jpg
             * price_de : 500
             */

            private String ID_fur_de;
            private String amount;
            private String ID_Room;
            private String ID_furniture;
            private String No_Room;
            private String Price;
            private String Floor;
            private String Status;
            private String Rental_type;
            private String Deposit;
            private String Deposit_m;
            private String ID_typeroom;
            private String name_fur;
            private String imgfur;
            private String price_de;

            public String getID_fur_de() {
                return ID_fur_de;
            }

            public void setID_fur_de(String ID_fur_de) {
                this.ID_fur_de = ID_fur_de;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getID_Room() {
                return ID_Room;
            }

            public void setID_Room(String ID_Room) {
                this.ID_Room = ID_Room;
            }

            public String getID_furniture() {
                return ID_furniture;
            }

            public void setID_furniture(String ID_furniture) {
                this.ID_furniture = ID_furniture;
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

            public String getName_fur() {
                return name_fur;
            }

            public void setName_fur(String name_fur) {
                this.name_fur = name_fur;
            }

            public String getImgfur() {
                return imgfur;
            }

            public void setImgfur(String imgfur) {
                this.imgfur = imgfur;
            }

            public String getPrice_de() {
                return price_de;
            }

            public void setPrice_de(String price_de) {
                this.price_de = price_de;
            }
        }
    }
}
