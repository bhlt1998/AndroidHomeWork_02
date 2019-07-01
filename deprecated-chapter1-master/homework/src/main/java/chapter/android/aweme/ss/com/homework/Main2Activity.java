package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
public String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        Intent intent = this.getIntent();
        data = intent.getStringExtra("data");
    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(this,data,Toast.LENGTH_SHORT);
        toast.show();
    }
}
