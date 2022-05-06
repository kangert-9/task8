package com.example.task3.navigation

import com.example.task3.mvpuser.TranslateScreen
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward

class OpenDeepLink(private val deepLinkUserId: String) : CustomRouter.Command, Command {

    override fun execute(navigator: CustomNavigator) {
        navigator.applyCommand(Forward(TranslateScreen(deepLinkUserId)))
    }
}