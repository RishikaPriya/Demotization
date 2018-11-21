package vote.demotization.com.demotization

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    var webView: WebView? = null
    var mainUrl: String = "https://docs.google.com/forms/d/e/1FAIpQLSc7rQXoTJh02-2ZoCPhAbQXylEgfI8gdT6HGGh1YxP0Hz-C7w/viewform";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById<WebView>(R.id.webView)
        webView!!.settings!!.javaScriptEnabled = true
        webView!!.webViewClient = myWebViewClient()

        webView!!.loadUrl(mainUrl)
    }

    private inner class myWebViewClient : WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            if(url!!.toLowerCase().contains("formresponse")){
                webView!!.loadUrl(mainUrl)
            }
        }
    }
}
