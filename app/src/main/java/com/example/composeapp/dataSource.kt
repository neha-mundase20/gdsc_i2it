package com.example.composeapp

class dataSource {
    fun loadData(): List<appData> {
        return listOf<appData>(
            appData(R.string.card_1,R.drawable.app_development/*,R.string.link_1*/),
            appData(R.string.card_2,R.drawable.web_development/*,R.string.link_2*/),
            appData(R.string.card_3,R.drawable.cloud_computing_image/*,R.string.link_3*/),
            appData(R.string.card_4,R.drawable.machine_learning/*,R.string.link_4*/)
        )
    }
}

