package com.robbiedaves.insurex.core.delegates

import com.robbiedaves.insurex.api.EffDatedContract
import com.robbiedaves.insurex.api.EffDatedEntity
import java.util.*

class EffDatedContractDelegate(override val editEffectiveDate : Date) : EffDatedContract {
    override var sliceDate : Date = this.editEffectiveDate
    override var status: String = "DRAFT"
}