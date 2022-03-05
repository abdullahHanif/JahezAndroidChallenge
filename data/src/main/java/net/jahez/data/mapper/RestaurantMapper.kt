package net.jahez.data.mapper


import net.jahez.data.model.Restaurant
import net.jahez.domain.entity.RestaurantEntity

object RestaurantMapper : Mapper<RestaurantEntity, Restaurant> {

    override fun fromDataToDomainType(from: Restaurant): RestaurantEntity =
        RestaurantEntity(
            from.id,
            from.image,
            from.distance,
            from.hasOffer,
            from.hours,
            from.image,
            from.name,
            from.offer,
            from.rating
        )


    override fun fromDomainToDataType(to: RestaurantEntity): Restaurant =
        Restaurant(
            to.id,
            to.image,
            to.distance,
            to.hasOffer,
            to.hours,
            to.image,
            to.name,
            to.offer,
            to.rating
        )
}