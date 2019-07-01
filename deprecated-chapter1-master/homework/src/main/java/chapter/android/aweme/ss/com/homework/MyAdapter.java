package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class MyAdapter extends ArrayAdapter<Message> {

    private List<Message> mMessage;
    private final int ImageId;

    public MyAdapter(Context context, int resource, List<Message> messages) {
        super(context, resource, messages);
        this.mMessage = messages;
        ImageId = resource;
    }


    @Override
    public View getView(int position,  View convertView,ViewGroup parent) {

        //View view = LayoutInflater.from(getContext()).inflate(1,parent,null);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.im_list_item, null);
        String headid;
        boolean ifofficial;
        //view.findViewById(R.id.)
        //mMessage.get(position).getTitle();

        TextView title = (TextView)view.findViewById(R.id.tv_title);
        TextView description = (TextView)view.findViewById(R.id.tv_description);
        TextView time = (TextView)view.findViewById(R.id.tv_time);
        chapter.android.aweme.ss.com.homework.widget.CircleImageView head = (chapter.android.aweme.ss.com.homework.widget.CircleImageView)view.findViewById(R.id.iv_avatar);
        ImageView robotflag = (ImageView)view.findViewById(R.id.robot_notice);

        title.setText((String) mMessage.get(position).getTitle());
        description.setText((String) mMessage.get(position).getDescription());
        time.setText((String) mMessage.get(position).getTime());
        headid = (String)mMessage.get(position).getIcon();
        ifofficial = (boolean)mMessage.get(position).isOfficial();
        if(ifofficial){
            robotflag.setVisibility(View.VISIBLE);
        }else{
            robotflag.setVisibility(View.INVISIBLE);
        }
        switch (headid){
            case "TYPE_ROBOT":
                head.setImageResource(R.drawable.session_robot);
                break;
            case "TYPE_GAME":
                head.setImageResource(R.drawable.icon_micro_game_comment);
                break;
            case "TYPE_SYSTEM":
                head.setImageResource(R.drawable.session_system_notice);
                break;
            case "TYPE_STRANGER":
                head.setImageResource(R.drawable.session_stranger);
            case "TYPE_USER":
                head.setImageResource(R.drawable.icon_girl);
                break;
            default:
                head.setImageResource(R.drawable.icon_girl);
        }
//        if (headid == "TYPE_ROBOT"){
//            head.setImageResource(R.drawable.session_robot);
//        }
//        else if(headid == "TYPE_GAME"){
//            head.setImageResource(R.drawable.icon_micro_game_comment);
//        }
//        else if(headid == "TYPE_SYSTEM"){
//            head.setImageResource(R.drawable.session_system_notice);
//        }
//        else if(headid == "TYPE_STRANGER"){
//            head.setImageResource(R.drawable.session_stranger);
//        }
//        else if(headid == "TYPE_USER"){
//            head.setImageResource(R.drawable.icon_girl);
//        }
//        else {
//            head.setImageResource(R.drawable.session_stranger);
//        }
        return view;
    }
}
