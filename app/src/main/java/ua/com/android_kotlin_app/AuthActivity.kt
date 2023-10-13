package ua.com.android_kotlin_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)


        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPassword: EditText = findViewById(R.id.user_password_auth)
        val authButton: Button = findViewById(R.id.button_auth)
        val linkToReg :TextView = findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        authButton.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val pass = userPassword.text.toString().trim()


            if (login == "" || pass == "")
                Toast.makeText(this, "You need fill in all!", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this,null)

                val isAuth =  db.getUser(login, pass)

                if (isAuth){
                    print(isAuth)
                    Toast.makeText(this, "User with Login:   auth in app", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPassword.text.clear()

                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                }else
                    Toast.makeText(this, "User with Login:  $login DIDN'T auth in app", Toast.LENGTH_LONG).show()



            }

        }

    }
}