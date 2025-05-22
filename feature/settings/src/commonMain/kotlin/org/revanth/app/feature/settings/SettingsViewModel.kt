/*
 * Copyright 2025 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See See https://github.com/openMF/kmp-project-template/blob/main/LICENSE
 */
package org.revanth.app.feature.settings

import androidx.compose.ui.graphics.vector.ImageVector
import org.revanth.app.core.designsystem.icon.AppIcons
import org.revanth.app.model.Theme

enum class SettingsOption(
    val title: String,
    val description: String?,
    val leadingIcon: ImageVector,
    val trailingIcon: ImageVector = AppIcons.ArrowForward,
    val action: SettingsAction,
) {
    CHANGE_THEME(
        title = "Change Theme",
        description = null,
        leadingIcon = AppIcons.Sun,
        action = SettingsAction.ShowThemeDialog,
    ),
    EDIT_PROFILE(
        title = "Edit Profile",
        description = null,
        leadingIcon = AppIcons.Profile,
        action = SettingsAction.NavigateToEditProfile,
    ),
    GITHUB(
        title = "Github",
        description = null,
        leadingIcon = AppIcons.Github,
        action = SettingsAction.Github,
    ),
    ABOUT_US(
        title = "About Us",
        description = null,
        leadingIcon = AppIcons.AboutUs,
        action = SettingsAction.AboutUs,
    ),
}

sealed interface SettingsAction {
    data object NavigateBack : SettingsAction
    data object NavigateToEditProfile : SettingsAction
    data object ShowThemeDialog : SettingsAction
    data object AboutUs : SettingsAction
    data object Github : SettingsAction
    data object DismissThemeDialog : SettingsAction
    data class ChangeDarkThemeConfig(val darkThemeConfig: Theme) : SettingsAction
}
