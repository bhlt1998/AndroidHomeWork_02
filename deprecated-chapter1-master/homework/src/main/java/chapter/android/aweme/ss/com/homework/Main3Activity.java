package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
public int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        Intent intent = this.getIntent();
        position = intent.getIntExtra("position",1000);
        TextView tvinfo = findViewById(R.id.tv_content_info);
        tvinfo.setText("第"+position+"个item");
    }
}
