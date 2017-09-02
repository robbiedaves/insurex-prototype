package com.robbiedaves.ix

import java.util.*

class IXContract : IXEntity() {

    val _id : String by property("12")
    var start : Date? by property(null)
    var end : Date? by property(null)
    var status : String by property("DRAFT")

    // var job.....
    // var periods...

}