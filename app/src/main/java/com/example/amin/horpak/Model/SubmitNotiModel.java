package com.example.amin.horpak.Model;

public class SubmitNotiModel {
    /**
     * success : true
     * message : http://pmis.lpn.co.th/2.PNG
     */

    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
