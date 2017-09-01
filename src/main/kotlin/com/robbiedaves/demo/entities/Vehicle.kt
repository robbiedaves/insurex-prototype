package com.robbiedaves.demo.entities

import com.robbiedaves.insurex.api.EffDated
import com.robbiedaves.insurex.api.EffDatedContract
import com.robbiedaves.insurex.api.EffDatedEntity

class Vehicle (val contract: EffDatedContract) : EffDatedEntity by EffDated.entity(contract) {

    /*
     *  A vehicle should have the following:
     *      RegNumber           [Reg Number but first String]
     *      Make                [String]
     *      Model               [String]
     *      Number of Seats     [Int]
     *      Drivers             [Driver[] ]
     */

    var make : String? by EffDated.property("Ford")
    var model : String? by EffDated.property("Focus")
    var numberOfSeats : Int? by EffDated.property(1)
    var engineCapacity : Int? by EffDated.property(1666)
    var colour : String? by EffDated.property("Black")

    //var drivers : Driver[] = null

}