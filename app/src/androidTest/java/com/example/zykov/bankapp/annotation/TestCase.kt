package com.example.zykov.bankapp.annotation

@Repeatable
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FUNCTION)
annotation class TestCase(val name: String, val description: String = "")