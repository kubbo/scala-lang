package lang

/**
 * Created by zhuwei on 2015/1/20.
 */
object OptionDemo extends App{



  val map = Map("a" ->"b")
  println(test_get(map get ("c")))
  println(map.get("ccc") == null )


  /**
   * 常用 Option 操作 
   * @param value
   * @return
   */
  def test_get(value:Option[String]) = value match{
    case Some(x) =>x
    case None=>"?"
  }


  def test_flatMap():Unit = {
    val op = Option("hello")
    op flatMap(str=>Option(str+" world"))
  }

  def test_exists():Unit = {
    val op = Option("hello")
    println(op exists (_ => true))
  }


  def test_count():Unit = {
    val op = Option("hello")
    println(op.count(_=>true))

  }


  def test_map():Unit = {
    val op = Option("hello")
    val result = op map(_+ " world")
    println(result)
  }

  def test_collect_first():Unit = {
    val op = Option("hello")
    val result = op collectFirst {
      case a => a + "world"
    }
    println(result)
  }
  def test_collect():Unit = {
    val op = Option("hello")
    val result = op collect {
      case a => a + " world"
    }

    println(result)
  }


  def test_create(): Unit ={
    val op1 = Option("hello world")
    val op2 = Option("hello world")
    println(op1 == op2)
    println(op1 canEqual(op2))
    println(op1.get)
    println(op1.isEmpty)
    println(op1.productArity)
    println(op1.productElement(0))
  }





  def test_0():Unit = {
    val str:Option[String] = Some("  hello  ")
    val result = str map(_ trim) filter(_.length!=0) map(_.toUpperCase())
    println(result getOrElse "xxxx")

  }






}
