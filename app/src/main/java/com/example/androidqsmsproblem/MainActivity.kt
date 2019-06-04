package com.example.androidqsmsproblem

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Telephony
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

@RequiresApi(Build.VERSION_CODES.M)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT)
            intent.putExtra(
                Telephony.Sms.Intents.EXTRA_PACKAGE_NAME,
                "com.example.androidqsmsproblem"
            )
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT)
            intent.putExtra(
                Telephony.Sms.Intents.EXTRA_PACKAGE_NAME,
                "com.google.android.apps.messaging"
            )
            startActivity(intent)
        }
        button3.setOnClickListener {
            requestPermissions(
                arrayOf(
                    Manifest.permission.READ_SMS,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ), 1
            )
        }

    }
}
