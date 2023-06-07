package com.example.watsonassistantdemo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.watsonassistantdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /**
     * Binding para la vista principal
     * @see ActivityMainBinding (Android)
     * @see AppCompatActivity (Android)
     * @see onCreate (Android)
     */
    lateinit var binding: ActivityMainBinding

    /**
     * Método que se ejecuta al iniciar la aplicación
     * @see onCreate (Android)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Se crea la vista
        super.onCreate(savedInstanceState)
        // Se asigna la vista al binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Se asigna la vista al activity usando el binding
        setContentView(binding.root)
        // Se ejecuta el método para configurar el WebView
        webViewSetup()
    }

    /**
     * Método para configurar el WebView
     * @see webViewSetup (Android)
     * @see WebView (Android)
     * @see WebViewClient (Android)
     *
     */
    private fun webViewSetup() {
        // Se asigna el WebViewClient al WebView
        binding.webView.webViewClient = MyWebViewClient()
        // Se aplican las configuraciones al WebView
        binding.webView.apply {
            // Se habilita el modo de depuración, para poder ver los errores en la consola Logcat
            WebView.setWebContentsDebuggingEnabled(true)
            // Se carga la URL del proyecto de GitHub
            try {
                loadUrl("https://psl2001.github.io/WatsonAssistantJava/")
            } catch (e: Exception) {
                // Si ocurre un error, se imprime en la consola Logcat
                e.printStackTrace()
            }
            // Se habilita el JavaScript, necesario para que funcione el chatbot de Watson
            settings.javaScriptEnabled = true
            // Se habilita safe browsing, para que no se puedan abrir páginas maliciosas. No es necesario, pero es recomendable
            settings.safeBrowsingEnabled = true
            // Se habilita el modo de mezcla de contenido, para que se puedan cargar páginas HTTP en páginas HTTPS.
            // Aunque la pagina del chabot es HTTPS, es posible que en otros casos se necesite cargar por HTTP
            binding.webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
    }

    /**
     * Método para sobreescribir el botón de retroceso
     * @see onBackPressed (Android)
     * @see WebView (Android)
     * @see Deprecated (Deprecated in Java)
     */
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    /**
     * Clase para sobreescribir el WebViewClient
     * @see MyWebViewClient (Android)
     * @see WebViewClient (Android)
     */
    private inner class MyWebViewClient : WebViewClient() {
        /**
         * Método para sobreescribir la carga de una URL
         * @see shouldOverrideUrlLoading (Android)
         * @see WebView (Android)
         * @see WebResourceRequest (Android)
         */
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            // Retorna falso para que se cargue la URL
            return false
        }
    }

}