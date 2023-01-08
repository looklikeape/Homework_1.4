import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun feeCalculationVKpay() {
        val payType: String = "VK pay"
        val currentMonthTransfer = 0
        val transferAmount = 1000

        val result = feeCalculation(payType, currentMonthTransfer, transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun feeCalculationVISA() {
        val payType: String = "VISA"
        val currentMonthTransfer = 0
        val transferAmount = 1000

        val result = feeCalculation(payType, currentMonthTransfer, transferAmount)
        assertEquals(75.0, result)
    }

    @Test
    fun feeCalculationVISAminimalDiscount() {
        val payType: String = "VISA"
        val currentMonthTransfer = 0
        val transferAmount = 450

        val result = feeCalculation(payType, currentMonthTransfer, transferAmount)
        assertEquals(35, result)
    }

    @Test
    fun feeCalculationMIR() {
        val payType: String = "MIR"
        val currentMonthTransfer = 0
        val transferAmount = 1000

        val result = feeCalculation(payType, currentMonthTransfer, transferAmount)
        assertEquals(75.0, result)
    }

    @Test
    fun feeCalculationMIRminimalDiscount() {
        val payType: String = "MIR"
        val currentMonthTransfer = 0
        val transferAmount = 100

        val result = feeCalculation(payType, currentMonthTransfer, transferAmount)
        assertEquals(35, result)
    }

    @Test
    fun feeCalculationMastercard() {
        val payType: String = "Mastercard"
        val currentMonthTransfer = 0
        val transferAmount = 1000

        val result = feeCalculation(payType, currentMonthTransfer, transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun feeCalculationMastercardOverMonthLimit() {
        val payType: String = "Mastercard"
        val currentMonthTransfer = 80_000
        val transferAmount = 1000

        val result = feeCalculation(payType, currentMonthTransfer, transferAmount)
        assertEquals(80.0, result)
    }

    @Test
    fun feeCalculationMaestro() {
        val payType: String = "Maestro"
        val currentMonthTransfer = 0
        val transferAmount = 1000

        val result = feeCalculation(payType, currentMonthTransfer, transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun feeCalculationMaestroOverMonthLimit() {
        val payType: String = "Maestro"
        val currentMonthTransfer = 80_000
        val transferAmount = 1000

        val result = feeCalculation(payType, currentMonthTransfer, transferAmount)
        assertEquals(80.0, result)
    }

    @Test
    fun feeCalculationInacceptableInput() {
        val payType: String = "Netology"
        val currentMonthTransfer = 80_000
        val transferAmount = 1000

        val result = feeCalculation(payType, currentMonthTransfer, transferAmount)
        assertEquals("некорректный ввод", result)
    }
}
