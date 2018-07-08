package com.example.amin.horpak.Model;

public class LoginModel {

    /**
     * StatusID : 1
            * Error :
            * ID : root
     * Name_Mem : สาม
     * LName_Mem : null
            * status : สมาชิก
     */

    private String StatusID;
    private String Error;
    private String ID;
    private String Name_Mem;
    private String LName_Mem;
    private String status;

    public String getStatusID() {
        return StatusID;
    }

    public void setStatusID(String StatusID) {
        this.StatusID = StatusID;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName_Mem() {
        return Name_Mem;
    }

    public void setName_Mem(String Name_Mem) {
        this.Name_Mem = Name_Mem;
    }

    public String getLName_Mem() {
        return LName_Mem;
    }

    public void setLName_Mem(String LName_Mem) {
        this.LName_Mem = LName_Mem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
