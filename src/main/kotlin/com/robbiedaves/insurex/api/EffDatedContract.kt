package com.robbiedaves.insurex.api

import java.util.*

interface EffDatedContract : EffDatedEntity{
    val editEffectiveDate : Date
    var status : String
}