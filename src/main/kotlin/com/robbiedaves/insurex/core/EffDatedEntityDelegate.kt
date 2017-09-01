package com.robbiedaves.insurex.core

import java.util.*

class EffDatedEntityDelegate (val policyContract: PolicyContract) : EffDatedEntity {
    override val sliceDate: Date
        get() = policyContract.effDate

}