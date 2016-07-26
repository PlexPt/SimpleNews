package com.zzh.simplenews.content;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.zzh.simplenews.R;
import com.zzh.simplenews.SimpleNewsApplication;
import com.zzh.simplenews.beans.Content;
import com.zzh.simplenews.util.Shares;

import javax.inject.Inject;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;


/**
 * Created by zzh on 16/7/12.
 */
public class contentActivity extends SwipeBackActivity {

    public static final String EXTRA_DATA_TAG = "STORY_ID";
    public static final String TAG = contentActivity.class.getSimpleName();
    private ProgressBar mProgressBar;

    private WebView mWebView;

    private Toolbar mToolbar;

    private int mStoryId = 0;

    private ImageView mImageView;

    private DaggercontentActivityComponent mComponent;

    private String shareUrl;

    @Inject
    contentPresenter mContentPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mComponent = (DaggercontentActivityComponent)DaggercontentActivityComponent.builder()
                .repositoryComponent(((SimpleNewsApplication)(getApplication())).getRepositoryComponent())
                .build();
        mComponent.inject(this);
        Intent intent = getIntent();
        mStoryId = intent.getIntExtra(EXTRA_DATA_TAG,0);
        Log.d(TAG,"Id = " + mStoryId);
        setContentView(R.layout.activity_content);
        mProgressBar = (ProgressBar)findViewById(R.id.content_progressBar);
        mToolbar = (Toolbar) findViewById(R.id.content_toolbar);
        mWebView = (WebView) findViewById(R.id.content_webView);
        mWebView.getSettings().getJavaScriptEnabled();
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mProgressBar.setProgress(newProgress);
                Log.d(TAG,"progress = " + newProgress);
                if (newProgress == 100){
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mContentPresenter.setContentActivity(this);
        mContentPresenter.getContent(String.valueOf(mStoryId));
        mImageView = (ImageView)findViewById(R.id.content_imageView);
        mToolbar.setNavigationIcon(R.drawable.icon_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar.inflateMenu(R.menu.main_menu);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_share:
                        //Shares.share();
                        if (shareUrl != null){
                            Shares.share(contentActivity.this, shareUrl);
                        }
                        break;
                }
                return true;
            }
        });
    }

    public void BeforeRefresh() {
        mProgressBar.setVisibility(View.VISIBLE);

    }

    public void AfterRefresh() {

        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage("网络出了点问题额")
                .setPositiveButton("返回", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public void AfterRefresh(Content content) {

        shareUrl = content.getShare_url();
        loadDate(content.getBody());
        mToolbar.setTitle(content.getTitle());
        Glide.with(this)
                .load(content.getImage())
                .into(mImageView);
    }

    public void loadDate(String data) {
        if (data != null) {
            mWebView.loadDataWithBaseURL("x-data://base", wrapHtml(data), "text/html", "UTF-8", null);
        }

    }

    public String wrapHtml(String body) {
        String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/css/news.css\" type=\"text/css\">";
        String html = "<html><head>" + css + "</head><body>" + body + "</body></html>";
        html = html.replace("<div class=\"img-place-holder\">", "");
        return html;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContentPresenter.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        String title =  String.valueOf(mToolbar.getTitle());
        Log.d(TAG,"save" + title);
        outState.putString("ToolBarTilte",title);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        String title = savedInstanceState.getString("ToolBarTilte");
        Log.d(TAG,"restore" + title);
        mToolbar.setTitle(title);
        super.onRestoreInstanceState(savedInstanceState);

    }
}

