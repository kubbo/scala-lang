package lang

/**
 * Created by zhuwei on 2015/1/20.
 *
 * 有关Null,null,Nothing,Nil,None的用法
 *  null 是Null 的唯一子类
 *  Nothing 是一切类的子类,对于方法的返回值是Nothing就说明这个方法不会返回值(可能是异常)
 *  Nil =  List[Nothing]
 *  None = Option[Nothing]
 *
 *http://oldfashionedsoftware.com/2008/08/20/a-post-about-nothing/
 *
 *
 *
 */
object NullDemo extends App{




  test_Null(null)
  val a:Null = null
  test_Null(a)


  //值类型不能进行
  //  val b :Int = null

  //引用类型可以赋值 null
  val b: List[Int] = null

  val c: Option[Int] = None

  println(c)


  test_Noting("hello")



  def test_Noting(p:String): Unit = {
    println(p)
  }




  //参数类型是 Null
  def test_Null(str:Null):Unit = {
    println(str)
  }


}
