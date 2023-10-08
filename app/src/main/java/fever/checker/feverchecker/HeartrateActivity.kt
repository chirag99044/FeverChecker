package fever.checker.feverchecker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible

class HeartrateActivity : AppCompatActivity() {

    private lateinit var HeartRateImage: ImageView
    private lateinit var txtHeartrate: EditText
    private lateinit var Result: TextView
    private lateinit var LastLinearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heartrate)
        HeartRateImage = findViewById(R.id.HeartRateImage)
        val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.pulse)
        HeartRateImage.startAnimation(animationFadeIn)

        txtHeartrate = findViewById(R.id.txtHeartrate)
        Result = findViewById(R.id.Result)
        Result.isVisible = false
        LastLinearLayout = findViewById(R.id.LastLinearLayout)

        findViewById<Button>(R.id.btnCheck).setOnClickListener {
        Result.isVisible = true
        txtHeartrate.text.isNotEmpty().apply { Result.text = "Edit text is Empty" }
        val result =  txtHeartrate.text.toString().toInt()
        val low: Int = 70
        val normal: Int = 80
        val high: Int = 90

        if (70 > result)
        {
            Result.text = "Heartrate is Low"
            LastLinearLayout.setBackgroundColor(Color.BLUE)
            Result.setTextColor(Color.WHITE)
        }
        else if (result >= low && result <= normal)
        {
            Result.text = "HeartRate is Normal"
            LastLinearLayout.setBackgroundColor(Color.GREEN)
            Result.setTextColor(Color.WHITE)
        }
        if (result >= high) {
            Result.text = "HeartRate is High"
            LastLinearLayout.setBackgroundColor(Color.RED)
            Result.setTextColor(Color.WHITE)
        }
        }
    }
}