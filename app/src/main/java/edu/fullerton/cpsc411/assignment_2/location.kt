package edu.fullerton.cpsc411.assignment_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_contact.*

class location : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)



        val location = webView

        location.webViewClient = WebViewClient()
        location.settings.javaScriptEnabled = true
        location.settings.domStorageEnabled = true
        location.overScrollMode = WebView.OVER_SCROLL_NEVER
        location.loadUrl("file:////android_asset/location.html")
    }
}
