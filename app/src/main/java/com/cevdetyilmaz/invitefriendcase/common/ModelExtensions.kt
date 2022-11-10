package com.cevdetyilmaz.invitefriendcase.common

/**
 *Created by Cevdet Yilmaz on 10.11.2022
 */
fun String?.convertAmountText(): String? {
    return if (this.isNullOrEmpty()) this else this.plus(Constants.CURRENCY.EURO)
}

fun Int?.convertMaxEarnText(): String {
    return if (this == null) "" else if (this > 0) Constants.SYMBOL.PLUS.plus(this.toString())
        .plus(Constants.CURRENCY.EURO) else this.toString()
}