package utils

import java.text.SimpleDateFormat
import java.util.Locale

import com.github.javafaker.Faker
import com.github.javafaker.service.{FakeValuesService, RandomService}


import  DataContext._

object DataContext{
  val email: String =
      new FakeValuesService(new Locale("en-GB"), new RandomService())
        .bothify("????##@gmail.com")
    val password: String =
      new FakeValuesService(new Locale("en-GB"), new RandomService())
        .regexify("[a-z1-9]{10}")
}
