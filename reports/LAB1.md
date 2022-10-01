# Cryptography and Security Laboratory Work Nr.1

### Course: Cryptography & Security
### Author: Purici Marius

----

## Objectives:

1. Get familiar with the basics of cryptography and classical ciphers.

2. Implement 4 types of the classical ciphers:
    * Caesar cipher with one key used for substitution (as explained above),
    * Caesar cipher with one key used for substitution, and a permutation of the alphabet,
    * Vigenere Cipher
    * Playfair Cipher
    * Affine Cipher
3. Structure the project in methods/classes/packages as needed.


## Implementation description

* Each cipher implements the `Cipher` trait.
```scala
trait Cipher {
  val alphabetSize: Int = 26
  def encrypt(message: String): String
  def decrypt(message: String): String
}
```
* For Caesar Cipher, the transformation can be represented by aligning two alphabets; the cipher alphabet is the plain alphabet rotated left or right by some number of positions. When encrypting, a person looks up each letter of the message in the "plain" line and writes down the corresponding letter in the "cipher" line. Deciphering is done in reverse.
* There is another variant of the Caesar Cipher in which a permutation of the regular alphabet is used.
* `AffineCipher`, `CaesarCipher`, `CaesarWithPermutation` all inherit from the `SubstitutionCipher` abstract class.
```scala
abstract class SubstitutionCipher extends Cipher {
  protected def encryptLetter(char: Char): Char
  protected def decryptLetter(char: Char): Char

  override def encrypt(message: String): String =
    message.toUpperCase
      .map {
        case char: Char if 'A' <= char && char <= 'Z' => encryptLetter(char)
        case char: Char                               => char
      }

  override def decrypt(message: String): String =
    message.toUpperCase
      .map {
        case char: Char if 'A' <= char && char <= 'Z' => decryptLetter(char)
        case char: Char                               => char
      }
}
```
* For the `PlayFairCipher`, the technique encrypts pairs of letters (bigrams or digrams), instead of single letters as in the simple substitution cipher and rather more complex Vigenère cipher systems then in use. The Playfair is thus significantly harder to break since the frequency analysis used for simple substitution ciphers does not work with it. The frequency analysis of bigrams is possible, but considerably more difficult. With possible bigrams rather than the 26 possible monograms (single symbols, usually letters in this context), a considerably larger cipher text is required in order to be useful.
* The **Vigenère** cipher is a method of encrypting alphabetic text by using a series of interwoven Caesar ciphers, based on the letters of a keyword. It employs a form of polyalphabetic substitution.

## Conclusions / Screenshots / Results

In this laboratory work I implemented some of the most known classical ciphers:

* Caesar cipher is based on letter shifting and substitution. Because of its simplicity, it is popular example of ciphers used to show the base concepts of cryptography. However, its simplicity makes this ciphers insecure and easy breakable. As was shown in the implementation, the encryption and decryption use simple techniques that do not require much time to break. Because of only 26 possible shifting keys, any human may break the key quickly. For modern computers it's a matter of milliseconds.
* In order to increase the number of keys, and consequently, the number iterations used to break it, is used permutation. The logic behind this permutation is simple, just take the alphabet and shuffle it, but the number of possible keys increase greatly, up to 4e+26!
Even if the possible number of keys is so large, it does not mean that enhanced Caesar cipher is fully secure. Any modern computer can break it a matter of seconds by frequency analysis.
* To conclude, Caesar cipher with permutation is an easy-to-implement algorithm, as proved in the lab work, and much more secure than ony using substitution. However, it is still insecure and impracticable in modern world.
Vigenere cipher uses the same principle as the Caesar cipher does. The table generated by alternating Caesar ciphers with several shifts increases the level of security. In addition to table there is present a secret key, an important part for security of ciphered text.
* Even if Vigenere cipher uses secret keys and multiple substitution it still can be broken by use of frequency analysis, so cannot be used to secure information from modern computers
Playfair cipher is the most complex from all of described above. It uses digraphs (pairs of letters) to perform encryption and a complex system of rules, that makes harder the life of cipher breakers.
The disadvantages of Playfair cipher are the same as for other symmetric algorithms. It is relatively easy to break using frequency analysis. Another disadvantages of this algorithm is the fact of using only one secret key, so it much harder to secure it
* In conclusion, symmetric algorithms are easy to implement and easy to break using simple techniques that does not require usage of modern technologies (it will require a lot of time for some of discussed algorithms). However, this algorithms are a good start for diving into cryptography and cryptanalysis.