package com.robbiedaves.insurex.api

import com.robbiedaves.insurex.core.delegates.EffDatedDelegateProvider

object IX {

    public inline fun <T> property(default : T) : EffDatedDelegateProvider<T> = EffDatedDelegateProvider(default)


}