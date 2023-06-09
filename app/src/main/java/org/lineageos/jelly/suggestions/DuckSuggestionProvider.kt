/*
 * SPDX-FileCopyrightText: 2020 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.jelly.suggestions

import org.json.JSONArray

/**
 * The search suggestions provider for the DuckDuckGo search engine.
 */
internal class DuckSuggestionProvider : SuggestionProvider("UTF-8") {
    override fun createQueryUrl(
        query: String,
        language: String
    ) = "https://duckduckgo.com/ac/?q=$query"

    override fun parseResults(
        content: String,
        callback: ResultCallback
    ) {
        val jsonArray = JSONArray(content)
        val size = jsonArray.length()
        for (n in 0 until size) {
            val obj = jsonArray.getJSONObject(n)
            val suggestion = obj.getString("phrase")
            if (!callback.addResult(suggestion)) {
                break
            }
        }
    }
}
