package com.adgdelhi.jumpstart.utils

import com.squareup.moshi.Moshi

object MoshiProvider {
    fun provide(): Moshi = Moshi.Builder().build()
}