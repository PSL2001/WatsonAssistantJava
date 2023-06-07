package com.example.watsonassistantdemo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.watsonassistantdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        webViewSetup()
    }

    private fun webViewSetup() {
        binding.webView.webViewClient = MyWebViewClient()
        binding.webView.apply {
            WebView.setWebContentsDebuggingEnabled(true)
            try {
                loadUrl("https://psl2001.github.io/WatsonAssistantJava/")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            settings.javaScriptEnabled = true
            settings.allowFileAccess = true
            settings.safeBrowsingEnabled = true
            binding.webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    private inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            return false;
        }


        override fun onPageFinished(view: WebView, url: String) {
            // Aquí puedes realizar acciones después de que la página se haya cargado completamente
            // Por ejemplo, mostrar un mensaje o realizar alguna operación en función de la URL cargada
            try {
                if (url == "file:///android_asset/index.html") {
                    println("Página cargada")
                    // La página index.html ha cargado completamente
                    // Realiza las acciones necesarias aquí
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            super.onPageFinished(view, url)
        }
    }

}