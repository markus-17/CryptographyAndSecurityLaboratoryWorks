package com.mariuspurici
package cryptography_and_security
package lab1

trait Cipher {
  val alphabetSize: Int = 26
  def encrypt(message: String): String
  def decrypt(message: String): String
}
