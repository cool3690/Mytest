package com.cs.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText num1,num2;
Button btn,notify;
TextView ans;

    private static final String TEST_NOTIFY_ID = "test_notyfy_id";
    private static final int NOTYFI_REQUEST_ID = 300;
    private int testNotifyId = 11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=(EditText)findViewById(R.id.num1);
        num2=(EditText)findViewById(R.id.num2);
        btn=(Button)findViewById(R.id.btn);
        notify=(Button)findViewById(R.id.notify);
        ans=(TextView)findViewById(R.id.ans);
        btn.setOnClickListener(btnclick);
        notify.setOnClickListener(notifyclick);
        showNotification();
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

        return a+b;
    }
    private Button.OnClickListener notifyclick=new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            showNotification();
        }
    };
    public void showNotification( ) {

        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                NOTYFI_REQUEST_ID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this)
                .setContentTitle("待簽表單")
                .setContentText("你有幾張未簽表單")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent);
        NotificationChannel channel;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(TEST_NOTIFY_ID
                    , "全興請假APP"
                    , NotificationManager.IMPORTANCE_HIGH);
            builder.setChannelId(TEST_NOTIFY_ID);
            manager.createNotificationChannel(channel);
        } else {
            builder.setDefaults(Notification.DEFAULT_ALL)
                    .setVisibility(Notification.VISIBILITY_PUBLIC);
        }
        manager.notify(testNotifyId,
                builder.build());
    }
}