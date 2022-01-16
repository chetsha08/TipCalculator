package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    var billAmount:Int = 0
    var selection:Float = 0F
    var tip:Double = 0.0
    var timeTak = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{ calculateTip()}
    }

    private fun calculateTip() {
        billAmount = binding.editText.text.toString().toIntOrNull()!!
        if (binding.editText.text.toString().isNotEmpty()){
            selection = when(binding.radioGroup.checkedRadioButtonId){
                R.id.fsatisfied-> 0.2F
                R.id.satisfied-> 0.15F
                R.id.nsatis-> 0.1F
                else-> 0.01F
            }
            tip = (billAmount*selection).toDouble()
            if (binding.switc.isChecked){
                tip = kotlin.math.ceil(tip)
            }
            binding.amount.text = "Tip :- $tip"
        }
    }

    override fun onBackPressed() {
        if (timeTak + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
        }
        else{
            Toast.makeText(this,"back again to exit",Toast.LENGTH_SHORT).show()
        }
        timeTak = System.currentTimeMillis()
    }
}