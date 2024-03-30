package com.project.liceriabakery.utils

import com.project.liceriabakery.data.entity.MainEntity

object InitialData {

    fun listBakery(): List<MainEntity>{
        return listOf(
            MainEntity(
                1,
                "Bakery Apple Pie",
                "50",
                "Rp 8.000/pcs",
                "img_1"
            ),
            MainEntity(
                2,
                "Bakery Marmer Cake",
                "100",
                "Rp 32.000/pcs",
                "img_2"
            ),
            MainEntity(
                3,
                "Bakery Chiffon Meises",
                "100",
                "Rp 35.000/pcs",
                "img_3"
            ),
            MainEntity(
                4,
                "Bakery Kadet Susu",
                "20",
                "Rp 17.500/pcs",
                "img_4"
            ),
            MainEntity(
                5,
                "akery Lapis Mandarin Pandan",
                "25",
                "Rp 24.500/pcs",
                "img_5"
            ),
            MainEntity(
                6,
                "Bakery Muffin Coklat",
                "100",
                "Rp 7.000/pcs",
                "img_6"
            )
        )
    }
}