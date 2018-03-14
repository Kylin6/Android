package first.zptc.cn.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private TextView conter;
    private BaseAdapter adapter;//要实现的类
    private List<User> userList = new ArrayList<>();//实体类
    private ImageView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listview1);
        conter = (TextView)findViewById(R.id.conter);
        add =(ImageView)findViewById(R.id.add);


        Intent intent  =getIntent();
        String a=intent.getStringExtra("neirong");

        adapter=new MyAdapter(userList,MainActivity.this);
        lv.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,add.class);
                startActivity(intent);
            }
        });

    }


}
