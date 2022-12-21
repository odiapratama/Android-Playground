package com.playground.core.utils

import java.lang.Thread.UncaughtExceptionHandler
import kotlin.system.exitProcess

class CrashHandler private constructor(
    private val defaultHandler: UncaughtExceptionHandler,
    private val action: (Throwable) -> Unit
) : UncaughtExceptionHandler {

    companion object {
        fun initialize(
            action: (Throwable) -> Unit
        ) {
            Thread.setDefaultUncaughtExceptionHandler(
                CrashHandler(
                    Thread.getDefaultUncaughtExceptionHandler() as UncaughtExceptionHandler,
                    action
                )
            )
        }
    }

    override fun uncaughtException(p0: Thread, p1: Throwable) {
        try {
            action(p1)
            exitProcess(0)
        } catch (e: Exception) {
            defaultHandler.uncaughtException(p0, p1)
        }
    }
}