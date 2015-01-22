package swiftcase

import scala.collection.Map


/**
 * Created by zhuwei on 2015/1/21.
 */
sealed  abstract class A
case class B(name:String) extends A
case class C(name:String) extends A

object caseDemo extends App{



  //for 循环中的模式匹配
  val map = Map(1 -> "a", 2 -> "b")

  for((k,v)<- map){
    println(k+":"+v)
  }




  //定义为一个简单的函数
  val second: List[Int] => Int = {
    case x :: y :: _ => y
  }

  //定义类型为一个偏函数,编译器会将此定义进行翻译
  //翻译的结果就是 second3

  val second2:PartialFunction[List[Int],Int] = {
    case x::y::_ =>y
  }

  val second3 = new PartialFunction[List[Int], Int] {
    override def isDefinedAt(x: List[Int]): Boolean = x match {
      case x :: y :: _ => true
      case _ => false
    }

    override def apply(v1: List[Int]): Int = v1 match {
      case x :: y :: _ => y
      case _ => 0
    }
  }


  val list = List(1,2,3)
//  println(second(Nil))
  println(second.getClass)
  println(second2.getClass)

  //用模式匹配来代替函数字面量 参数:类型=>{case 体}
  val fun: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }

  //一般的函数字面量定义(参数:类型)=>{方法体}
  val fun2 = (value:Option[Int])=>{
    value.get
  }

  def test_sealed(obj:A) = obj match {
    case B(_)=> println("B")
    case C(_) =>println("C")

  }


  def test_map():Unit = {
    val array1 = Array(1, 5, 3, 7)
    val array2 = Array(2, 4, 1, 7, 8)
    //找到相同的
    val same = array2.filter(i => array1.contains(i)).toList
    //找不相同的，从两个数组中都去掉相同 的
    val notsame = (array1.filterNot(i=>same.contains(i)) ++ array2.filterNot(i=>same.contains(i))).toList
    println(same)
    println(notsame)

  }

  def test_case_if():Unit = {
    1 match{
      case a if a>1=> println(a)
      case _=>println("No")
    }
  }

  /**
   * 将匹配的对象绑定变量上
   */
  def test_bind_variable():Unit = {
    val result = List(1,2,3) match{
      case List(1,2,last@3)=>last
      case _=>"NO"
    }
    println(result)
  }




  /**
   * 但对于Array 来讲，是可以区分的
   * @param obj
   */
  def test_type_erase_2(obj:Any) = obj match{
    case ai:Array[Int] =>println("Array[Int]")
    case as:Array[String]=>println("Array[String]")
  }
  /**
   * case 中不要泛型，因为类型会被擦除
   * 它不会区分  map[Int,Int] 与 map[String,String]
   * @param str
   * @return
   */
  def test_type_erase(str:Any)= str match{
    case map:Map[Int,Int]=>true
    case _ =>false
  }

  /**
   * 用 match case 来进行类型转换,作用相当于下面的 length_2
   * 用match case 来进行类型转换更加方便
   * @param obj
   * @return
   */

  def length(obj:Any) = obj match{
    case s:String =>s.length
    case m:Map[_,_] =>m.size
    case _=>throw new IllegalArgumentException
  }


  /**
   * 用 isInstanceOf[] 与 asInstanceOf 进行类型转换
   * @param obj
   * @return
   */
  def length_2(obj:Any):Int = {


    if(obj.isInstanceOf[String]){
      obj.asInstanceOf[String].length
    }else{
      if(obj.isInstanceOf[Map[_,_]]){
        obj.asInstanceOf[Map[_,_]].size
      }else{
        throw new IllegalArgumentException
      }
    }
  }


  /**
   * 匹配类型
   */

  def test_match_type():Unit = {
    Map[Int, Int](1 -> 1, 2 -> 2) match{
      case s:Map[_,_] =>println("OK")
      case _=> println("NO")
    }
  }

  def test_match_tuple():Unit = {
    (1,2,3) match{
      case (_,_,3)=>println("OK")
      case _=> println("NO")
    }
  }


  /**
   *  匹配 list
   */
  def test_match_list():Unit = {
    List(1,2,3) match{
      case List(_,_,3)=>println("OK")
      case _=> println("No")
    }
  }


  /**
   * 匹配构造器，此类必须是 case 修饰的才可以
   */
  def test_match_construct():Unit = {
    Person("scala",10) match{
      case Person(a,10)=>println("OK:"+a)
      case _=> println("NO")
    }
  }
  /**
   * 类型匹配
   */
  def test_match_class():Unit = {
    "scala" match{
      case _:String =>println("OK")
      case _=> println("NO")
    }
  }

  /**
   * 常量一般以首字母大写，但对于小写字符加上 `` 会作为常量来对待
   */
  def test_match_constant2(): Unit = {
    val pi = 3.14
    3.14 match {
      case `pi` => println("OK ")
      case  _ => println("NO")
    }
  }

  /**
   * 匹配常量
   */
  def test_match_constant(): Unit ={
    val PI = 3.14
    3.14 match{
      case PI => println("OK")
      case _ => println("No")
    }
  }


  /**
   * 匹配通配符
   */

  def test_match_(): Unit ={
    "hello" match {
      case _ =>println("OK")
    }
  }
}
