package com.example.yl.game;

import android.graphics.Color;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView Computer_player,player;
    ImageButton Scissors,Cloth,Rock;
    TextView Computer_player_num,player_num;
    Button play;
    int record,computer_record;
    String TAG = "MYLOG";
    int com_num=0,num=0;
    int[] imgs;
    Random rand;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Computer_player = (ImageView) findViewById(R.id.Computer_player);
        player = (ImageView) findViewById(R.id.player);
        Scissors = (ImageButton) findViewById(R.id.Scissors);
        Cloth = (ImageButton) findViewById(R.id.Cloth);
        Rock = (ImageButton) findViewById(R.id.Rock);
        Computer_player_num = (TextView) findViewById(R.id.Computer_player_num);
        player_num = (TextView) findViewById(R.id.player_num);
        play = (Button) findViewById(R.id.play);

        imgs= new int[]{R.drawable.p1, R.drawable.p1, R.drawable.p2, R.drawable.p3};
    }
    //石头剪刀布
    public void Record1(View v){
        record=1;
        player.setImageResource(R.drawable.p1);
        Log.d(TAG, "Record: "+record);
        //玩家胜
        if(((record==1)&&(computer_record==2))||((record==2)&&(computer_record==3))||((record==3)&&(computer_record==1))){
            num++;
            player_num.setText(num+"");
        }
        //电脑胜
        else if(((record==2)&&(computer_record==1))||((record==3)&&(computer_record==2))||((record==1)&&(computer_record==3))){
            com_num++;
            Computer_player_num.setText(com_num+"");
        }
    }
    public void Record2(View v){
        record=2;
        player.setImageResource(R.drawable.p2);
        Log.d(TAG, "Record: "+record);
        //玩家胜
        if(((record==1)&&(computer_record==2))||((record==2)&&(computer_record==3))||((record==3)&&(computer_record==1))){
            num++;
            player_num.setText(num+"");
        }
        //电脑胜
        else if(((record==2)&&(computer_record==1))||((record==3)&&(computer_record==2))||((record==1)&&(computer_record==3))){
            com_num++;
            Computer_player_num.setText(com_num+"");
        }
    }
    public void Record3(View v){
        record=3;
        player.setImageResource(R.drawable.p3);
        Log.d(TAG, "Record: "+record);
        //玩家胜
        if(((record==1)&&(computer_record==2))||((record==2)&&(computer_record==3))||((record==3)&&(computer_record==1))){
            num++;
            player_num.setText(num+"");
        }
        //电脑胜
        else if(((record==2)&&(computer_record==1))||((record==3)&&(computer_record==2))||((record==1)&&(computer_record==3))){
            com_num++;
            Computer_player_num.setText(com_num+"");
        }
    }
    //开始
    public void play(View v){
        rand = new Random();
        computer_record =(rand.nextInt(3)+1);
        Computer_player.setImageResource(imgs[computer_record]);
        Log.d(TAG, "play: "+computer_record);
        Log.d(TAG, "com: "+com_num+" num: "+num);

        TimerTask task = new TimerTask(){
            public void run() {

            }
        };
        timer = new Timer(true);
        timer.schedule(task,1000, 1000); //延时1000ms后执行，1000ms执行一次
//        timer.cancel(); //退出计时器




    }
    //重置
    public void reset(View v){
        num=com_num=0;
        player_num.setText(num+"");
        Computer_player_num.setText(com_num+"");
    }

}

