package com.example.android.newsapp;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by rmhuneineh on 11/05/2017.
 */

public class NewsWebViewClient extends WebViewClient {
    private ProgressBar mProgressBar;

    public NewsWebViewClient(ProgressBar progressBar) {
        this.mProgressBar = progressBar;
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        mProgressBar.setVisibility(View.GONE);
    }
}
