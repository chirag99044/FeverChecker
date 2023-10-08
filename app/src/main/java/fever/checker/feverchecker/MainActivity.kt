package fever.checker.feverchecker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

           findViewById<CardView>(R.id.Fever).setOnClickListener {
               startActivity(Intent(this,FeverActivity::class.java))
            }

            findViewById<CardView>(R.id.Weight).setOnClickListener {
                startActivity(Intent(this,WeightActivity::class.java))
            }

            findViewById<CardView>(R.id.HeartRate).setOnClickListener {
                startActivity(Intent(this,HeartrateActivity::class.java))
            }

            findViewById<CardView>(R.id.spo2).setOnClickListener {
                startActivity(Intent(this,spo2Activity::class.java))
            }

            findViewById<CardView>(R.id.PrivicePolicy).setOnClickListener {
                startActivity(Intent(this,PrivicypolicyActivity::class.java))
            }

            findViewById<CardView>(R.id.Explore).setOnClickListener {
                startActivity(Intent(this,ExploreActivity::class.java))
            }

    }
}