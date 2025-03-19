package com.lucaspowered.switches_cpanel

import io.kvision.form.*
import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.html.label
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.utils.px
import kotlinx.browser.localStorage
import com.lucaspowered.switches_cpanel.jsutils.reloadPage
import kotlinx.coroutines.launch
import kotlinx.browser.window

class LoginManager : Drawable() {

    override fun draw() {

        paddingTop = (window.innerHeight / 5).px
        paddingLeft = (window.innerWidth / 3).px
        paddingRight = (window.innerWidth / 3).px
        paddingBottom = (window.innerHeight / 5).px

        label("Switches Login") {
            fontSize = 36.px
            paddingBottom = 10.px
        }

        formPanel<Login> {
            add(
                Login::username,
                Text(label = "Username"),
                required = true,
                requiredMessage = "Please enter your username"
            )

            add(
                Login::password,
                Password(label = "Password"),
                required = true,
                requiredMessage = "Please enter your password",
            )

            button("Submit", style = ButtonStyle.PRIMARY).onClick {
                val user = this@formPanel[Login::username]!!
                val password = this@formPanel[Login::password]!!

                AppScope.launch {
                    if (user == Config.getUsername() && password == Config.getPassword()) {
                        localStorage.setItem("password", password)
                        reloadPage()
                    } else {
                        js("alert('invalid login')")
                    }
                }
            }
        }
    }
}