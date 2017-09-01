package com.robbiedaves.insurex.core

object EffDated {

    public inline fun <T> property(default : T) : EffDatedDelegateProvider<T> = EffDatedDelegateProvider(default)

    public inline fun entity(policyContract: PolicyContract) : EffDatedEntity = EffDatedEntityDelegate(policyContract)

}