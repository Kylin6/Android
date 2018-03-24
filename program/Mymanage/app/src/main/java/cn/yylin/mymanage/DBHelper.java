package cn.yylin.mymanage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	//�������ݿ�����
	private final static String DB_NAME="my.db";
	//�����汾��
	private final static int DB_VERSION=1;
	//�������ݱ�����
	private final static String TBALE_NAME="info";
	//��������
	public final static String CONTENT="content";
	//����ʱ��
	public final static String Time="time";
	//����ID
	private final static String ID="_id";
	//����SQL����
	SQLiteDatabase datebase = getWritableDatabase();
	
	//����һ��������
	//�����������ݿ���
	//�����������ݿ⹤��
	//�����ģ��汾��
	//�����壺���ݿ��������
	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		
	}

	//�������ݱ�
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("create table " + TBALE_NAME + "(" + ID
				+ "  integer  primary key autoincrement," + CONTENT + " text," + Time + " time)");
		
	}

	//�������ݿ�
	//����һ�����ݿ����
	//���������ϵİ汾��
	//���������µİ汾��
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}
	//�������ݿ�
	public long insert(String text,String time){
		//ʵ����ContentValues
		ContentValues contentValues = new ContentValues();
		contentValues.put("content", text);
		contentValues.put("time", time);
		//��������ʾ�û����������
		//����һ������
		//�������������ǵ�value��ֵΪ�յ�ʱ���������ݲ���ʧ�ܵ�ʱ���Ĭ�ϸ�һ��Null������
		//�������������
		long row = datebase.insert(TBALE_NAME, null, contentValues);
		return row;
	}
	//�޸����ݵķ���
	public void update(int _id,String text){
		//�������޸Ĺ����ٲ��뵽���ݱ���
		ContentValues contentValues = new ContentValues();
		contentValues.put("content", text);
		//�޸ĵķ���
		//����һ������
		//�����������ݶ���
		//������/si���������
		datebase.update(TBALE_NAME, contentValues, ID+"=?", new String[]{Integer.toString(_id)});
	}
	//ɾ�����ݵķ���
	public void delete(int _id){
		datebase.delete(TBALE_NAME, ID+"=?",  new String[]{Integer.toString(_id)});
	}
	//��ѯ���ݵķ���
	public Cursor select(){
		Cursor cursor = datebase.query(TBALE_NAME, null, null, null, null, null, null);
		return cursor;
	}

	

}
