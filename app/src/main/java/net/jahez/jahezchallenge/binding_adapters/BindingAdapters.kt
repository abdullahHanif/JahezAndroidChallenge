package net.jahez.jahezchallenge.binding_adapters

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.chip.ChipGroup

@BindingAdapter(value = ["image_url"])
fun ImageView.loadImage(imageUrl: String?) {
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 3f
    circularProgressDrawable.centerRadius = 15f
    circularProgressDrawable.start()

    Glide.with(context)
        .load(imageUrl ?: "")
        .skipMemoryCache(true)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .thumbnail(0.1f)
        .placeholder(circularProgressDrawable)
        .addListener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                Log.d("BindingAdapter", "unable to load image in view")
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                Log.d("BindingAdapter", "Image ready to load")
                return false
            }

        })
        .into(this)
}


@InverseBindingMethods(InverseBindingMethod(type = ChipGroup::class, attribute = "android:checkedButton", method = "getCheckedChipId"))
class ChipGroupBindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("android:checkedButton")
        fun setCheckedChip(view: ChipGroup?, id: Int) {
            if (id != view?.checkedChipId) {
                view?.check(id)
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["android:onCheckedChanged", "android:checkedButtonAttrChanged"], requireAll = false)
        fun setChipsListeners(view: ChipGroup?, listener: ChipGroup.OnCheckedChangeListener?,
                              attrChange: InverseBindingListener?) {
            if (attrChange == null) {
                view?.setOnCheckedChangeListener(listener)
            } else {
                view?.setOnCheckedChangeListener { group, checkedId ->
                    listener?.onCheckedChanged(group, checkedId)
                    attrChange.onChange()
                }
            }
        }
    }
}