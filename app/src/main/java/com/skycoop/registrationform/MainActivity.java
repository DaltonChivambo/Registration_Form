package com.skycoop.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText edit_name, edit_age;
    private RadioButton rb_masculine, rb_female;
    private TextView tv_name, tv_age, tv_gender;
    private Button bt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        bt_register.setOnClickListener(view -> {

            String name = edit_name.getText().toString();
            String age = edit_age.getText().toString();
            if (name.isEmpty() || age.isEmpty()){
                Snackbar.make(view,"Enter name and age",Snackbar.LENGTH_SHORT).show();
            }else {
                returnInformation(view);
                Toast.makeText(this,"successfully registered",Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void returnInformation(View view){
        String name = edit_name.getText().toString();
        String age = edit_age.getText().toString();
        if (rb_female.isChecked()){
            tv_name.setText(name);
            tv_age.setText("Age: "+age+" years");
            tv_gender.setText("Gender: Female");

        }else if (rb_masculine.isChecked()){
            tv_name.setText(name);
            tv_age.setText("Age: "+age+" years");
            tv_gender.setText("Gender: Masculine");
        }else {
            Snackbar.make(view,"Select your sex",Snackbar.LENGTH_SHORT).show();
        }
    }
    private void initComponents(){
        edit_name = findViewById(R.id.edit_name);
        edit_age = findViewById(R.id.edit_age);
        rb_masculine = findViewById(R.id.rb_masculine);
        rb_female = findViewById(R.id.rb_female);
        tv_name = findViewById(R.id.tv_name);
        tv_age = findViewById(R.id.tv_age);
        tv_gender = findViewById(R.id.tv_gender);
        bt_register = findViewById(R.id.bt_register);
    }
}