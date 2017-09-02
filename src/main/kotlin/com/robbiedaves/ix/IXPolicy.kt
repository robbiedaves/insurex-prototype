package com.robbiedaves.ix

import kotlin.properties.Delegates

open class IXPolicy : IXEntity() {
    var modelNumber : String? by this.property("12345")
    var modelRef : Int by this.property(1)

}