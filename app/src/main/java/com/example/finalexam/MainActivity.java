package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.ext_name);
        password=findViewById(R.id.ext_pass);
        login=findViewById(R.id.button1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=name.getText().toString();
                String psw=password.getText().toString();
                if(user.equals("user1") && psw.equals("password1"))
                {  Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}