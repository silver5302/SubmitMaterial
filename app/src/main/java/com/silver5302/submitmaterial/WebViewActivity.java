package com.silver5302.submitmaterial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView=(WebView)findViewById(R.id.webview);

        webView.setWebViewClient(new WebViewClient());
        Intent intent=getIntent();
        String link=intent.getStringExtra("link");

        webView.loadUrl(link);


    }
}
