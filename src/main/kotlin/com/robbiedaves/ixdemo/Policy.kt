package com.robbiedaves.ixdemo

import com.robbiedaves.ix.IXPolicy

class Policy : IXPolicy() {
    var i90Number : String? by this.property(null)
}
