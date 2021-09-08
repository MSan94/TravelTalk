package com.prj.traveltalk

interface BaseView<T> {
    var presenter : T
    fun init();
}