package com.robbiedaves.ix

import com.robbiedaves.ixdemo.Policy
import org.junit.Test

class IXTest {

    @Test
    fun `Test Policy instantiation`() {
        var pol = Policy()
        pol.printTestOutput()

        pol.modelNumber = "Robs Test Model Number"
        pol.i90Number = "ADMOT123456"
        pol.modelRef = 3
        pol.printTestOutput()

        pol.modelNumber = "New Model Number"
        pol.i90Number = "DIAMO123456"
        pol.modelRef = 222
        pol.printTestOutput()
    }

}