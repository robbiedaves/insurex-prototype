package com.robbiedaves.insurex.core.delegates

import com.robbiedaves.insurex.api.EffDatedEntity
import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

public abstract class EffDatedProperty<T> (thisRef: EffDatedEntity, initialValue: T) : ReadWriteProperty<EffDatedEntity, T?> {
    private val value : TreeMap<Date, T?> = TreeMap<Date, T?>()

    init {
        if (initialValue != null) {
            value.put(thisRef.sliceDate, initialValue)
        }
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

    public override fun getValue(thisRef: EffDatedEntity, property: KProperty<*>): T? {
        val valueEntry = this.value.floorEntry(thisRef.sliceDate)
        if (valueEntry == null) {
            // todo - this is not correct !!!!! We should never allow an eff date prior to start but if we did then error!
            // todo - however, if we add a field (i.e. from null to a value, then go back before the value was added but after the contract start date, then this should be allowed!
            //return this.initialValue
            return null
        }
        return this.value.floorEntry(thisRef.sliceDate).value
    }

    public override fun setValue(thisRef: EffDatedEntity, property: KProperty<*>, value: T?) {
        val oldValue = this.value.floorEntry(thisRef.sliceDate)
//        if (!beforeChange(property, oldValue.value, value)) {
//            return
//        }

        // only add if changed
        if (oldValue?.value != value) {
            this.value.put(thisRef.sliceDate, value)
        }
        //   this.value = value
//        afterChange(property, oldValue.value, value)
    }
}