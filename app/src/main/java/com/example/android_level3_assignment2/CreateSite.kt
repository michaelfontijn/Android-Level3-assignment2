package com.example.android_level3_assignment2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_level3_assignment2.models.Site
import kotlinx.android.synthetic.main.activity_create_site.*

const val ADDED_SITE = "ADDED_SITE"

class CreateSite : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_site)

        //add the onclick listener to the button
        btnCreateSite.setOnClickListener{
            onSaveClick()
        }
    }

    private fun onSaveClick(){
        //perform basic validation
        if(etTitle.text.isNullOrBlank() || etUrl.text.isNullOrBlank()){
            Toast.makeText(this, "Please fill in all the inputs", Toast.LENGTH_SHORT).show()
        }

        //create a site object
        var site = Site(etTitle.text.toString(),etUrl.text.toString())

        //create the intent
        var resultIntent = Intent()
        resultIntent.putExtra(ADDED_SITE, site)

        //set / return the result of the activity
        setResult(Activity.RESULT_OK, resultIntent)

        //remove it from back_stack (so back button wont go back here)
        finish()
    }
}
