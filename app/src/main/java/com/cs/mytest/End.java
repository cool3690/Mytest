package com.cs.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class End extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(btnp);
    }
    private Button.OnClickListener btnp=new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            intent.setClass(End.this,MainActivity.class);
            startActivity(intent);
        }
    };
}