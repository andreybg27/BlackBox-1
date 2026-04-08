package top.niunaijun.blackboxa.view.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import top.niunaijun.blackboxa.databinding.ActivityMainBinding
import top.niunaijun.blackboxa.util.inflate

class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by inflate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        if (!Settings.canDrawOverlays(this)) {
            val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))
            startActivity(intent)
        } else {
            // ТУК ЩЕ СЕ ИЗВИКА ФУНКЦИЯТА ЗА ЛИНИИТЕ
            startAimLines()
        }
    }

    private fun startAimLines() {
        // Директно активиране на визуалния компонент
        // Ако PredictorView.java съществува, ще работи тук
    }
}
