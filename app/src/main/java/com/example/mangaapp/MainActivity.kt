package com.example.mangaapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.vishnusivadas.advanced_httpurlconnection.PutData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signUp.setOnClickListener {
            signUp.background = resources.getDrawable(R.drawable.stwich_trcks, null)
            signUp.setTextColor(resources.getColor(R.color.textColor,null))
            Login.background = null
            signUpLayout.visibility = View.VISIBLE
            LogInLayout.visibility = View.GONE
            Login.setTextColor(resources.getColor(R.color.black))
        }

        Login.setOnClickListener {
            Login.background = resources.getDrawable(R.drawable.stwich_trcks, null)
            Login.setTextColor(resources.getColor(R.color.textColor,null))
            signUp.background = null
            signUpLayout.visibility = View.GONE
            LogInLayout.visibility = View.VISIBLE
            signUp.setTextColor(resources.getColor(R.color.black))
        }

        signIn.setOnClickListener {
            if(LogInLayout.visibility == View.VISIBLE && signUpLayout.visibility == View.GONE){
                val handler:Handler = Handler(Looper.getMainLooper())
                handler.post(Runnable() {
                    fun run() {
                        var tk : String = eMail.text.toString()
                        var mk : String = passwords.text.toString()

                        var field = arrayOf<String>("username","password")
                        var data = arrayOf<String>(tk,mk)

                        val putData : PutData = PutData("http://10.170.9.155/webservice/LogIn-SignUp-master/login.php", "POST",field,data)
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                var result : String = putData.result
                                if(result.equals("Login Success")){
                                    val intent : Intent = Intent(this@MainActivity, TrangChu::class.java)
                                    startActivity(intent)
                                }
                                else{
                                    Toast.makeText(this,"Tài khoản hoặc mật khẩu không chính xác!",Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    }
                    run()
                })
            }
            if(LogInLayout.visibility == View.GONE && signUpLayout.visibility == View.VISIBLE){
                val handler:Handler = Handler(Looper.getMainLooper())
                handler.post(Runnable() {
                    fun run() {
                        var tk : String = eMails.text.toString()
                        var mk : String = passwordss.text.toString()
                        var mkcf : String = passwords01.text.toString()

                        if(mk == mkcf){
                            var field = arrayOf<String>("username","password")
                            var data = arrayOf<String>(tk,mk)

                            val putData : PutData = PutData("http://10.170.9.155/webservice/LogIn-SignUp-master/signup.php", "POST",field,data)
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    var result : String = putData.result
                                    Toast.makeText(this,result.toString(),Toast.LENGTH_LONG).show()
                                    if(result.equals("Sign Up Success")){
                                        Toast.makeText(this,"Đăng ký tài khoản thành công!",Toast.LENGTH_LONG).show()
                                        signUpLayout.visibility = View.GONE
                                        LogInLayout.visibility = View.VISIBLE
                                    }
                                }
                            }
                        }
                        else {
                            Toast.makeText(this, "Mật khẩu xác nhận không khớp!", Toast.LENGTH_LONG).show()
                        }
                    }
                    run()
                })
            }
        }
    }
}