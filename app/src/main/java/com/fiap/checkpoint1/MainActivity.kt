import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fiap.checkpoint1.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    @override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            val heightText = heightEditText.text.toString()

            if (selectedRadioButtonId == -1) {
                Toast.makeText(this, "Por favor, selecione o sexo", Toast.LENGTH_SHORT).show()
            } else if (heightText.isEmpty()) {
                Toast.makeText(this, "Por favor, insira a altura", Toast.LENGTH_SHORT).show()
            } else {
                val height = heightText.toFloat()
                val weight = when (selectedRadioButtonId) {
                    R.id.radioButtonMale -> (72.7 * height) - 58
                    R.id.radioButtonFemale -> (62.1 * height) - 44.7
                    else -> 0.0
                }
                Toast.makeText(this, "Peso ideal: ${"%.2f".format(weight)} kg", Toast.LENGTH_SHORT).show()
            }
        }
    }

    annotation class override
}
