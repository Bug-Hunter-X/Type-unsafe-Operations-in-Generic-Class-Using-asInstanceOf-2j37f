```scala
sealed trait MyType
case class MyInt(value: Int) extends MyType
case class MyString(value: String) extends MyType

class MyClass[T <: MyType](val value: T) {
  def myMethod(other: MyClass[T]): MyType = (value, other.value) match {
    case (MyInt(v1), MyInt(v2)) => MyInt(v1 + v2)
    case (MyString(v1), MyString(v2)) => MyString(v1 + v2)
    case _ => throw new IllegalArgumentException("Unsupported types for addition")
  }
}

val int1 = new MyClass(MyInt(10))
val int2 = new MyClass(MyInt(20))
println(int1.myMethod(int2)) // prints MyInt(30)

val str1 = new MyClass(MyString("Hello"))
val str2 = new MyClass(MyString(" World"))
println(str1.myMethod(str2)) //prints MyString(Hello World)
```