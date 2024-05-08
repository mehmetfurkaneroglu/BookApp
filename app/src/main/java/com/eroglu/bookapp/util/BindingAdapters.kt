package com.eroglu.bookapp.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

object BindingAdapters {

    @JvmStatic
    @BindingAdapter(value = ["loadImage"], requireAll = false)
    fun loadImage(view: ImageView, url: String?) {
        safeLet(url, view.context) { _url, context ->
            Glide.with(context)
                .load("$_url")
                .placeholder(android.R.color.darker_gray)
                .apply(
                    RequestOptions().transform(
                        MultiTransformation(
                            CenterCrop(),
                            RoundedCorners(5)
                        )
                    )
                )
                .into(view)

        }
    }

    @JvmStatic
    @BindingAdapter(value = ["isBackButton"])
    fun isBackButton(view: View,isBackButton: Boolean){
        if (isBackButton) {
            view.setOnClickListener{
                Navigation.findNavController(view).popBackStack()
            }
        }
    }

}