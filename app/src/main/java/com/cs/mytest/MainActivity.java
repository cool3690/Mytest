package com.cs.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText num1,num2;
Button btn;
TextView ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=(EditText)findViewById(R.id.num1);
        num2=(EditText)findViewById(R.id.num2);
        btn=(Button)findViewById(R.id.btn);
        ans=(TextView)findViewById(R.id.ans);
        btn.setOnClickListener(btnclick);
    }
    private Button.OnClickListener btnclick=new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            int a= Integer.parseInt(num1.getText().toString()) ;
            int b= Integer.parseInt(num2.getText().toString()) ;
            ans.setText(cal(a,b)+"");
        }
    };
    public int cal(int a,int b){

        return a*b;
    }
}