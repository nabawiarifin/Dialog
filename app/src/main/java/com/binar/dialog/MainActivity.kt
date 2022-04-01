package com.binar.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: 1. AlertDialog Standard
//        val standardButton: Button = findViewById(R.id.standard_button)
//        standardButton.setOnClickListener{
//            val dialog = AlertDialog.Builder(this)
//            dialog.setTitle("Dialog Cancelable")
//            dialog.setMessage("Dialog Cancelable can be close by clicking outside")
//            dialog.setCancelable(true)
//            dialog.show()
//        }


//

        //TODO: 2. AlertDialog with Action Button
        val actionButton: Button = findViewById(R.id.action_button)
        actionButton.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog with Button")
            dialog.setMessage("Dialog with Button and Actions")
            dialog.setIcon(R.mipmap.ic_launcher_round)

            dialog.setCancelable(false)
            dialog.setPositiveButton("Positive Button"){dialogInterface, pl ->
                Toast.makeText(this,"Positive Button Clicked", Toast.LENGTH_SHORT).show()
            }

            dialog.setNegativeButton("Negative Button"){dialogInterface,pl ->
                Toast.makeText(this,"Negative button Clicked", Toast.LENGTH_SHORT).show()
            }

            dialog.setNeutralButton("Neural Button"){dialogInterface,pl ->
                Toast.makeText(this,"Neural button Clicked", Toast.LENGTH_SHORT).show()
            }

            dialog.show()
        }
//

        //TODO: 3. Alert Dialog with Custom Layout

        val customDialogButton: Button = findViewById(R.id.custom_dialog_button)

        customDialogButton.setOnClickListener {

            val view = LayoutInflater.from(this).inflate(R.layout.alert_dialog,null,false)
            val closeButton: Button = view.findViewById(R.id.close_button)
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setView(view)
            val dialog = dialogBuilder.create()

            closeButton.setOnClickListener {
                Toast.makeText(this,"Custom dialog closed", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }

            dialog.show()
        }

        //TODO: 4. Alert Dialog Fragment
        val fragmentDialogButton: Button = findViewById(R.id.fragment_dialog_button)
        fragmentDialogButton.setOnClickListener {
            val alertDialogFragment = AlertDialogFragment()
            alertDialogFragment.show(supportFragmentManager,"tag")
        }

    }

}