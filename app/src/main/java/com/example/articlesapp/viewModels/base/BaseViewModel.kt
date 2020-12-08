package com.example.articlesapp.viewModels.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.articlesapp.callBacks.BaseCallBack

open class BaseViewModel<V : BaseCallBack>(application: Application) : AndroidViewModel(application) ,
    BaseVmodel<V> {
    lateinit var view:V
    override fun attachView(view: V) {
        this.view=view
    }

}