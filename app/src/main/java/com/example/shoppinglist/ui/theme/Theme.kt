package com.example.shoppinglist.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Light Theme
private val LightColorScheme = lightColorScheme(
    primary = BlueLight,
    onPrimary = BlueLightOn,
    primaryContainer = BlueLight.copy(alpha = 0.6f),
    onPrimaryContainer = BlueLightOn,

    secondary = PinkLight,
    secondaryContainer = PinkLight.copy(alpha = 0.6f),
    onSecondaryContainer = PinkLightOn,

    background = LightBackground,
    onBackground = LightOnBackground,

    surface = LightSurface,
    onSurface = LightOnSurface
)

// Dark Theme
private val DarkColorScheme = darkColorScheme(
    primary = BlueDark,
    onPrimary = BlueDarkOn,
    primaryContainer = BlueDark.copy(alpha = 0.8f),
    onPrimaryContainer = BlueDarkOn,

    secondary = PinkDark,
    secondaryContainer = PinkDark.copy(alpha = 0.8f),
    onSecondaryContainer = PinkDarkOn,

    background = DarkBackground,
    onBackground = DarkOnBackground,

    surface = DarkSurface,
    onSurface = DarkOnSurface
)

@Composable
fun ShoppingListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Bisa kamu aktifkan jika ingin adaptif warna Android 12+
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
