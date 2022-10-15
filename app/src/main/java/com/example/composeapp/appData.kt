package com.example.composeapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

    data class appData(
        @StringRes val stringResourceId: Int,
        @DrawableRes val imageId: Int,
        //@StringRes val linkId:Int
    )
