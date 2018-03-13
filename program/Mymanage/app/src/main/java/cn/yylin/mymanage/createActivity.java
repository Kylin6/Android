package cn.yylin.mymanage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class createActivity extends AppCompatActivity{

    TextView tv_cancel,tv_save;//取消，保存
    EditText neirong;
    ArrayList alist = new ArrayList();//列表
    String conter = new String();


    create_file c=new create_file();
    Activity content= createActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        tv_cancel=(TextView)findViewById(R.id.tv_cancel);
        tv_save=(TextView)findViewById(R.id.tv_save);
        neirong=(EditText)findViewById(R.id.neirong);



//        返回按钮
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        保存按钮
        tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //保存文本信息
                conter=neirong.getText().toString();

                c.WriteFile(content,"a.txt",conter);
                Log.d("678", "onClick: "+fileList()+"   "+getFilesDir().toString());

                c.ReadFile(content,"a.txt");

                Intent intent =new Intent(createActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
