package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {
    private var Bottomnavi:BottomNavigationView?=null
    private var FrameLayout:FrameLayout?=null
    private var drawerlayout: DrawerLayout?=null
    private var toolbarview: Toolbar?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        connectviews()
        setSupportActionBar(toolbarview)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val toggle = ActionBarDrawerToggle(this,drawerlayout,R.string.open,R.string.close)
        drawerlayout?.addDrawerListener(toggle)
        toggle.syncState()


        Bottomnaviclick()
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home->{
                drawerlayout?.openDrawer(GravityCompat.START)
                true
            }
            else->true
        }

    }


    private fun connectviews(){
        Bottomnavi=findViewById(R.id.bottomnav)
        FrameLayout=findViewById(R.id.frameco)
        drawerlayout=findViewById(R.id.drawer)
        toolbarview=findViewById(R.id.Toolbar)
    }
    private fun Bottomnaviclick(){
        Bottomnavi?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.addquestion ->{
                    choosefragment(addquespage(),"addquestion")
                }
                R.id.officehoure ->{
                    choosefragment(officeFragment(),"officehouers")
                }
                R.id.profile ->{
                    choosefragment(profileFragment(),"profile")
                }

            }
           true
        }
    }
    private fun choosefragment(fragment:Fragment,tag:String){
        val FragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        FragmentTransaction.replace(R.id.frameco,fragment,tag)
        FragmentTransaction.addToBackStack(tag)
        FragmentTransaction.commit()
    }
}