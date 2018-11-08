package com.sorted.pro.activity

import android.app.Notification
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import assure.mw.com.interfaces.OnFragmentInteractionListener
import com.sorted.pro.R
import com.sorted.pro.animation.RoundImage
import com.sorted.pro.fragement.*
import com.sorted.pro.model.RatingModel
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.app_bar_choice.*
import kotlinx.android.synthetic.main.nav_header_choice.view.*

class ChoiceActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {
    public var mRatingModelAct:RatingModel?=null
    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        val bm = BitmapFactory.decodeResource(resources, R.drawable.a)
        val roundedImage = RoundImage(bm)
        val header = navigationView.getHeaderView(0)

        val profileImage = header.profileImage_IV as ImageView
        profileImage.setImageDrawable(roundedImage)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.choice, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        var fragment: Fragment? = null
        val id = item.itemId
        when (id) {
            R.id.nav_content -> {
                fragment = ContentFragment()
            }
            R.id.nav_result -> {
                fragment = ResultFragment()

            }
            R.id.nav_notification -> {
                fragment = NotificationFragment()

            }
            R.id.nav_rate -> {
                fragment = RateFragment()
            }
            R.id.nav_profile -> {
                fragment = ProfileFragment()

            }
            R.id.nav_contact_us -> {
                fragment = ContactusFragment()

            }
        }
        if (fragment != null) {
            var fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();


        }
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
