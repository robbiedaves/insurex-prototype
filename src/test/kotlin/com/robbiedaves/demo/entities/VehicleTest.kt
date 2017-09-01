package com.robbiedaves.demo.entities

import com.robbiedaves.insurex.core.PolicyContract
import org.junit.Assert
import org.junit.Test
import java.util.*
import org.apache.commons.lang3.time.DateFormatUtils
import org.apache.commons.lang3.time.DateUtils

class VehicleTest {

    val calendar = Calendar.getInstance()

    val today = calendar.time
    val todayPlusSixMonths = DateUtils.addMonths(today, 6)
    val todayMinusSixMonths = DateUtils.addMonths(today, -6)


    @Test fun `Test Vehicle's date effective - number of seats`() {
        var contract = PolicyContract(today)
        val veh = Vehicle(contract)

        Assert.assertEquals("Vehicle - number of seats incorrect", 1, veh.numberOfSeats)

        veh.numberOfSeats = 2
        Assert.assertEquals("Vehicle - number of seats incorrect", 2, veh.numberOfSeats)

        // test change dates
        contract.effDate = todayPlusSixMonths
        Assert.assertEquals("Vehicle - number of seats incorrect", 2, veh.numberOfSeats)
        veh.numberOfSeats = 4
        Assert.assertEquals("Vehicle - number of seats incorrect", 4, veh.numberOfSeats)
        contract.effDate = today
        Assert.assertEquals("Vehicle - number of seats incorrect", 2, veh.numberOfSeats)
        contract.effDate = todayPlusSixMonths
        Assert.assertEquals("Vehicle - number of seats incorrect", 4, veh.numberOfSeats)

        // Test prior to start of contract
        contract.effDate = todayMinusSixMonths
        Assert.assertEquals("Vehicle - number of seats incorrect", 1, veh.numberOfSeats)
    }

    @Test fun `Test Vehicle's date effective - Make`() {
        var contract = PolicyContract(today)
        val veh = Vehicle(contract)

        Assert.assertEquals("Vehicle - make incorrect", "Ford", veh.make)

        veh.make = "Lexus"
        Assert.assertEquals("Vehicle - make incorrect", "Lexus", veh.make)

        // test change dates
        contract.effDate = todayPlusSixMonths
        Assert.assertEquals("Vehicle - make incorrect", "Lexus", veh.make)
        veh.make = "Tesla"
        Assert.assertEquals("Vehicle - make incorrect", "Tesla", veh.make)
        contract.effDate = today
        Assert.assertEquals("Vehicle - make incorrect","Lexus", veh.make)
        contract.effDate = todayPlusSixMonths
        Assert.assertEquals("Vehicle - make incorrect", "Tesla", veh.make)
    }

}