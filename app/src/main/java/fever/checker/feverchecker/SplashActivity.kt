package fever.checker.feverchecker

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var imglogo: ImageView
    private lateinit var lblname: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lblname = findViewById(R.id.lblName)
        imglogo = findViewById(R.id.imglogo)
        progressBar = findViewById(R.id.progressBar)

        imglogo.visibility = View.INVISIBLE
        lblname.visibility = View.INVISIBLE
        progressBar.visibility = View.INVISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            val fade: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
            lblname.startAnimation(fade)
            imglogo.startAnimation(fade)
            lblname.visibility = View.VISIBLE
            imglogo.visibility = View.VISIBLE
        }, 1000)

        Handler(Looper.getMainLooper()).postDelayed({
            progressBar.visibility = View.VISIBLE
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },2000)
    }
}