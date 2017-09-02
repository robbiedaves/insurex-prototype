package com.robbiedaves.insurex.api

import com.robbiedaves.insurex.core.delegates.EffDatedDelegateProvider
import com.robbiedaves.insurex.core.delegates.IXDelegateProvider
import java.util.*
import kotlin.reflect.KProperty

abstract class IXPolicy : EffDatedPolicy, IXEntitiy {

    var properties = mutableListOf<String>()
    override final fun addPropertyRef(prop: String) {
        this.properties.add(prop)
    }

    override final var inforceContract: EffDatedContract?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override final var transactions: Array<EffDatedContract>?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    val createTime : Date? by this.property(Calendar.getInstance().time)

    public final inline fun <T> property(default : T) : IXDelegateProvider<T> = IXDelegateProvider(default)


    public fun printTestOutput() {
        println("Printing Property Defs for Entity: ${this}")
        for (prop in this.properties) {
            println("Property: ${prop}  ")
        }

    }

}