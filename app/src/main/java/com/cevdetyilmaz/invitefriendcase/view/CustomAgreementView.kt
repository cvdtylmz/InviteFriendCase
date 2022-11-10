package com.cevdetyilmaz.invitefriendcase.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.cevdetyilmaz.invitefriendcase.R
import com.cevdetyilmaz.invitefriendcase.databinding.LayoutAgreementBoxBinding


/**
 *Created by Cevdet Yilmaz on 10.11.2022
 */
class CustomAgreementView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: LayoutAgreementBoxBinding =
        LayoutAgreementBoxBinding.inflate(LayoutInflater.from(context), this, true)

    init {

        val attributes: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.Agreement_View, 0, 0)

        val descriptionText: String? =
            attributes.getString(R.styleable.Agreement_View_agreement_text)

        val descriptionIcon: Drawable? =
            attributes.getDrawable(R.styleable.Agreement_View_agreement_icon)

        attributes.recycle()
        with(binding) {
            val content = SpannableString(descriptionText)
            content.setSpan(UnderlineSpan(), 0, content.length, 0)
            txtAgreementDescription.text = content
            imgAgreement.setImageDrawable(descriptionIcon)
        }
    }
}