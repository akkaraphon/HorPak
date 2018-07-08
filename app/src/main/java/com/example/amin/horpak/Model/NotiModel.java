package com.example.amin.horpak.Model;

import java.util.List;

public class NotiModel {

    /**
     * StatusID : 1
     * Detail : [{"ID_notis":"10","message":"กรุณาอัปโหลดรูปสำเนาบัตรประชาชน","username":"root","method":"upload","table_left":"rentel","leftno":"9","ID_Mem":"1","ID_Room":"61","ID_rentel":"9"},{"ID_notis":"12","message":"กรุณาทำสัญญาเช่า","username":"root","method":"agreement","table_left":"rentel","leftno":"9","ID_Mem":"1","ID_Room":"61","ID_rentel":"9"},{"ID_notis":"13","message":"กรุณาทำสัญญาเช่า","username":"root","method":"agreement","table_left":"rentel","leftno":"10","ID_Mem":"1","ID_Room":"61","ID_rentel":"9"},{"ID_notis":"10","message":"กรุณาอัปโหลดรูปสำเนาบัตรประชาชน","username":"root","method":"upload","table_left":"rentel","leftno":"9","ID_Mem":"1","ID_Room":"50","ID_rentel":"10"},{"ID_notis":"12","message":"กรุณาทำสัญญาเช่า","username":"root","method":"agreement","table_left":"rentel","leftno":"9","ID_Mem":"1","ID_Room":"50","ID_rentel":"10"},{"ID_notis":"13","message":"กรุณาทำสัญญาเช่า","username":"root","method":"agreement","table_left":"rentel","leftno":"10","ID_Mem":"1","ID_Room":"50","ID_rentel":"10"},{"ID_notis":"10","message":"กรุณาอัปโหลดรูปสำเนาบัตรประชาชน","username":"root","method":"upload","table_left":"rentel","leftno":"9","ID_Mem":"1","ID_Room":"60","ID_rentel":"11"},{"ID_notis":"12","message":"กรุณาทำสัญญาเช่า","username":"root","method":"agreement","table_left":"rentel","leftno":"9","ID_Mem":"1","ID_Room":"60","ID_rentel":"11"},{"ID_notis":"13","message":"กรุณาทำสัญญาเช่า","username":"root","method":"agreement","table_left":"rentel","leftno":"10","ID_Mem":"1","ID_Room":"60","ID_rentel":"11"}]
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
         * ID_notis : 10
         * message : กรุณาอัปโหลดรูปสำเนาบัตรประชาชน
         * username : root
         * method : upload
         * table_left : rentel
         * leftno : 9
         * ID_Mem : 1
         * ID_Room : 61
         * ID_rentel : 9
         */

        private String ID_notis;
        private String message;
        private String username;
        private String method;
        private String table_left;
        private String leftno;
        private String ID_Mem;
        private String ID_Room;
        private String ID_rentel;

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
    }
}
