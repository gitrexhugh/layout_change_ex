package com.example.hugh.layout_change_ex1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class layout_ex01 extends Activity {

    private EditText ed_name;
    private EditText ed_age;
    private Button btn_toadvance;
    private Button btn_tobasic;
    private Button btn_submit;
    private String str_result;
    private String str_name;
    private String str_age;
    private TextView show_result;
    private Spinner location;
    private String str_location;
    private RadioGroup gender;
    private RadioButton btn_male;
    private RadioButton btn_female;
    private String str_gender;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        load_basiclayout();
    }

    private void load_basiclayout(){
        setContentView(R.layout.basic);
        ed_name=(EditText)findViewById(R.id.input_name);
        ed_age=(EditText)findViewById(R.id.input_age);
        btn_submit=(Button)findViewById(R.id.submit);
        show_result=(TextView)findViewById(R.id.show_result);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_name=ed_name.getText().toString();
                str_age=ed_age.getText().toString();
                str_result="Name:"+str_name+";"+"Age"+str_age;
                show_result.setText(str_result);
            }
        });

        btn_toadvance=(Button)findViewById(R.id.to_advance);
        btn_toadvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load_advancelayout();
            }
        });

    }

    private void load_advancelayout(){
        setContentView(R.layout.advance);
        ed_name=(EditText)findViewById(R.id.input_name);
        ed_age=(EditText)findViewById(R.id.input_age);
        gender=(RadioGroup)findViewById(R.id.gender);
        btn_male=(RadioButton)findViewById(R.id.male);
        btn_female=(RadioButton)findViewById(R.id.female);
        gender.setOnCheckedChangeListener(gendercheck);
        location=(Spinner)findViewById(R.id.spin_location);
        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(parent.getContext(),
                        parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_LONG).show();*/
                str_location=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_submit=(Button)findViewById(R.id.submit);
        show_result=(TextView)findViewById(R.id.show_result);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_name=ed_name.getText().toString();
                str_age=ed_age.getText().toString();
                str_result="Name:"+str_name+"|Age:"+str_age+"|Location:"+str_location+"|Gender:"+str_gender;
                show_result.setText(str_result);
            }
        });

        btn_tobasic=(Button)findViewById(R.id.to_basic);
        btn_tobasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load_basiclayout();
            }
        });
    }
    private RadioGroup.OnCheckedChangeListener gendercheck =new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId==R.id.male){
                str_gender=getString(R.string.male);
            }else {
                str_gender=getString(R.string.female);
            }
        }
    };
}
