package my.example.appdocbao;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
public class WebViewActivity extends AppCompatActivity {
    WebView webViewBao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webViewBao = findViewById(R.id.webViewBao);
        String tieuDe = getIntent().getStringExtra("tieuDe");
        String duongDan = getIntent().getStringExtra("duongDan");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Bài báo");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        webViewBao.getSettings().setJavaScriptEnabled(true);
        webViewBao.setWebViewClient(new WebViewClient());
        webViewBao.loadUrl(duongDan);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (webViewBao.canGoBack()) {
                    webViewBao.goBack();
                } else {
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}