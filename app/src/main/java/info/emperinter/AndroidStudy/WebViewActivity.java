package info.emperinter.AndroidStudy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebView = findViewById(R.id.wv);
//      这是加载本地HTML
//        mWebView.loadUrl("file:///android_asset/test.html");


//        加载网络URL
        mWebView.getSettings().setJavaScriptEnabled(true); //JS加载支持
        mWebView.setWebViewClient(new MyWebViewClient()); //防跳转到浏览器
        mWebView.setWebChromeClient(new MyWebChromeClient());
//        mWebView.evaluateJavascript();
//        mWebView.loadUrl();//JS CODE
//        mWebView.addJavascriptInterface();  JS 调用Native代码
        mWebView.loadUrl("https://www.baidu.com");

    }

    class  MyWebChromeClient extends WebChromeClient{  //web加载进度以及其它JS调用等等！

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);

        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }


    class MyWebViewClient extends WebViewClient {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.d("WebView","onPageStarted.......");
            super.onPageStarted(view, url, favicon);
            mWebView.evaluateJavascript("javascript:alert('Load Start by evaluateJS')",null);  //JS 调用
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Log.d("WebView","onPageFinished.......");
            super.onPageFinished(view, url);
            mWebView.loadUrl("javascript:alert('Hello')");  //JS 调用
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}