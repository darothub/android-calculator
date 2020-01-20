package com.example.calculatoritex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var collector:ArrayList<String>
    var operationSign = false
    var results:Any = 0
    lateinit var operationBox:ArrayList<String>
    var counts = 0
    lateinit var present:String
    lateinit var previous:String
    lateinit var  currentOperation:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        collector = ArrayList()
        operationBox = ArrayList()




        if(collector.isEmpty() && display.text.toString() !=""){
            collector.add(display.text.toString())
        }
        else{
            display.setText("0")
            display.doOnTextChanged { text, start, count, after ->

//                Toast.makeText(applicationContext, "count "+count.toString(), Toast.LENGTH_SHORT).show()
            }
        }







    }


    override fun onStart() {
        super.onStart()

        display.requestFocus()

        clickResponseforNumbers(oneBtn, display, "1")
        clickResponseforNumbers(twoBtn, display, "2")
        clickResponseforNumbers(threeBtn, display, "3")
        clickResponseforNumbers(fourBtn, display, "4")
        clickResponseforNumbers(fiveBtn, display, "5")
        clickResponseforNumbers(sixBtn, display, "6")
        clickResponseforNumbers(sevenBtn, display, "7")
        clickResponseforNumbers(eightBtn, display, "8")
        clickResponseforNumbers(nineBtn, display, "9")
        clickResponseforNumbers(zeroBtn, display, "0")
        clickResponseforNumbers(dotBtn, display, ".")
//        clickResponseforNumbers(dotBtn, display, ".")


        btnClickListener(plusBtn, subtractBtn, multBtn, divisionBtn, modBtn,dotBtn, acBtn, equalsToBtn )


        plusOrMinusBtn.setOnClickListener {
            collector.add(display.text.toString())
            val num = collector.last()
            val concat = "-$num"
            display.setText(concat)
        }

    }

    private fun clickResponseforNumbers(view: View, display:EditText, response:String){

        view.setOnClickListener {
            if(operationSign) {
                display.setText(response)
                operationSign = false
            } else {
                display.append(response)
            }
//                firstNum = display.text.toString()
//                collector.add(firstNum)
//                Toast.makeText(applicationContext, "first ${collector.first()}", Toast.LENGTH_SHORT).show()
        }


    }
//
    private fun clickResponseForOperators(view: View){

        when(view){
            plusBtn ->{
//                Toast.makeText(applicationContext, "counterbfr $counts", Toast.LENGTH_SHORT).show()
//                Toast.makeText(applicationContext, "lastbfr ${collector.last()}", Toast.LENGTH_SHORT).show()
                try {
                    collector.add(display.text.toString())
                    operationBox.add(collector.last())

                    if(counts == 0){

                        counts++
                        currentOperation = "addition"
                    }
                    else if(counts > 0){
                        present = display.text.toString()
                        previous = operationBox[0]
                        results = operationBox[0].toFloat() + present.toFloat()
                        display.setText("$results")
    //                    Toast.makeText(applicationContext, "pres $present", Toast.LENGTH_SHORT).show()

                        operationBox.clear()
                        counts = 0

                    }


                    operationSign = true
                } catch (e: Exception) {
                    Toast.makeText(applicationContext, "error ${e.message}", Toast.LENGTH_SHORT).show()
                }


            }

            subtractBtn ->{

                try {
                    collector.add(display.text.toString())
                    operationBox.add(collector.last())

                    if(counts == 0){

                        counts++
                        currentOperation = "subtraction"
                    }
                    else if(counts > 0){
                        var present = display.text.toString().toFloat()
                        results = operationBox[0].toFloat() - present
                        display.setText("$results")
                        Toast.makeText(applicationContext, "pres $present", Toast.LENGTH_SHORT).show()

                        operationBox.clear()
                        counts = 0

                    }


                    operationSign = true
                } catch (e: Exception) {
                    Toast.makeText(applicationContext, "error ${e.message}", Toast.LENGTH_SHORT).show()
                }

            }

            multBtn ->{
                try {
                    collector.add(display.text.toString())
                    operationBox.add(collector.last())

                    if(counts == 0){

                        counts++
                        currentOperation = "multiplication"
                    }
                    else if(counts > 0){
                        var present = display.text.toString().toFloat()
                        results = operationBox[0].toFloat() * present
                        display.setText("$results")
                        Toast.makeText(applicationContext, "pres $present", Toast.LENGTH_SHORT).show()

                        operationBox.clear()
                        counts = 0

                    }



                    operationSign = true
                } catch (e: Exception) {
                    Toast.makeText(applicationContext, "error ${e.message}", Toast.LENGTH_SHORT).show()
                }
//                collector.add(display.text.toString())
//                display.setText(collector[0])
//                operationSign = true
//                Toast.makeText(applicationContext, operationBox[0], Toast.LENGTH_SHORT).show()

            }
            divisionBtn ->{
                try {
                    collector.add(display.text.toString())
                    operationBox.add(collector.last())

                    if(counts == 0){

                        counts++
                        currentOperation = "division"
                    }
                    else if(counts > 0){
                        var present = display.text.toString().toFloat()
                        results = operationBox[0].toFloat() / present
                        display.setText("$results")
                        Toast.makeText(applicationContext, "pres $present", Toast.LENGTH_SHORT).show()

                        operationBox.clear()
                        counts = 0

                    }

                    operationSign = true
                } catch (e: Exception) {
                    Toast.makeText(applicationContext, "error ${e.message}", Toast.LENGTH_SHORT).show()
                }
//                collector.add(display.text.toString())
//                display.setText(collector[0])
//                operationSign = true
//                Toast.makeText(applicationContext, operationBox[0], Toast.LENGTH_SHORT).show()

            }
            modBtn ->{
                try {
                    collector.add(display.text.toString())
                    operationBox.add(collector.last())

                    if(counts == 0){

                        counts++
                        currentOperation = "modulus"
                    }
                    else if(counts > 0){
                        var present = display.text.toString().toFloat()
                        results = operationBox[0].toFloat() % present
                        display.setText("$results")
                        Toast.makeText(applicationContext, "pres $present", Toast.LENGTH_SHORT).show()

                        operationBox.clear()
                        counts = 0

                    }

                    operationSign = true
                } catch (e: Exception) {
                    Toast.makeText(applicationContext, "error ${e.message}", Toast.LENGTH_SHORT).show()
                }
//                collector.add(display.text.toString())
//                display.setText(collector[0])
//                operationSign = true
//                Toast.makeText(applicationContext, operationBox[0], Toast.LENGTH_SHORT).show()

            }
//            dotBtn ->{
////                operationBox.add(display.text.toString())
//                try {
//                    if(display.text.toString().isEmpty()){
//                      display.setText("0")
//                    }
//
//                    collector.add(display.text.toString())
//                    operationBox.add(collector.last())
//
//
//                    if(counts == 0){
//
//                        counts++
//                        currentOperation = "dot"
//
//                    }
//                    else if(counts > 0){
//                        var present = display.text.toString().toFloat()
//                        results = operationBox[0].toFloat() + present / 10
//                        display.setText("$results")
//                        Toast.makeText(applicationContext, "pres $present", Toast.LENGTH_SHORT).show()
//
//                        operationBox.clear()
//                        counts = 0
//
//                    }
//                } catch (e: Exception) {
//                    Toast.makeText(applicationContext, "error ${e.message}", Toast.LENGTH_SHORT).show()
//                }
////                Toast.makeText(applicationContext, operationBox[0], Toast.LENGTH_SHORT).show()
//
//            }
            equalsToBtn ->{
                if(counts > 0 && currentOperation == "addition"){
                    present = display.text.toString()
                    previous = operationBox[0]
                    previous.instantResult("plus", present)

//                    results = operationBox[0].toFloat() + present.toInt()
                }
                else if(counts > 0 && currentOperation == "subtraction"){
                    present = display.text.toString()
                    previous = operationBox[0]
                    previous.instantResult("minus", present)
                }
                else if(counts > 0 && currentOperation == "multiplication"){
                    present = display.text.toString()
                    previous = operationBox[0]
                    previous.instantResult("times", present)
                }
                else if(counts > 0 && currentOperation == "division"){
                    present = display.text.toString()
                    previous = operationBox[0]
                    previous.instantResult("divide", present)
                }
                else if(counts > 0 && currentOperation == "modulus"){
                    present = display.text.toString()
                    previous = operationBox[0]
                    previous.instantResult("mod", present)
                }
                operationSign = true
            }


//                    Toast.makeText(applicationContext, "$result", Toast.LENGTH_SHORT).show()

            acBtn ->{

                resetOperationBox()
                resetDisplay()

            }


        }
    }

    private fun resetDisplay(){
        display.setText("")

    }
    private fun resetOperationBox():Boolean{
        collector.clear()
        operationSign = false

//        Toast.makeText(applicationContext, "${collector.size}", Toast.LENGTH_SHORT).show()
        return true
    }


    private fun btnClickListener(vararg views:View){
        for (view in views){
            view.setOnClickListener {
                clickResponseForOperators(it)
            }
        }
    }

    private fun String.instantResult(operation:String, other:String?=null):Any{

        if(operation == "plus"){
            try {
                results = this.toFloat() + other?.toFloat()!!
                display.setText("$results")
//            Toast.makeText(applicationContext, "pres $present", Toast.LENGTH_SHORT).show()

                operationBox.clear()
                counts = 0
            }catch (e:Exception){
                Toast.makeText(applicationContext, "error ${e.message}", Toast.LENGTH_SHORT).show()
            }

        }
        else if(operation == "minus"){
            try{
                results = this.toFloat() - other?.toFloat()!!
                display.setText("$results")
//            Toast.makeText(applicationContext, "res $results", Toast.LENGTH_SHORT).show()
                operationBox.clear()
                counts = 0
            } catch (e:Exception){
                Toast.makeText(applicationContext, "error ${e.message}", Toast.LENGTH_SHORT).show()
            }

        }
        else if(operation == "times"){
            try{
                results = this.toFloat() * other?.toFloat()!!
                display.setText("$results")
//            Toast.makeText(applicationContext, "res $results", Toast.LENGTH_SHORT).show()
                operationBox.clear()
                counts = 0
            }
            catch (e:Exception){
                Toast.makeText(applicationContext, "error ${e.message}", Toast.LENGTH_SHORT).show()
            }

        }

        else if(operation == "divide"){
            try {
                results = this.toFloat() / other?.toFloat()!!
                display.setText("$results")
//            Toast.makeText(applicationContext, "res $results", Toast.LENGTH_SHORT).show()
                operationBox.clear()
                counts = 0
            }
            catch (e:Exception){
                Toast.makeText(applicationContext, "error ${e.message}", Toast.LENGTH_SHORT).show()
            }

        }
        else if(operation == "mod"){
            try{
                results = this.toFloat() % other?.toFloat()!!
                display.setText("$results")
//            Toast.makeText(applicationContext, "res $results", Toast.LENGTH_SHORT).show()
                operationBox.clear()
                counts = 0
            }
            catch (e:Exception){
                Toast.makeText(applicationContext, "error ${e.message}", Toast.LENGTH_SHORT).show()
            }

        }
        return results

    }
}


//results = 0
//if(operation == "add"){
//    if(results != 0){
//        display.setText("$results")
//    }else{
//        temp += operationBox.last().toInt()
//        results = temp
//        display.setText("$results")
//        operationBox.clear()
//    }
//
//
//}
//else if(operation == "minus"){
//    display.setText(operationBox.last())
//    val d = display.text.toString()
//
//    var newNum = operationBox[1].toInt()
//    Toast.makeText(applicationContext, operationBox[1], Toast.LENGTH_SHORT).show()
//    results = newNum - d.toInt()
//
//    Toast.makeText(applicationContext, "sec: $newNum", Toast.LENGTH_SHORT).show()
//
//    if(results != 0){
//        operationBox[1] = "$results"
//        display.setText("$results")
//    }
//
////            val newNum = operationBox.last().toInt()
////            temp = newNum
////            result = temp
////            display.setText("$result")
////            operationBox.clear()
//
//}
//else if(operation == "times"){
//    val firstNum = operationBox[0].toInt()
//    val secondNum = operationBox[1].toInt()
//    results = firstNum * secondNum
//    display.setText("$results")
//}
//else if(operation == "divide"){
//    operationBox.add(display.text.toString())
//    val firstNum = operationBox[0].toFloat()
//    val secondNum = operationBox[1].toFloat()
//    val resultFloat = firstNum / secondNum
//    display.setText("${resultFloat}")
//
//}
//else if(operation == "modulus"){
//    operationBox.add(display.text.toString())
//    val firstNum = operationBox[0].toInt()
//    val secondNum = operationBox[1].toInt()
//    results = firstNum % secondNum
//    display.setText("$results")
//    justFinishedAnOperation = true
//}
//equalsToBtn.setOnClickListener {
//    instantResult(operation)
//}
