package com.robbiedaves.insurex.api

import com.robbiedaves.insurex.core.delegates.EffDatedContractDelegate
import com.robbiedaves.insurex.core.delegates.EffDatedDelegateProvider
import com.robbiedaves.insurex.core.delegates.EffDatedEntityDelegate
import com.robbiedaves.insurex.core.delegates.EffDatedPolicyDelegate
import java.util.*

object EffDated {

    // todo - leave inline in for now - we may add inline function to delegate
    public inline fun <T> property(default : T) : EffDatedDelegateProvider<T> = EffDatedDelegateProvider(default)

    public inline fun entity(contract: EffDatedContract) : EffDatedEntity = EffDatedEntityDelegate(contract)

    public inline fun contract(editEffectiveDate : Date) : EffDatedContract = EffDatedContractDelegate(editEffectiveDate)

    public inline fun policy() : EffDatedPolicy = EffDatedPolicyDelegate()

}