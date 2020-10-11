package com.example.passwordstrengthkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import java.util.regex.Pattern

// Simple example to demonstrate password strength
// for login using TextWatcher
class MainActivity : AppCompatActivity() {

    private lateinit var mET_Password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mET_Password = findViewById(R.id.et_password)
        mET_Password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enterPassword(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    private fun enterPassword(password: String) {
        val tv_maximum: TextView = findViewById(R.id.tv_maximum)
        val tv_special: TextView = findViewById(R.id.tv_special)
        val tv_number: TextView = findViewById(R.id.tv_number)
        val tv_upper: TextView = findViewById(R.id.tv_upper)
        val tv_lower: TextView = findViewById(R.id.tv_lower)
        if (!(password.length <= 8)) {
            tv_maximum.setTextColor(Color.GREEN)
        } else {
            tv_maximum.setTextColor(Color.RED)
        }
        if (isSpecial(password)) {
            tv_special.setTextColor(Color.GREEN)
        } else {
            tv_special.setTextColor(Color.RED)
        }
        if (isNumber(password)) {
            tv_number.setTextColor(Color.GREEN)
        } else {
            tv_number.setTextColor(Color.RED)
        }
        if (isNumber(password)) {
            tv_number.setTextColor(Color.GREEN)
        } else {
            tv_number.setTextColor(Color.RED)
        }
        if (isUpperCase(password)) {
            tv_upper.setTextColor(Color.GREEN)
        } else {
            tv_upper.setTextColor(Color.RED)
        }
        if (isLowerCase(password)) {
            tv_lower.setTextColor(Color.GREEN)
        } else {
            tv_lower.setTextColor(Color.RED)
        }
    }

    // Used to validate password
    // See https://stackoverflow.com/questions/36574183/how-to-validate-password-field-in-android
    // See https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a
    private fun isSpecial(s: String): Boolean {
        val p: Pattern = Pattern.compile("(?=.*[@$!%*#?&])[A-Za-z \\d@$!%*#?&]*")
        return !TextUtils.isEmpty(s) && p.matcher(s).matches()
    }

    private fun isNumber(s: String): Boolean {
        val p: Pattern = Pattern.compile("(?=.*\\d)[A-Za-z \\d@$!%*#?&]*")
        return !TextUtils.isEmpty(s) && p.matcher(s).matches()
    }

    private fun isUpperCase(s: String): Boolean {
        val p: Pattern = Pattern.compile("(?=.*[A-Z])[A-Za-z \\d@$!%*#?&]*")
        return !TextUtils.isEmpty(s) && p.matcher(s).matches()
    }

    private fun isLowerCase(s: String): Boolean {
        val p: Pattern = Pattern.compile("(?=.*[a-z])[A-Za-z \\d@$!%*#?&]*")
        return !TextUtils.isEmpty(s) && p.matcher(s).matches()
    }


}