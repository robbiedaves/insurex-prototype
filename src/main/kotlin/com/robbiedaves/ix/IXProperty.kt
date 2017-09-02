package com.robbiedaves.ix

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

public abstract class IXProperty<T> (initialValue: T) : ReadWriteProperty<IXEntity, T> {

    val initialValue : T? = initialValue

    init {
       // println("IXProperty $this initialised for IXEntity $thisRef")
    }


    /**
     *  The callback which is called before a change to the property value is attempted.
     *  The value of the property hasn't been changed yet, when this callback is invoked.
     *  If the callback returns `true` the value of the property is being set to the new value,
     *  and if the callback returns `false` the new value is discarded and the property remains its old value.
     */
    protected open fun beforeChange(property: KProperty<*>, oldValue: T?, newValue: T): Boolean = true

    /**
     * The callback which is called after the change of the property is made. The value of the property
     * has already been changed when this callback is invoked.
     */
    protected open fun afterChange (property: KProperty<*>? = null, oldValue: T? = null, newValue: T? = null): Unit {}

    public override fun getValue(thisRef: IXEntity, property: KProperty<*>): T {
        return thisRef.getProperty(property.name)
    }

    public override fun setValue(thisRef: IXEntity, property: KProperty<*>, value: T) {
        //this.value = value
        thisRef.setProperty<T>(property.name, value)
    }
}