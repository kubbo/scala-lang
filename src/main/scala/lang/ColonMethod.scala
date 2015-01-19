package lang

/**
 * Created by zhuwei on 2015/1/19.
 */
class ColonMethod {


  /**
   * 此方法可以 ("hello") /: obj 这种方式来调用
   * @param txt
   */

  def /:(txt:String):Unit = {
    println(txt)
  }

  /**
   * 此方法不可以以 ("hello","world") /: obj 的方式来调用
   *
   * @param a
   * @param b
   */
  def /:(a:String,b:String):Unit ={
    println(a+b)
  }
}


/**
 *定义伴生对象，apply 可以以 ColonMethod 方式创建对象
 * 对于方法名以 : 结尾，并且参数只有一个时，可以将参数后在对象的前面
 * 如果有多个参数，则不可以这样
 */


object ColonMethod extends App{



  def apply():ColonMethod ={
    return new ColonMethod()
  }

  val colon = ColonMethod()
  colon./:("hello","world")






}
