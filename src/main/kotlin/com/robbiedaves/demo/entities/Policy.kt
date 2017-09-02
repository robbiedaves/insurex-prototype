package com.robbiedaves.demo.entities

import com.robbiedaves.insurex.api.IXPolicy

class Policy : IXPolicy() {

    val I90Number : String? by this.property("x")


}