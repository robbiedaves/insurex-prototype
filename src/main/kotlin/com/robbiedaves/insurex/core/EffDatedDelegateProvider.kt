package com.robbiedaves.insurex.core

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class EffDatedDelegateProvider<T>(val default : T) {

    /* todo - If we don't need to intercept the create of the delegate then
     * todo - we could use an inline fun like the observable delegate (maybe better performance!)
     */
    operator fun provideDelegate(thisRef: EffDatedEntity, prop : KProperty<*>) :
            ReadWriteProperty<EffDatedEntity, T> = object : EffDatedProperty<T>(default) {
        override fun afterChange(property: KProperty<*>?, oldValue: T?, newValue: T?) {
        }
    }
}