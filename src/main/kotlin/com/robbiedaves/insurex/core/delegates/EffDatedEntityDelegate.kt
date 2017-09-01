package com.robbiedaves.insurex.core.delegates

import com.robbiedaves.insurex.api.EffDatedContract
import com.robbiedaves.insurex.api.EffDatedEntity
import java.util.*

class EffDatedEntityDelegate (val contract: EffDatedContract) : EffDatedEntity {
    override var sliceDate: Date
        get() = this.contract.sliceDate
        set(value) { this.contract.sliceDate = value }
}