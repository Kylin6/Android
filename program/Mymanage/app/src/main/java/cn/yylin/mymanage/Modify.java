package cn.yylin.mymanage;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Modify extends Activity implements OnClickListener {

	private EditText et_show;
	private Button deleteButton;
	private TextView updateButton,backButton;
	//声明数据库
	private DBHelper dbHelper;
	//声明游标
	private Cursor cursor;
	//声明字段id
	private int id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modify);
		init();
	}
	private void init() {
		et_show=(EditText)findViewById(R.id.et_modify);
		Intent intent = getIntent();
		String data = intent.getStringExtra("data");
		// id=Integer.parseInt(intent.getStringExtra("id"));
		 id=intent.getIntExtra("id",id);
		et_show.setText(data);
		//实例化数据库
		dbHelper =new DBHelper(this);
		//得到游标
		cursor= dbHelper.select();
		updateButton = (TextView)findViewById(R.id.tbn_update);
		deleteButton=(Button)findViewById(R.id.btn_delete);
		backButton=(TextView)findViewById(R.id.btn_back);
		updateButton.setOnClickListener(this);
		deleteButton.setOnClickListener(this);
		backButton.setOnClickListener(this);
	}
	
	//修改数据
		public void updateData(){
			//根据数据id来修改数据
			if(id==0){
				Toast.makeText(Modify.this, "不能为空", Toast.LENGTH_SHORT).show();
				
			}else{
				dbHelper.update(id, et_show.getText().toString());
				//刷新游标
				cursor.requery();
				//赋值
		//		et_show.setText("");
				//清零
				id=0;
			}
		}
		//删除数据
		public void deleteData(){
			//判断id
			if(id==0){
				Toast.makeText(Modify.this, "文本框", Toast.LENGTH_SHORT).show();
			}else{
				//通过id进行删除
				dbHelper.delete(id);
				//刷新游标
				cursor.requery();
				//刷新list
				//list.invalidateViews();
				//赋值
				//et_show.setText("");
				//清零
				id=0;
			}
		}
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.tbn_update:
			updateData();
			Intent intent1 = new Intent(this,MainActivity.class);
			startActivity(intent1);
			finish();
			break;

		case R.id.btn_delete:
			deleteData();
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.btn_back:
			Intent intent2 = new Intent(this,MainActivity.class);
			startActivity(intent2);
			finish();
			break;
		}
		
	}
}
