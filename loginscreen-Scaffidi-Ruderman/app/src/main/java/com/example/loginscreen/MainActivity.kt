package com.example.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.loginscreen.entities.User
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val userList: MutableList<User> = mutableListOf(
        User("agus", "Agus4321"),
        User("manu", "manu4321"),
        User("admin", "Admin4321")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userEditText: EditText = findViewById(R.id.editUser)
        val passEditText: EditText = findViewById(R.id.editPass)
        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val username: String = userEditText.text.toString()
            val password: String = passEditText.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                showSnackbar("Por favor inserte su nombre y constraseña")
            } else {
                val isValidUser = checkUserCredentials(username, password)
                if (isValidUser) {
                    showSnackbar("Inicio de sesión exitoso")
                } else {
                    showSnackbar("El usuario y la contraseña no coinciden")
                }
            }
        }
    }

    private fun checkUserCredentials(username: String, password: String): Boolean {
        for (user in userList) {
            if (user.username == username && user.pass == password) {
                return true
            }
        }
        return false
    }

    private fun showSnackbar(message: String) {
        val snackbar = Snackbar.make(
            findViewById<View>(android.R.id.content),
            message,
            Snackbar.LENGTH_SHORT
        )
        snackbar.show()
    }

}