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
import kotlinx.coroutines.launch

val AppScope = CoroutineScope(window.asCoroutineDispatcher())

class App : Application() {
    override fun start() {
        root("kvapp") {
            AppScope.launch {
                if (localStorage.getItem("password") == Config.getPassword())
                    add(CPanel())
                else
                    add(LoginManager())
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
