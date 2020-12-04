object AOC2 {
  
  trait PasswordPolicy {
    def isValid(pass: String): Boolean
  }
  class PolicySled(min: Int, max: Int, letter: Char) extends PasswordPolicy {
    def isValid(pass: String): Boolean = {
      val count = pass.count(_ == letter)
      return (count >= min && count <= max)
    }
  }
  
  class PolicyTobbogan(val firstIndex: Int, val secondIndex: Int, val letter: Char) extends PasswordPolicy {
    def isValid(pass: String): Boolean = {
      (pass.charAt(firstIndex - 1) == letter) ^ (pass.charAt(secondIndex - 1) == letter)
    }
  }
}
