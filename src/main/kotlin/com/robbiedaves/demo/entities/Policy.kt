package com.robbiedaves.demo.entities

import com.robbiedaves.insurex.api.EffDated
import com.robbiedaves.insurex.api.EffDatedContract
import com.robbiedaves.insurex.api.EffDatedPolicy

class Policy : EffDatedPolicy by EffDated.policy() {
    // todo - a problem here is we can override something that we want to lock down!!!
    override var inforceContract: EffDatedContract? = null


}