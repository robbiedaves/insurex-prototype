package com.robbiedaves.ix

open class IXPolicy : IXEntity() {
    val _id : String by this.property("123")
    val policyID : String by this.property("")

}