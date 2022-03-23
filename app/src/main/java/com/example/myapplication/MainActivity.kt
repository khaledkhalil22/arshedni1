package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.content.Intent



class MainActivity : AppCompatActivity() {
    var buttonlog: Button? = null
    var emaill: EditText? = null
    var pass2: EditText? = null
    var gotoregestarpage:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        connectItem()
        login()
        //checkfield()
        gotoregpage()
    }

    private fun gotoregpage() {
        gotoregestarpage?.setOnClickListener {
            var i =Intent(this,regester::class.java)
            startActivity(i)}

    }

    //لربط الid بالمتغير للوصول اليه
    private fun connectItem() {
        buttonlog = findViewById(R.id.button1)
        emaill = findViewById(R.id.email)
        pass2 = findViewById(R.id.password)
        gotoregestarpage=findViewById(R.id.register)

    }

    private fun login() {
        var arr: ArrayList<User> = ArrayList()
        arr.add(User("6", "7"))
        arr.add(User("khal@gmail.com", "123456"))
        arr.add(User("khale@gmail.com", "123457"))
        buttonlog?.setOnClickListener {
            val username = emaill?.text.toString()
            val password = pass2?.text.toString()
            val user = User(username, password)
            for (userArray in arr) {
                if (userArray.email == user.email && userArray.password == user.password) {
                    Toast.makeText(this, "success to log  ${user.email}", Toast.LENGTH_LONG).show()
                    finish()
                    val i = Intent(this, MainActivity2::class.java)
                    i.putExtra("username", userArray.email)
                    startActivity(i)

                    break
                } else {
                    Toast.makeText(this, "faild to log", Toast.LENGTH_SHORT).show()
                    break

                }


            }
        }
    }


    /*private fun checkfield() {
        buttonlog?.setOnClickListener {
            if (emaill?.text?.isEmpty() == true ) {
                emaill?.setError("Enter your Email")

            } else if(pass2?.text?.isEmpty() == true) {
                pass2?.setError("enter your password")


            }

     */



        }











