package com.example.sharedpreference;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView name, mob, mail, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.name);
        mob = findViewById(R.id.phone);
        mail = findViewById(R.id.email);
        password = findViewById(R.id.password);

        String username = getIntent().getStringExtra("username");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");
        String passwd = getIntent().getStringExtra("password");

        name.setText("Name : " + username);
        mob.setText("Phone : " + phone);
        mail.setText("Email : " + email);
        password.setText("Password : " + passwd);
    }
}