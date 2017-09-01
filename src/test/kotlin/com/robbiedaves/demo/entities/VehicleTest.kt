package com.robbiedaves.demo.entities

import org.junit.Assert
import org.junit.Test
import java.util.*
import org.apache.commons.lang3.time.DateFormatUtils
import org.apache.commons.lang3.time.DateUtils

class VehicleTest {

    private val calendar = Calendar.getInstance()
    private val today = calendar.time
    private val todayPlusSixMonths = DateUtils.addMonths(today, 6)
    private val todayMinusSixMonths = DateUtils.addMonths(today, -6)


    @Test fun `Test Vehicle's date effective - number of seats`() {
        var contract = Contract(today)
        val veh = Vehicle(contract)

        Assert.assertEquals("Vehicle - number of seats incorrect", 1, veh.numberOfSeats)

        veh.numberOfSeats = 2
        Assert.assertEquals("Vehicle - number of seats incorrect", 2, veh.numberOfSeats)

        // test change dates
        contract.sliceDate = todayPlusSixMonths
        Assert.assertEquals("Vehicle - number of seats incorrect", 2, veh.numberOfSeats)
        veh.numberOfSeats = 4
        Assert.assertEquals("Vehicle - number of seats incorrect", 4, veh.numberOfSeats)
        contract.sliceDate = today
        Assert.assertEquals("Vehicle - number of seats incorrect", 2, veh.numberOfSeats)
        contract.sliceDate = todayPlusSixMonths
        Assert.assertEquals("Vehicle - number of seats incorrect", 4, veh.numberOfSeats)

        // Test prior to start of contract
        contract.sliceDate = todayMinusSixMonths
        Assert.assertEquals("Vehicle - number of seats incorrect", null, veh.numberOfSeats)

        veh.numberOfSeats = null
    }

    @Test fun `Test Vehicle's date effective - Make`() {
        var contract = Contract(today)
        val veh = Vehicle(contract)

        Assert.assertEquals("Vehicle - make incorrect", "Ford", veh.make)

        veh.make = "Lexus"
        Assert.assertEquals("Vehicle - make incorrect", "Lexus", veh.make)

        // test change dates
        contract.sliceDate = todayPlusSixMonths
        Assert.assertEquals("Vehicle - make incorrect", "Lexus", veh.make)
        veh.make = "Tesla"
        Assert.assertEquals("Vehicle - make incorrect", "Tesla", veh.make)
        contract.sliceDate = today
        Assert.assertEquals("Vehicle - make incorrect","Lexus", veh.make)
        contract.sliceDate = todayPlusSixMonths
        Assert.assertEquals("Vehicle - make incorrect", "Tesla", veh.make)

        // Test prior to start of contract
        contract.sliceDate = todayMinusSixMonths
        Assert.assertEquals("Vehicle - make incorrect", null, veh.make)
    }

}