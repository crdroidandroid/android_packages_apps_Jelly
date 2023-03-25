/*
 * SPDX-FileCopyrightText: 2020 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.jelly.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StringRes
import org.lineageos.jelly.R

class KeyValueView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {
    private val keyView by lazy { findViewById<TextView>(R.id.key) }
    private val valueView by lazy { findViewById<TextView>(R.id.value) }

    init {
        View.inflate(context, R.layout.key_value_view, this)
    }

    fun setText(@StringRes attributeTextResId: Int, value: String) {
        if (value.isNotEmpty()) {
            keyView.setText(attributeTextResId)
            valueView.text = value
        } else {
            visibility = View.GONE
        }
    }
}
