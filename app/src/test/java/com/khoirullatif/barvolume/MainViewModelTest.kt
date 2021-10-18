package com.khoirullatif.barvolume

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.rules.ExpectedException
import kotlin.jvm.Throws
import org.junit.Assert.*

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @Before
    fun init() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun calculate() {
        val width = "1"
        val length = "2"
        val height = "3"
        mainViewModel.calculate(width, height, length)
        assertEquals(6, mainViewModel.result)
    }
}