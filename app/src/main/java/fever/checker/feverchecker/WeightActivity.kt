package fever.checker.feverchecker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.core.content.ContextCompat

class WeightActivity : AppCompatActivity() {

    private lateinit var currentHeight: TextView
    private lateinit var ageNumeric: TextView
    private lateinit var weightNumeric: TextView
    private lateinit var weightPlus: ImageView
    private lateinit var weightMinus: ImageView
    private lateinit var agePlus: ImageView
    private lateinit var ageMinus: ImageView
    private lateinit var seekbarHeight: SeekBar
    private lateinit var male: RelativeLayout
    private lateinit var female: RelativeLayout
    private  var constWeight = 55
    private  var constAge = 23
    private  var currentProgress = 0
    private var mintProgress = "170"
    private var typeOfUser = "0"
    private var weight = "55"
    private var age2 = "22"
    private lateinit var calculateBMI: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        calculateBMI = findViewById(R.id.calculateBMI)
        ageNumeric = findViewById(R.id.ageNumeric)
        weightNumeric = findViewById(R.id.weightNumeric)
        currentHeight = findViewById(R.id.currentHeight)
        agePlus = findViewById(R.id.agePlus)
        ageMinus = findViewById(R.id.ageMinus)
        weightPlus = findViewById(R.id.weightPlus)
        weightMinus = findViewById(R.id.weightMinus)
        ageNumeric = findViewById(R.id.ageNumeric)
        seekbarHeight = findViewById(R.id.seekbarHeight)
        male = findViewById(R.id.male)
        female = findViewById(R.id.female)

        male.setOnClickListener(View.OnClickListener {
            male.background = ContextCompat.getDrawable(
                applicationContext,
                R.drawable.malefemalefocus
            )
            female.background = ContextCompat.getDrawable(
                applicationContext,
                R.drawable.malefemalenotfocus
            )
            typeOfUser = "Male"
        })
        female.setOnClickListener(View.OnClickListener {
            female.background = ContextCompat.getDrawable(
                applicationContext,
                R.drawable.malefemalefocus
            )
            male.background = ContextCompat.getDrawable(
                applicationContext,
                R.drawable.malefemalenotfocus
            )
            typeOfUser = "Female"
        })
        seekbarHeight.max = 300
        seekbarHeight.progress = 160
        seekbarHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                currentProgress = i
                mintProgress = currentProgress.toString()
                currentHeight.text = mintProgress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        //For Add button
        agePlus.setOnClickListener(View.OnClickListener {
            if (constAge <= 100) {
                constAge += 1
            }
            ageNumeric.text = constAge.toString()
        })
        weightPlus.setOnClickListener(View.OnClickListener {
            if (constWeight <= 200) {
                constWeight += 1
            }
            weightNumeric.text = constWeight.toString()
        })

        //For Minus Button
        ageMinus.setOnClickListener(View.OnClickListener {
            if (constAge > 1) {
                constAge -= 1
            }
            ageNumeric.text = constAge.toString()
        })
        weightMinus.setOnClickListener(View.OnClickListener {
            if (constWeight > 1) {
                constWeight -= 1
            }
            weightNumeric.text = constWeight.toString()
        })
        calculateBMI.setOnClickListener(View.OnClickListener {
            if (typeOfUser == "0") {
                Toast.makeText(applicationContext, "Select Your Gender First", Toast.LENGTH_SHORT)
                    .show()
            } else if (mintProgress == "0") {
                Toast.makeText(applicationContext, "Select Your Height First", Toast.LENGTH_SHORT)
                    .show()
            } else if (constAge <= 0) {
                Toast.makeText(applicationContext, "Age is incorrect", Toast.LENGTH_SHORT).show()
            } else if (constWeight <= 0) {
                Toast.makeText(applicationContext, "Weight is incorrect", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@WeightActivity, BmiResultActivity::class.java)
                intent.putExtra("gender", typeOfUser)
                intent.putExtra("height", mintProgress)
                intent.putExtra("weight", weight)
                intent.putExtra("age", age2)
                intent.putExtra("gender", typeOfUser)
                intent.putExtra("gender", typeOfUser)
                startActivity(intent)
                finish()
            }
        })
    }
}