package cn.yylin.mymanage;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView exit,add;
    String TAG="123";
    private ListView listView;
    private ArrayList alist = new ArrayList();

    create_file c=new create_file();
    Activity content= MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exit = (ImageView) findViewById(R.id.exit);
        add=(ImageView) findViewById(R.id.add);
        //返回上一层
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //添加备忘录
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,createActivity.class);
                startActivity(intent);
            }
        });
        //显示备忘录信息

        c.ReadFile(content,"a.txt");
    }
}
