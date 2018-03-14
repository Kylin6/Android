package first.zptc.cn.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ydkf051 on 2018/3/14.
 */

public class MyAdapter extends BaseAdapter{

    private List<User> userList;
    private LayoutInflater inflater;

    public MyAdapter(List<User> userList,Context context) {
        this.userList = userList;
        this.inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return userList==null?0:userList.size();
    }

    @Override
    public User getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //加载布局为一个视图
        View view=inflater.inflate(R.layout.itme,null);
        User user=getItem(position);
        //在view视图中查找id为image_photo的控件
        TextView tv_conter= (TextView) view.findViewById(R.id.conter);
        TextView tv_time= (TextView) view.findViewById(R.id.time);
        tv_conter.setText(user.getName());
        tv_time.setText(String.valueOf(user.getTime()));
        return view;
    }
}
