package cn.yylin.mymanage;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class createActivity extends Activity implements OnClickListener{

    // 声明
    private TextView okButton, cancleButton;
    private EditText contentWrite;
    // 声明数据库
    private DBHelper dbHelper;
    // 声明游标
    private Cursor cursor;
    // 声明字段id
    private int _id = 0;
    // 声明list
	/*private ListView list;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        init();
    }


    private void init() {
        dbHelper = new DBHelper(this);
        // 得到游标
        cursor = dbHelper.select();
        // 得到实例
        okButton = (TextView) findViewById(R.id.btn_ok);
        cancleButton = (TextView) findViewById(R.id.btn_cancle);
        contentWrite = (EditText) findViewById(R.id.et_content);
        okButton.setOnClickListener(this);
        cancleButton.setOnClickListener(this);
        // 实例化listview
		/*list = (ListView) findViewById(R.id.lv_title);*/
		/*SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.listitem, cursor, new String[] { DBHelper.CONTENT },
				new int[] { R.id.tv_info });*/
    }


    // 添加数据
    private void addData() {
        // 首先判断数据是否为空
        if (contentWrite.getText().toString().equals("")) {
            Toast.makeText(createActivity.this, "文本框不能为空", Toast.LENGTH_SHORT).show();
        } else {
            //获取当前时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
            Date date = new Date(System.currentTimeMillis());
            // 插入数据
            dbHelper.insert(contentWrite.getText().toString(),simpleDateFormat.format(date).toString());
            // 刷新游标
            cursor.requery();
            // 刷新list
            //	list.invalidateViews();
            // 赋值
            contentWrite.setText("");
            // 清零
            _id = 0;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                addData() ;
                Intent intent = new Intent(createActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.btn_cancle:
                Intent intent1 = new Intent(createActivity.this,MainActivity.class);
                startActivity(intent1);
                finish();
                break;
        }

    }
}