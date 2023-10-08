package fever.checker.feverchecker

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.NumberPicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible

class spo2Activity : AppCompatActivity() {

    private lateinit var btnspo2Dialog: Button
    private lateinit var dialogNumberPicker: NumberPicker
    private lateinit var Result: TextView
    private lateinit var LastLinearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spo2)

        Result = findViewById(R.id.ResultSpo2)
        Result.isVisible = false
        LastLinearLayout = findViewById(R.id.Spo2LinearLayout)
        btnspo2Dialog = findViewById<Button?>(R.id.btnspo2Dialog).also {
            it.setOnClickListener {
                show()
            }
        }
    }
    private fun show() {
        var result : Int
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.number_picker_dialog)
        dialogNumberPicker = dialog.findViewById(R.id.dialogNumberPicker)
        dialogNumberPicker.minValue = 0
        dialogNumberPicker.maxValue = 100
        val submit = dialog.findViewById(R.id.submit) as Button
        submit.setOnClickListener {
            result = dialogNumberPicker.value
            dialog.dismiss()
            val low: Int = 90
            val normal: Int = 100
            Result.isVisible = true
            if (low > result) {
                Result.text = "Low Oxygen"
                LastLinearLayout.setBackgroundColor(Color.RED)
                Result.setTextColor(Color.WHITE)
            } else if (result >= low && result <= normal) {
                Result.text = "Normal Oxygen"
                LastLinearLayout.setBackgroundColor(Color.GREEN)
                Result.setTextColor(Color.WHITE)
            }
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.show()
    }
}