package com.khoirullatif.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.khoirullatif.barvolume.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
// dengan ViewBinding
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

// ini tanpa menggunakan viewbinding
//    private lateinit var edtWidth: EditText
//    private lateinit var edtHeight: EditText
//    private lateinit var edtLength: EditText
//    private lateinit var btnCalculate: Button
//    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflate Activity nya pun beda ketika menggunakan viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        edtWidth = findViewById(R.id.edt_width)
//        edtHeight = findViewById(R.id.edt_height)
//        edtLength = findViewById(R.id.edt_length)
//        btnCalculate = findViewById(R.id.btn_calculate)
//        tvResult = findViewById(R.id.tv_result)

        //MENGGUNAKAN BUNDLE
//        if (savedInstanceState != null) {
//            val result = savedInstanceState.getString(STATE_RESULT)
//            binding.tvResult.text = result
//        }

        //MENGGUNAKAN VIEWMODEL
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        binding.btnCalculate.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_calculate) {
            val inputWidth = binding.edtWidth.text.toString().trim()
            val inputHeight = binding.edtHeight.text.toString().trim()
            val inputLength = binding.edtLength.text.toString().trim()

            var isEmptyField = false

            if (inputWidth.isEmpty()) {
                isEmptyField = true
                binding.edtWidth.error = "Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyField = true
                binding.edtHeight.error = "Field ini tidak boleh kosong"
            }
            if (inputLength.isEmpty()) {
                isEmptyField = true
                binding.edtLength.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyField) {
                viewModel.calculate(inputWidth, inputHeight, inputLength)
                displayResult()
            }

        }
    }

    private fun displayResult() {
        binding.tvResult.text = viewModel.result.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //MENGGUNAKAN BUNDLE
//        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
    }
}