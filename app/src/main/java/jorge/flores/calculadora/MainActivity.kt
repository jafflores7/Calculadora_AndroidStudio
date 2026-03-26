package jorge.flores.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var campo_num1: EditText
    lateinit var campo_num2: EditText
    lateinit var btn_sumar: Button
    lateinit var btn_restar: Button
    lateinit var btn_multiplicar: Button
    lateinit var btn_dividir: Button
    lateinit var tv_resp: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        campo_num1 = findViewById(R.id.campo_num)
        campo_num2 = findViewById(R.id.campo_num2)

        btn_sumar = findViewById(R.id.boton_sumar)
        btn_restar = findViewById(R.id.boton_restar)
        btn_multiplicar = findViewById(R.id.boton_multiplicar)
        btn_dividir = findViewById(R.id.boton_dividir)

        tv_resp = findViewById(R.id.tv_resp)


        btn_sumar.setOnClickListener {
            var num1 = campo_num1.text.toString().toDouble()
            var num2 = campo_num2.text.toString().toDouble()

            var res = num1 + num2
            tv_resp.setText("${res}")

        }

        btn_restar.setOnClickListener {
            var num1 = campo_num1.text.toString().toDouble()
            var num2 = campo_num2.text.toString().toDouble()

            var res = num1 - num2
            tv_resp.setText("${res}")
        }

        btn_multiplicar.setOnClickListener {
            var num1 = campo_num1.text.toString().toDouble()
            var num2 = campo_num2.text.toString().toDouble()

            var res = num1 * num2
            tv_resp.setText("${res}")
        }

        btn_dividir.setOnClickListener {
            var num1 = campo_num1.text.toString().toDouble()
            var num2 = campo_num2.text.toString().toDouble()

            if (num2 == 0.0){
                Toast.makeText(this, "Cant Divide by 0", Toast.LENGTH_SHORT).show()
            }
            else {
                var res = num1 / num2
                tv_resp.setText("${res}")
            }
        }
    }
}