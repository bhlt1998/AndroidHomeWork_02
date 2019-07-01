package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity  implements View.OnClickListener{
private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);
        listView = findViewById(R.id.listview);
        ImageButton ib1 = findViewById(R.id.imageButton4);
        ImageButton ib2 = findViewById(R.id.imageButton5);
        ImageButton ib3 = findViewById(R.id.imageButton6);
        ImageButton ib4 = findViewById(R.id.imageButton7);
        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
        ib4.setOnClickListener(this);


        try {
            List<Message> list = PullParser.getMessage(this);
            list.get(0).getTitle();
            MyAdapter adapter = new MyAdapter(this,R.layout.im_list_item,list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent();
                    intent.setClass(Exercises3.this,Main3Activity.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imageButton4:
                Intent intent1 = new Intent();
                intent1.setClass(this,Main2Activity.class);
                intent1.putExtra("data","粉丝");
                startActivity(intent1);
                break;
            case R.id.imageButton5:
                Intent intent2 = new Intent();
                intent2.setClass(this,Main2Activity.class);
                intent2.putExtra("data","赞");
                startActivity(intent2);
                break;
            case R.id.imageButton6:
                Intent intent3 = new Intent();
                intent3.setClass(this,Main2Activity.class);
                intent3.putExtra("data","@我的");
                startActivity(intent3);
                break;
            case R.id.imageButton7:
                Intent intent4 = new Intent();
                intent4.setClass(this,Main2Activity.class);
                intent4.putExtra("data","评论");
                startActivity(intent4);
                break;
        }

    }
}
