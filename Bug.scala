```scala
class MyClass[T](val value: T) {
  def myMethod(other: MyClass[T]): T = {
    value match {
      case v: Int => v + other.value.asInstanceOf[Int]
      case v: String => v + other.value.asInstanceOf[String]
      case _ => throw new IllegalArgumentException("Unsupported type")
    }
  }
}

val int1 = new MyClass(10)
val int2 = new MyClass(20)
println(int1.myMethod(int2)) //prints 30

val str1 = new MyClass("Hello")
val str2 = new MyClass(" World")
println(str1.myMethod(str2)) // prints Hello World

val error = new MyClass(true)
val error2 = new MyClass(false)
println(error.myMethod(error2)) // throws IllegalArgumentException: Unsupported type
```