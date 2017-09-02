package com.robbiedaves.ix

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class IXDelegateProvider <T> (val default : T) {

    operator fun provideDelegate(thisRef: IXEntity, prop : KProperty<*>) :
            ReadWriteProperty<IXEntity, T> {
        if (default != null) {
            thisRef.setProperty(prop.name, default)
        }
        return object : IXProperty<T>(default) {}
    }
}