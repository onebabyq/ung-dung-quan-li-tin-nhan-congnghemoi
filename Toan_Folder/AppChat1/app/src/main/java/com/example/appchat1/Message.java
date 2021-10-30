package com.example.appchat1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Message extends AppCompatActivity {
    private String imgAvatar;
    private String txtMessage;

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getTxtMessage() {
        return txtMessage;
    }

    public void setTxtMessage(String txtMessage) {
        this.txtMessage = txtMessage;
    }
}
