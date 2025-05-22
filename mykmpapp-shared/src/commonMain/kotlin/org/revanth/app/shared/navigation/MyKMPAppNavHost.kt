/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See See https://github.com/openMF/kmp-project-template/blob/main/LICENSE
 */
package org.revanth.app.shared.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.revanth.app.feature.home.HOME_ROUTE
import org.revanth.app.feature.home.homeScreen
import org.revanth.app.feature.profile.profileScreen
import org.revanth.app.feature.settings.notificationScreen
import org.revanth.app.feature.settings.settingsScreen
import org.revanth.app.shared.ui.MyKMPAppState

@Composable
internal fun MyKMPAppNavHost(
    appState: MyKMPAppState,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController

    NavHost(
        route = MyKMPAppNavGraph.MAIN_GRAPH,
        startDestination = HOME_ROUTE,
        navController = navController,
        modifier = modifier,
    ) {
        homeScreen()

        profileScreen()

        settingsScreen(
            onBackClick = navController::popBackStack,
        )

        notificationScreen(
            onBackClick = navController::popBackStack,
        )
    }
}
