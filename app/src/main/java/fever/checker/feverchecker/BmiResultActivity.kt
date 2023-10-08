package fever.checker.feverchecker

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BmiResultActivity : AppCompatActivity() {

    private lateinit var recalculateBMI: Button
    private lateinit var displayBMI: TextView
    private lateinit var genderDisplay: TextView
    private lateinit var statusDisplay: TextView
    private lateinit var mimageview: ImageView
    private lateinit var mBMI: String
    private var intBMI = 0f
    private lateinit var height: String
    private lateinit var weight: String
    private var intweight = 0f
    private var intheight = 0f
    private lateinit var Background: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_result)

        intent = intent
        recalculateBMI = findViewById(R.id.recalculateBMI)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        displayBMI = findViewById(R.id.displayBMI)
        genderDisplay = findViewById(R.id.genderDisplay)
        statusDisplay = findViewById(R.id.statusDisplay)
        mimageview = findViewById(R.id.imageViewOk)
        Background = findViewById(R.id.contentLayout)
        height = intent.getStringExtra("height").toString()
        weight = intent.getStringExtra("weight").toString()
        intheight = height.toFloat()
        intweight = weight.toFloat()
        intheight /= 100
        intBMI = intweight / (intheight * intheight)
        mBMI = intBMI.toString()
        if (intBMI < 16) {
            statusDisplay.text = "Severe Thinness"
            Background.setBackgroundColor(Color.RED)
            mimageview.setImageResource(R.drawable.crosss)
        } else if (intBMI < 16.9 && intBMI >= 16) {
            statusDisplay.text = "Moderate Thinness"
            Background.setBackgroundColor(Color.RED)
            mimageview.setImageResource(R.drawable.crosss)
        } else if (intBMI < 18.4 && intBMI >= 17) {
            statusDisplay.text = "Mild Thinness"
            Background.setBackgroundColor(Color.RED)
            mimageview.setImageResource(R.drawable.warning)
        } else if (intBMI < 25 && intBMI >= 18.4) {
            statusDisplay.text = "Normal"
            Background.setBackgroundColor(Color.YELLOW)
            mimageview.setImageResource(R.drawable.ok)
        } else if (intBMI < 29.4 && intBMI >= 25) {
            statusDisplay.text = "Overweight Thinness"
            Background.setBackgroundColor(Color.RED)
            mimageview.setImageResource(R.drawable.warning)
        } else {
            statusDisplay.text = "Obesity"
            Background.setBackgroundColor(Color.RED)
            mimageview.setImageResource(R.drawable.crosss)
        }
        genderDisplay.text = intent.getStringExtra("gender")
        displayBMI.text = mBMI
        recalculateBMI.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@BmiResultActivity, WeightActivity::class.java)
            startActivity(intent)
            finish()
        })

    }
}