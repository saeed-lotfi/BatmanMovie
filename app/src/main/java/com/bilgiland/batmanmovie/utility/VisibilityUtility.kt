package com.bilgiland.batmanmovie.utility

import android.view.View

fun setVisibility(visibleView: View, goneView: View) {
    goneView.visibility = View.GONE
    visibleView.visibility = View.VISIBLE
}
