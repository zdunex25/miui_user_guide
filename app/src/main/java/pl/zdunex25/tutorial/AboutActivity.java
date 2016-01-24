package pl.zdunex25.tutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class AboutActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Bundle extras = getIntent().getExtras();
        WebView about;
        about = (WebView) findViewById(R.id.contributors);
        about.loadUrl(extras.getString("page"));   // now it will not fail here

        Button getback = (Button) findViewById(R.id.backk);
        getback.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
