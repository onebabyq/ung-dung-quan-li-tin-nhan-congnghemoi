package com.example.appchat.DTO;

public class Friend {
    private int imageAVT;
    private String txtText;
    private int imageMess;
    private int imageCall;

    public int getImageAVT() {
        return imageAVT;
    }

    public void setImageAVT(int imageAVT) {
        this.imageAVT = imageAVT;
    }

    public String getTxtText() {
        return txtText;
    }

    public void setTxtText(String txtText) {
        this.txtText = txtText;
    }

    public int getImageMess() {
        return imageMess;
    }

    public void setImageMess(int imageMess) {
        this.imageMess = imageMess;
    }

    public int getImageCall() {
        return imageCall;
    }

    public void setImageCall(int imageCall) {
        this.imageCall = imageCall;
    }

    public Friend() {

    }

    public Friend(int imageAVT, String txtText, int imageMess, int imageCall) {
        this.imageAVT = imageAVT;
        this.txtText = txtText;
        this.imageMess = imageMess;
        this.imageCall = imageCall;
    }
}
