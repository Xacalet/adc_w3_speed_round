/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

object MySootheRepository {

    val favoriteCollectionItems: List<Item> =
        listOf(
            Item("Short mantras", R.drawable.image_short_mantras),
            Item("Nature meditations", R.drawable.image_nature_meditations),
            Item("Stress and anxiety", R.drawable.image_stress_and_anxiety),
            Item("Self-massage", R.drawable.image_self_massage),
            Item("Overwhelmed", R.drawable.image_overhelmed),
            Item("Nightly wind down", R.drawable.image_nightly_wind_down)
        )

    val alignYourBodyItems: List<Item> =
        listOf(
            Item("Inversions", R.drawable.image_inversions),
            Item("Quick yoga", R.drawable.image_quck_yoga),
            Item("Stretching", R.drawable.image_stretchings),
            Item("Tabata", R.drawable.image_tabata),
            Item("HIIT", R.drawable.image_hiit),
            Item("Pre-natal yoga", R.drawable.image_pre_natal_yoga)
        )

    val alignYourMindItems: List<Item> =
        listOf(
            Item("Meditate", R.drawable.image_meditate),
            Item("With kids", R.drawable.image_with_kids),
            Item("Aromatherapy", R.drawable.image_aromatherapy),
            Item("On the go", R.drawable.image_on_the_go),
            Item("With pets", R.drawable.image_with_pets),
            Item("High stress", R.drawable.image_high_stress)
        )
}
