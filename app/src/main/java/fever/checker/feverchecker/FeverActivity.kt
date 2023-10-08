package fever.checker.feverchecker

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.NumberPicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlin.math.absoluteValue

class FeverActivity : AppCompatActivity() {

    private lateinit var txtNumber: NumberPicker

    private lateinit var btnSubmit: Button

    private lateinit var cheHypothermia: CheckBox
    private lateinit var cheNormal: CheckBox
    private lateinit var cheHigh: CheckBox

    private lateinit var lblHypothermia: TextView
    private lateinit var lblNormal: TextView
    private lateinit var lblHigh: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fever)

        txtNumber = findViewById(R.id.txtNumber)
        cheHypothermia = findViewById(R.id.cheHypothermia)
        lblHypothermia = findViewById(R.id.lblHypothermia)
        cheHigh = findViewById(R.id.chehigh)
        lblHigh = findViewById(R.id.lblHigh)
        cheNormal = findViewById(R.id.cheNormal)
        lblNormal = findViewById(R.id.lblNormal)

        txtNumber.minValue = 0
        txtNumber.maxValue = 100

        txtNumber.setOnValueChangedListener { _, _, newVal ->

            cheHigh.isVisible = true
            lblHigh.isVisible = true
            cheNormal.isVisible = true
            lblNormal.isVisible = true
            cheHypothermia.isVisible = true
            lblHypothermia.isVisible = true

            findViewById<Button>(R.id.HbtnSubmit).setOnClickListener {
                val numHypothermia = 35
                val numHigh = 38
                var txtNumber: Int = txtNumber.value
                txtNumber = newVal

                if (txtNumber <= numHypothermia) {
                    cheHigh.isVisible = false
                    lblHigh.isVisible = false
                    cheNormal.isVisible = false
                    lblNormal.isVisible = false
                }
                if (numHigh <= txtNumber) {
                    cheHypothermia.isVisible = false
                    lblHypothermia.isVisible = false
                    cheNormal.isVisible = false
                    lblNormal.isVisible = false
                }
                if (txtNumber == 36 || txtNumber == 37) {
                    lblHigh.isVisible = false
                    cheHigh.isVisible = false
                    cheHypothermia.isVisible = false
                    lblHypothermia.isVisible = false
                }
            }

        }
    }
}