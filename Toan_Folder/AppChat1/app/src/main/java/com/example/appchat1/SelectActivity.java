package com.example.appchat1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SelectActivity extends AppCompatActivity {
    ImageView imgAvatarGroup;
    TextView txtNameGroup;
    ImageButton btnAddAccountToGroup, btnRemoveAccountToGroup, btnRemoveGroup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuychon);

    btnAddAccountToGroup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SelectActivity.this,AddAccountToGroupActivity.class);
            startActivity(intent);
        }
    });
    }
}
