package first.zptc.cn.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydkf051 on 2018/3/14.
 */

public class add extends AppCompatActivity{
    private EditText text;
    private TextView textView;
    private List<User> userList = new ArrayList<>();//实体类
    private String neirong;
    private String time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        text = (EditText)findViewById(R.id.text);
        textView=(TextView)findViewById(R.id.textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add.this,MainActivity.class);
//                User us = new User();
//                us.setName(text.getText().toString());
//                us.setTime("13:30");
//                userList.add(us);

                intent.putExtra(text.getText().toString(), neirong);
                startActivity(intent);
            }
        });

    }
}
