package com.robbiedaves.demo.entities

import com.robbiedaves.insurex.api.EffDated
import com.robbiedaves.insurex.api.EffDatedContract
import java.util.*

class Contract(override val editEffectiveDate : Date) : EffDatedContract by EffDated.contract(editEffectiveDate) {
}