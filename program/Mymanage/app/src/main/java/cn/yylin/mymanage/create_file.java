package cn.yylin.mymanage;


import android.app.Activity;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by BestWay on 2018/3/13.
 */

public class create_file {


//    fileName 需要打开的文件名
//    message  需要保存的信息
public static void ReadFile(Activity context,String fileName) {
    try {
        FileInputStream inStream = context.openFileInput(fileName);
        int len = 0;
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while ((len = inStream.read(buf)) != -1) {
            sb.append(new String(buf, 0, len));
        }
        Log.d("234", "ReadFile: "+sb);
        inStream.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public static void WriteFile(Activity context,String fileName,String message) {

        try {
            // 打开文件，该文件只能由调用该方法的应用程序访问
            // MODE_PRIVATE 该文件只能由调用该方法的应用程序访问
            // MODE_APPEND 如果文件已存在，就在结尾追加内容，而不是覆盖文件
            // MODE_WORLD_READABLE 赋予所有应用程序读权限
            // MODE_WORLD_WRITEABLE 赋予所有应用程序写权限
            FileOutputStream outStream = context.openFileOutput(fileName,MODE_APPEND);//这里选择的是第二个，追加内容


            Log.d("789", "1: "+fileName+"     "+message);
            // 将文本转换为字节集
            byte[] data = message.getBytes();
            try {
                // 写出文件
                Log.d("789", "2: "+data);
                outStream.write(data);
                outStream.flush();
                outStream.close();
                Log.d("789", "3: "+message);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
