package com.example.articlesapp.viewModels.base

import com.example.articlesapp.callBacks.BaseCallBack

interface BaseVmodel<V : BaseCallBack> {
    fun attachView(view:V)
}