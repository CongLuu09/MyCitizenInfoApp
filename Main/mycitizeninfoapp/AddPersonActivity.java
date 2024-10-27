package com.example.mycitizeninfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycitizeninfoapp.database.DatabaseHelper;
import com.example.mycitizeninfoapp.model.Person;

public class AddPersonActivity extends AppCompatActivity {
    private EditText nameInput, ageInput, addressInput, phoneInput;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        db = new DatabaseHelper(this);
        nameInput = findViewById(R.id.name_input);
        ageInput = findViewById(R.id.age_input);
        addressInput = findViewById(R.id.address_input);
        phoneInput  = findViewById(R.id.phone_input);

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePerson();
            }

            private void savePerson() {
                String name = nameInput.getText().toString();
                int age = Integer.parseInt(ageInput.getText().toString());
                String address = addressInput.getText().toString();
                String phone = phoneInput.getText().toString();

                Person person = new Person(name, age, address, phone);
                db.addPerson(person);

                // Hiển thị thông báo lưu thành công
                Toast.makeText(AddPersonActivity.this, "Person saved!", Toast.LENGTH_SHORT).show();

                // Tạo Intent để chuyển sang PersonDetailActivity
                Intent intent = new Intent(AddPersonActivity.this, PersonDetailActivity.class);

                // Gửi dữ liệu người dùng qua Intent
                intent.putExtra("name", person.getName());
                intent.putExtra("age", person.getAge());
                intent.putExtra("address", person.getAddress());
                intent.putExtra("phone", person.getPhoneNumber());

                // Khởi chạy PersonDetailActivity
                startActivity(intent);

                // Kết thúc AddPersonActivity
                finish();
            }
        });
    }
}