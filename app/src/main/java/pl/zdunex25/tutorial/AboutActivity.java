package pl.zdunex25.tutorial;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class AboutActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        WebView about;
        about = (WebView) findViewById(R.id.contributors);
        about.loadUrl("file:///android_asset/contributors.html");   // now it will not fail here
    }
}
