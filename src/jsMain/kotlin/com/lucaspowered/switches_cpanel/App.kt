package com.lucaspowered.switches_cpanel

import io.kvision.Application
import io.kvision.CoreModule
import io.kvision.BootstrapModule
import io.kvision.BootstrapCssModule
import io.kvision.core.Color
import io.kvision.html.label
import kotlinx.browser.localStorage
import kotlinx.browser.window
import io.kvision.module
import io.kvision.panel.root
import io.kvision.startApplication
import io.kvision.utils.px
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch

val AppScope = CoroutineScope(window.asCoroutineDispatcher())

class App : Application() {
    override fun start() {
        root("kvapp") {
            AppScope.launch {
                if (!Config.configHasErrors()) {
                    if (localStorage.getItem("password") == Config.getPassword())
                        add(CPanel())
                    else
                        add(LoginManager())
                } else {
                    add(
                        label("Configuration Error: Please check your configuration file")
                        {
                            fontSize = 32.px
                            color = Color.rgb(255, 0, 0)
                        }
                    )
                }
            }
        }
    }
}

fun main() {
    startApplication(
        ::App,
        module.hot,
        BootstrapModule,
        BootstrapCssModule,
        CoreModule
    )
}
