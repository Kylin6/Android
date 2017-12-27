package com.example.clown.rock_paper_scissors;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /**0是剪刀，1是石头，2是布**/
    private Button gameBut,history;
    private ImageButton paper, rock, scissor;
    private TextView textview1, textview2;

    int android_g, me_g;//电脑和我出的拳
    ArrayList alist=new ArrayList();//历史列表
    String list=new String();//历史显示字符串

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history=(Button)findViewById(R.id.history);//历史按钮
        gameBut = (Button) findViewById(R.id.GameBut);//开始按钮
        textview1 = (TextView) findViewById(R.id.textView1);//me
        textview2 = (TextView) findViewById(R.id.textView2);//电脑

        history.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(MainActivity.this,CodeActivity.class);
                i.putExtra("his",alist);
                startActivity(i);
            }
        });
        gameBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android_g = (int) (Math.random()*3); //取0~2的随机整数
                textview1.setText(R.string.choose);
                textview2.setText(R.string.ready);
                gameBut.setText(R.string.again);

                paper=(ImageButton)findViewById(R.id.paper);

                rock=(ImageButton)findViewById(R.id.rock);

                scissor=(ImageButton)findViewById(R.id.scissor);

                paper.setOnClickListener(new View.OnClickListener(){
                      public void onClick (View v){
                            me_g = 2;
                            click();
                      }
                });
                rock.setOnClickListener(new View.OnClickListener(){
                      public void onClick (View v){
                          me_g = 1;
                          click();
                      }
                });
                scissor.setOnClickListener(new View.OnClickListener(){
                      public void onClick(View v){
                          me_g = 0;
                          click();
                      }
                });
            }
            /**点击出拳后操作**/
            public void click(){
                int result = android_g - me_g;
                score(result);
                textview1.setText(test(me_g));
                textview2.setText(test(android_g));
                close();
                alist.add("电脑:"+test(android_g)+"||我:"+test(me_g)+"||"+list);
            }
            /**我出拳后不可再点击**/
            public void close(){
                paper.setClickable(false);
                rock.setClickable(false);
                scissor.setClickable(false);
            }
            /**显示剪刀石头布**/
            public String test(int a) {
                if (a == 0) {
                    return "剪刀";
                } else if (a == 1) {
                    return "石头";
                } else if (a == 2) {
                    return "布";
                } else {
                    return "错误";
                }
            }
            /**猜拳结果判断**/
            public void score(int a){
                switch (a) {
                    case 0:
                        Toast.makeText(MainActivity.this, R.string.equal, Toast.LENGTH_SHORT).show();
                        list="平局!";
                        break;
                    case -1:
                    case 2:
                        Toast.makeText(MainActivity.this, R.string.win, Toast.LENGTH_SHORT).show();
                        list="你赢了!";
                        break;
                    case 1:
                    case -2:
                        Toast.makeText(MainActivity.this, R.string.fail, Toast.LENGTH_SHORT).show();
                        list="电脑赢了!";
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
/**确认退出**/
    public void onBackPressed() {
        new AlertDialog.Builder(this).setTitle("确认退出吗？")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“确认”后的操作
                        MainActivity.this.finish();

                    }
                })
                .setNegativeButton("返回", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“返回”后的操作,这里不设置没有任何操作
                    }
                }).show();
    }
}
