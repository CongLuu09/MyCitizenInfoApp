package com.example.mycitizeninfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PersonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        TextView nameTextView = findViewById(R.id.name_text_view);
        TextView ageTextView = findViewById(R.id.age_text_view);
        TextView addressTextView = findViewById(R.id.address_text_view);
        TextView phoneTextView = findViewById(R.id.phone_text_view);

        // Lấy dữ liệu từ Intent
        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", 0);
        String address = getIntent().getStringExtra("address");
        String phone = getIntent().getStringExtra("phone");

        // Hiển thị thông tin người dùng
        nameTextView.setText("Name: " + name);
        ageTextView.setText("Age: " + age);
        addressTextView.setText("Address: " + address);
        phoneTextView.setText("Phone: " + phone);

    }
}