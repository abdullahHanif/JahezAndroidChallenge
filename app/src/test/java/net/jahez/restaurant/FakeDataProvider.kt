package net.jahez.restaurant

import net.jahez.domain.entity.RestaurantEntity

object FakeDataProvider {
    fun getRestaurant() = listOf<RestaurantEntity>(
        RestaurantEntity(
            1,
            "Enjoy fast delivery from Jahez. Order now, or schedule your order any time you want",
            1.5690683590005408,
            true,
            "11:30 AM - 02:00 AM",
            "https://jahez-other-oniiphi8.s3.eu-central-1.amazonaws.com/2.jpg",
            "Shawarma Classic",
            "9 Ø±ÙŠØ§Ù„",
            8.0
        ),
        RestaurantEntity(
            2,
            "Enjoy fast delivery from Jahez. Order now, or schedule your order any time you want",
            1.123412312,
            false,
            "11:30 AM - 02:00 AM",
            "https://jahez-other-oniiphi8.s3.eu-central-1.amazonaws.com/2.jpg",
            "Shawarma Classic",
            null,
            5.0
        ),RestaurantEntity(
            3,
            "Enjoy fast delivery from Jahez. Order now, or schedule your order any time you want",
            0.5,
            false,
            "11:30 AM - 02:00 AM",
            "https://jahez-other-oniiphi8.s3.eu-central-1.amazonaws.com/2.jpg",
            "Shawarma Classic",
            null,
            4.0
        )


    )
}


