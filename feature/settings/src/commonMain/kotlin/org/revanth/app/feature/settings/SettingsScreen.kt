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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.revanth.app.core.designsystem.component.RevanthScaffold
import org.revanth.app.feature.settings.components.SettingsDialog

@Composable
internal fun SettingsScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var showDialog by remember {
        mutableStateOf(false)
    }
    SettingsScreenContent(
        modifier = modifier.fillMaxSize(),
        onAction = {
            when(it)
            {
                SettingsAction.AboutUs -> TODO()
                is SettingsAction.ChangeDarkThemeConfig -> TODO()
                SettingsAction.DismissThemeDialog -> TODO()
                SettingsAction.Github -> TODO()
                SettingsAction.NavigateBack -> onBackClick
                SettingsAction.NavigateToEditProfile -> TODO()
                SettingsAction.ShowThemeDialog -> {showDialog=true}
            }
        }
    )
    if(showDialog)
    {
        SettingsDialog(
            onDismiss = {
                showDialog=false
            },
            onChange = {}
        )
    }
}




@Composable
internal fun SettingsScreenContent(
    modifier: Modifier = Modifier,
    onAction: (SettingsAction) -> Unit,
) {
    RevanthScaffold(
        topBarTitle = "Settings",
        backPress = { onAction(SettingsAction.NavigateBack) },
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier.weight(2f, true),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                SettingsOption.entries.forEach { option ->
                    SettingsScreenCard(
                        item = option,
                        modifier = Modifier,
                        onClick = onAction,
                    )
                }
            }

            SettingsScreenFooter(
                modifier = Modifier
                    .align(Alignment.End),
            )
        }
    }
}

@Composable
private fun SettingsScreenCard(
    item: SettingsOption,
    modifier: Modifier = Modifier,
    onClick: (SettingsAction) -> Unit,
) {
    OutlinedCard(
        modifier = modifier.fillMaxWidth(),
        onClick = {
            onClick(item.action)
        },
        shape = RoundedCornerShape(6.dp),
    ) {
        ListItem(
            headlineContent = {
                Text(text = item.title)
            },
            supportingContent = item.description?.let {
                { Text(text = it) }
            },
            leadingContent = {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            MaterialTheme.colorScheme.surfaceContainer,
                            CircleShape,
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = item.leadingIcon,
                        contentDescription = "LeadingIcon",
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            },
            trailingContent = {
                Icon(
                    imageVector = item.trailingIcon,
                    contentDescription = "TrailingIcon",
                )
            },
        )
    }
}

@Composable
fun SettingsScreenFooter(
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TextDivider(text = "Leetos")
        Text(text = "Developed with ❤️ by")
        Text(text = "Revanth Kumar J", fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun TextDivider(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    fontWeight: FontWeight = FontWeight.SemiBold,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        HorizontalDivider(
            modifier = Modifier
                .weight(0.5f, true),
        )

        Text(
            text = text,
            style = textStyle,
            fontWeight = fontWeight,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(2f),
        )

        HorizontalDivider(
            modifier = Modifier
                .weight(0.5f, true),
        )
    }
}

