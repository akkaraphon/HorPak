package com.example.amin.horpak.Model;

import java.util.List;

public class RoomModel {

    /**
     * StatusID : 1
     * Detail : [{"ID_Room":"35","No_Room":"102","Floor":"1"},{"ID_Room":"42","No_Room":"104","Floor":"1"},{"ID_Room":"43","No_Room":"105","Floor":"1"},{"ID_Room":"44","No_Room":"106","Floor":"1"},{"ID_Room":"45","No_Room":"107","Floor":"1"},{"ID_Room":"47","No_Room":"108","Floor":"1"},{"ID_Room":"48","No_Room":"109","Floor":"1"},{"ID_Room":"49","No_Room":"110","Floor":"1"},{"ID_Room":"38","No_Room":"201","Floor":"2"},{"ID_Room":"39","No_Room":"202","Floor":"2"},{"ID_Room":"40","No_Room":"203","Floor":"2"},{"ID_Room":"46","No_Room":"204","Floor":"2"},{"ID_Room":"41","No_Room":"301","Floor":"3"}]
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
         * ID_Room : 35
         * No_Room : 102
         * Floor : 1
         */

        private String ID_Room;
        private String No_Room;
        private String Floor;

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

        public String getFloor() {
            return Floor;
        }

        public void setFloor(String Floor) {
            this.Floor = Floor;
        }
    }
}
