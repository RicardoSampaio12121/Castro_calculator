package com.ricardo.castro_calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private val text_view: TextView by lazy {findViewById<TextView>(R.id.main_textview_text) as TextView}
    private val btn_add: Button by lazy {findViewById<Button>(R.id.main_button_sum) as Button}
    private val btn_div: Button by lazy {findViewById<Button>(R.id.main_button_division) as Button}
    private val btn_sub : Button by lazy {findViewById<Button>(R.id.main_button_subtraction) as Button}
    private val btn_mul : Button by lazy {findViewById<Button>(R.id.main_button_multiplication) as Button}

    private var firstNumber : Float? = null
    private var secondNumber : Int = 0
    private var operation : String = "Sum"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /*fun getOperation(view: View){
        // vou buscar a tag do butão
        val add = btn_add.tag.toString()
        val div = btn_div.tag.toString()
        val sub = btn_sub.tag.toString()
        val mul = btn_mul.tag.toString()

        return
    }*/

    // mas o onCLick() não consegue devolve um resultado!
//    fun doSum(val1: String, val2: String): Int {
//        return "${val1.toInt() + val2.toInt()}".toInt()
//    }
//
//    fun doSubtraction(val1: String, val2: String): Int {
//        return "${val1.toInt() - val2.toInt()}".toInt();
//    }
//
//    fun doMultiplication(val1: String, val2: String): Int {
//        return "${val1.toInt() * val2.toInt()}".toInt();
//    }
//
//    fun doDivision(val1: String, val2: String): Float {
//        // se for feita uma divisão por 0, é enviada uma notificação a dizer que não se pode dividir por 0
//        if(val2 == "0"){
//            Toast.makeText(this@MainActivity, "Nao pode fazer divisões por zero", Toast.LENGTH_LONG)
//        }
//        return "${val1.toInt() * val2.toInt()}".toFloat();
//    }

     fun calculateNumber(operation: String): Float{
        when(operation){
            "Sum" -> return (firstNumber!! + secondNumber).toFloat()
            "Sub" -> return (firstNumber!! - secondNumber).toFloat()
            "Div" -> return (firstNumber!! / secondNumber).toFloat() //TODO: Verificar divisao por 0
            "Mul" -> return (firstNumber!! * secondNumber).toFloat()
        }
        return 0F
    }


    fun buttonNumberClickEvent(view: View){
        val value = view.tag.toString().toInt()

        if(firstNumber == null){
            firstNumber = value.toFloat()

            text_view.text = firstNumber.toString()
        }
        else{
            secondNumber = value

            var calculatedNumber = calculateNumber(operation)
            firstNumber = calculatedNumber

            text_view.text = "$firstNumber"

            //Toast.makeText(this, "${calculatedNumber}", Toast.LENGTH_SHORT).show()
        }
    }

    // função para receber todos os butões - apartir da tag
    fun getOperation(view: View){
        // recebo uma view - vou lhe buscar a tag e passo para string - vou buscar a tag do botão que foi clicado
//        val button_tag = view.tag.toString()
//        val text = text_view.text.toString()
//        val sum = btn_add.tag.toString()
//        val sub = btn_sub.tag.toString()
//        val div = btn_div.tag.toString()
//        val mul = btn_mul.tag.toString()

        operation = view.tag.toString()

        when(operation){
            "Sum" -> text_view.text = "${text_view.text } + "
            "Div" -> text_view.text = "${text_view.text } / "
            "Sub" -> text_view.text = "${text_view.text } - "
            "Mul" -> text_view.text = "${text_view.text } * "
        }


//        if (operation == sum){
//            doSum(button_tag, text);
//        } else if (operation == sub) {
//            doSubtraction(button_tag,text);
//        } else if (button_tag == mul) {
//            doMultiplication(button_tag,text)
//        } else if (button_tag == div) {
//            doDivision(button_tag,text)
//        }
    }
}