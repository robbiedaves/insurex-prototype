package com.robbiedaves.ix

import kotlin.properties.ReadWriteProperty

open class IXEntity {

  //  private var properties = IXProperyMap()
    var propMap = HashMap<String, Any?>()


    fun <T> setProperty(prop : String, value : T) {
        propMap.put(prop, value)
    }

    fun <T> getProperty(prop : String) : T {
        return propMap.get(prop) as T
    }


    final fun printTestOutput() {
        println("Printing Properties for Entity ${this.javaClass.canonicalName} .....")
        for (entry in propMap.entries){
            println("Property: ${entry.key}     Value: ${entry.value}")
        }
        println("************************************************************************")
    }
  //  public final inline fun <T> property(default : T) : ReadWriteProperty<IXEntity, T> =
    //    object : IXProperty<T>(default) { }

    public final inline fun <T> property(default : T) =  IXDelegateProvider<T>(default)


}

