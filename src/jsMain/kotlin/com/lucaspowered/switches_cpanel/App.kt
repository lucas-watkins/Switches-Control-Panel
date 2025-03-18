package com.lucaspowered.switches_cpanel

import io.kvision.Application
import io.kvision.CoreModule
import io.kvision.BootstrapModule
import io.kvision.BootstrapCssModule
import kotlinx.browser.localStorage
import kotlinx.browser.window
import io.kvision.module
import io.kvision.panel.root
import io.kvision.startApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher

val AppScope = CoroutineScope(window.asCoroutineDispatcher())

class App : Application() {
    override fun start() {
        root("kvapp") {
            if (localStorage.getItem("loggedIn") == "true")
                add(CPanel())
            else
                add(LoginManager())
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
