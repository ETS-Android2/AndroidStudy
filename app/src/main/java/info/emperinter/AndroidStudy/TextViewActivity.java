package info.emperinter.AndroidStudy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import info.emperinter.AndroidStudy.R;

public class TextViewActivity extends AppCompatActivity {
    private TextView mTv4;
    private TextView mTv5;
    private TextView mTv6;
    private Button mBtn1;
    private TextView mthings;
    String get = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitytextview);

        mTv4 = findViewById(R.id.tv_4);
        mTv5 = findViewById(R.id.tv_5);
//        mTv6 = findViewById(R.id.tv_6);
        mBtn1 = findViewById(R.id.at_btn);
        mthings = findViewById(R.id.gthings);

        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
        mTv4.getPaint().setAntiAlias(true);//去除锯齿

        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("starting","\n\n*******************\n\n\n\n\n");
                try{
                    request();
                    mthings.setText(get);
                }catch (Exception ex){
                    Log.v("info:","Something Wrong !");
                }
                Log.v("end","\n\n*******************\n\n\n\n\n");
            }
        });

    }

    public void request() {
        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                try {
                    String strUrl = "https://api.emperinter.info/history/?date=1月2日&token=1abff3a1d9d11568ad55d4b458c6f7fe"; // 你请求的 http 链接
                    URL url = new URL(strUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET"); // 设置请求方式为 GET
                    connection.connect(); // 连接
                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) { // 请求成功
                        InputStream inputStream = connection.getInputStream(); // 得到响应流
                        JSONObject json = streamToJson(inputStream); // 从响应流中提取 JSON
                        Log.v("json", json.toString()); // 打印返回的 JSON 观察处理
                        Log.v("id:", json.optString("id"));
                        Log.v("get_date:", json.optString("get_date"));
                        Log.v("things:", json.optString("things"));
                        get = json.getString("things");
                    } else {
                        Log.v("responseCode", " : " + responseCode);
                    }
                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private JSONObject streamToJson(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String temp = "";
        StringBuilder stringBuilder = new StringBuilder();
        while ((temp = bufferedReader.readLine()) != null) {
            stringBuilder.append(temp);
        }
        JSONObject json = new JSONObject(stringBuilder.toString().trim());
        return json;
    }


}