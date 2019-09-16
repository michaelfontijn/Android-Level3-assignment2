package com.example.android_level3_assignment2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_level3_assignment2.adapters.SiteAdapter
import com.example.android_level3_assignment2.models.Site

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

const val CREATE_SITE_REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {

    private val sites = arrayListOf<Site>()
    private val siteAdapter = SiteAdapter(sites)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            startAddActivity()
        }
    }

    private fun initViews(){
        //Initialize the recycler view with a linear layout manager adapter.
        rvSites.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)

        //set our adapter to the recyclerView on the activity(screen)
        rvSites.adapter = siteAdapter

        //add a vertical divider (line/ border) at the bottom of the items in the collection
        rvSites.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
    }


    /**
     * Starts a new create_site_activity expecting a result back
     */
    private fun startAddActivity(){
        val intent = Intent(this, CreateSite::class.java)

        //start the activity and pass a unique code to the activity we can later use to fetch the result
        startActivityForResult(intent, CREATE_SITE_REQUEST_CODE)
    }

    //This method is called when a result is retrieved from another activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //check if th result was successful
        if (resultCode == Activity.RESULT_OK) {
            //search the matching request code (the on we used when making the intent
            when (requestCode) {
                //when we find a match we know for which intent this result is (in case we have made multiple)
                CREATE_SITE_REQUEST_CODE -> {
                    //retrieve / parse the reminder object from the response and add it to the recyclerView.
                    val reminder = data!!.getParcelableExtra<Site>(ADDED_SITE)
                    sites.add(reminder)
                    siteAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}
