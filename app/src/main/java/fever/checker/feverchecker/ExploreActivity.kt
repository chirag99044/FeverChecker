package fever.checker.feverchecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import fever.checker.feverchecker.R

class ExploreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)

        val Heading = findViewById<TextView>(R.id.Heading)
        Heading.text = "5 Ways to Tell if Someone Has a Fever Without a Thermometer"

        val Hrading1 = findViewById<TextView>(R.id.Heading1)
        Hrading1.text = "Warm forehead or neck"
        val Description1 = findViewById<TextView>(R.id.Description1)
        Description1.text = "If someone has a fever, they’ll most likely be warm to the touch. Use the back of your hand to gently touch your or your loved one’s forehead and/or neck. Notice the environment around them to make sure they’re not feeling too warm because they’re under blankets or in a hot room. If something may be affecting their temperature, remove it and try again after 30 or so minutes.\n" +
                "Avoid touching the hands and feet to check for a fever, as they can feel cold when body temperature rises or blood circulation is low.\n" +
                "Some people may feel clammy or cool when they have a temperature. If something doesn’t feel normal, it’s probably because they’re sick.\n" +
                "Use fever-reducing over-the-counter medications like Tylenol (acetaminophen) or Advil (ibuprofen) to calm a rising temperature."

        val Hrading2 = findViewById<TextView>(R.id.Heading2)
        Hrading2.text =  "Flushed cheeks"
        val Description2 = findViewById<TextView>(R.id.Description2)
        Description2.text = "A high temperature usually causes a person’s face to turn red. When your body overheats, you’ll begin to look flushed, like you’ve just run a mile or done strenuous exercise. Look in a mirror or closely at your loved one’s face. If they appear redder than usual, they may have a fever.\n" +
                "If you or your loved one have a darker skin tone, this may be more difficult to notice."


        val Hrading3 = findViewById<TextView>(R.id.Heading3)
        Hrading3.text = "Chills and/or sweating"
        val Description3 = findViewById<TextView>(R.id.Description3)
        Description3.text = "The body may involuntarily react to a fluctuating temperature. If someone has a fever, it’s very common for them to shake or sweat. No matter the room’s temperature or what they’re wearing, they’ll react to what they feel on the inside. Notice if you have the chills or feel more sweaty than normal, or watch your loved one closely.\n" +
                "It’s normal to alternate between feeling cold and hot when you have a temperature.\n" +
                "Change into lighter clothing and remove heavy blankets to help calm a fever."

        val Hrading4 = findViewById<TextView>(R.id.Heading4)
        Hrading4.text = "Muscle aches"
        val Description4 = findViewById<TextView>(R.id.Description4)
        Description4.text = "Changes in body temperature can make someone ache. If you or your loved one experience muscle or joint pain, it could be because of a fever. These pains could be sharp or steady, and may be a sign of a cold, the flu, or an infection. Take note if you feel abnormally sore, like you just worked out, or ask your loved one if any part of their body hurts.[5]\n" +
                "Rest, ice packs, warm baths, and over-the-counter pain medications (Tylenol and Advil) can help ease muscle aches when someone has a fever."

        val Hrading5 = findViewById<TextView>(R.id.Heading5)
        Hrading5.text = "Fatigue"
        val Description5 = findViewById<TextView>(R.id.Description5)
        Description5.text = "Fevers can make someone feel lethargic or extremely tired. Perhaps you or your loved one is having trouble staying awake and just wants to lie in bed. Slow movements, abnormal exhaustion, and slow speech could all be a sign of illness.[6]\n" +
                "If a child is sick, they’ll usually say they feel sleepy, rub their eyes more than usual, or throw tantrums.\n" +
                "Resting can give the body energy to fight off a fever."
    }
}