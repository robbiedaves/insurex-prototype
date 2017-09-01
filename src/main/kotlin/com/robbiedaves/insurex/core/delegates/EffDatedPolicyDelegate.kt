package com.robbiedaves.insurex.core.delegates

import com.robbiedaves.insurex.api.EffDatedContract
import com.robbiedaves.insurex.api.EffDatedPolicy

class EffDatedPolicyDelegate() : EffDatedPolicy {
    override final var inforceContract: EffDatedContract? = null
    override var transactions: Array<EffDatedContract>? = null
}