package cn.yylin.mymanage;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends Activity implements OnClickListener{
    //声明
    private ImageView goButton;
    // 声明list
    private ListView list;
    private Cursor cursor;
    private DBHelper dbHelper;
    //声明字段id
    private int _id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        // 得到游标
        cursor = dbHelper.select();
        goButton  = (ImageView)findViewById(R.id.btn_write);
        goButton.setOnClickListener(this);
        list=(ListView)findViewById(R.id.lv_title);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item, cursor,
                new String[]{DBHelper.CONTENT,DBHelper.Time}, new int[]{R.id.tv_info,R.id.tv_time});
        //绑定适配器
        list.setAdapter(adapter);
        list.invalidateViews();
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                //查询方法
                cursor.moveToPosition(arg2);
                //如果没有查询到清零
                _id = cursor.getInt(0);
                //查询到了赋值
                //contentText.setText(cursor.getString(1));
                Intent intent = new Intent(MainActivity.this,Modify.class);
                intent.putExtra("id", _id);
                intent.putExtra("data", cursor.getString(1));
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.btn_write:
                Intent intent = new Intent(this,createActivity.class);
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }

    }


}
