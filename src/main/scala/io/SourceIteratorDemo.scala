package io

import java.util.concurrent.ConcurrentHashMap

import scala.collection.mutable.StringBuilder
import scala.io.Source

/**
 * Created by zhuwei on 2015/1/18.
 * 学习 io.Source 类的api,由于 source 是实现 iterator
 * 所以大部分方法还是 itertor 中的，顺便也熟悉了一下
 *
 */
object SourceIteratorDemo extends App{


  val isa = Thread.currentThread().getContextClassLoader.getResourceAsStream("a.txt")
  val isb = Thread.currentThread().getContextClassLoader.getResourceAsStream("b.txt");
  val source_a = Source.fromInputStream(isa)
  val source_b = Source.fromInputStream(isb)
  val source_c = source_a ++ source_b


  test_20()


  def test_20():Unit = {
    println((1 to 100) map (a => a + 1))
  }


  //toMap 不清楚
  def test_19():Unit = {
//    println((1 to 100).toMap[Int,Int])

  }

  //to 复制
  def test_18():Unit = {
    println((1 to 100).to)
    println((1 to 100) == (1 to 100).to)
  }


  // sum 求和
  def test_17():Unit = {
    println((1 to 100) sum)
  }

  /**
   * scanLeft,以初始值 遍历所有元素与其运算，将结果再放到一个新的iterator 中
   */
  def test_16 ():Unit = {
    val result = (1 to 100).scanLeft(0)(_ +_)
    println(result)
  }


  /**
   * sameElements 判断两个 iterator 是否元素相同
   */
  def test_15():Unit = {
    println((1 to 100) sameElements ((100 to 200)))

    println((1 to 100) sameElements ((100 to 200)))


  }


  //report
  def test_14():Unit = {
    source_a.report(0,"rrrr",System.out)
  }


  /**
   * reduce,可以用于求和
   */
  def test_13():Unit = {
    val result = (1 to 100) reduce (_ + _)
    println(result)
  }



  //product 不明白这个方法的作用
  def test_12():Unit = {
    val result = (1 to 100).product
    println(result)
  }

  //patch,批量替换
  def test_11():Unit = {
    val it = (1 to 10) patch(0, (10 to 20), 10)
    it.foreach(println)
  }



  //partition,将iterator 分成两个
  def test_10():Unit = {
    val (a,b) = (1 to 100) partition(_ >50)
    println(a)
    println(b)

  }


  def test_9():Unit ={
    val it = (1 to 100).padTo(10000,1000)
    it.foreach(println)
  }



  //forall
  def test_8():Unit = {
    val result = (1 to 100).forall(_ > 0)
    println(result)
  }


  //indexWhere
  def test_7():Unit = {
    //直接用 _ 写表达式
    val index= (1 to 100).indexWhere(_ == 100)
    println(index)
    //只有一个参数可以省略掉参数上的括号
    val index2 = (1 to 100) indexWhere (a => a == 100)
    println(index2)

    //小括号可以写为大括号
    val index3 = (1 to 100) indexWhere {
      a => a == 100
    }
    println(index3)

    //可以用case,但case 的判断一个是一个完全的条件
    val index4 = (1 to 100) indexWhere {
      case a => a == 100
    }
    println(index4)

    //这里如果不加case _ 是会报错的，因为case 不能匹配任何条件
    val index5 = (1 to 100) indexWhere {
      case a if a == 100 => true
      case _ =>false
    }
    println(index5)
  }

  /**
   * group(3)  对 iterator 进行分组,一组有三个元素
   */
  def test_6():Unit = {
    val list = (1 to 10) grouped 3 toList
    val a =1
    println(list)
  }



  /**
   * filter
   */
  def test_5:Unit = {
    val result = source_a.filter{
      case a => a.equals('h')
    }
    println(result)
  }


  /**
   * 只对source中的第一个元素进行 partialFunction操作
   *
   */
  def test_4():Unit ={
    val result = source_a.collectFirst{
      case a=>a+"_"
    }

    println(result)
  }


  /**
   * collect
   */
  def test_3():Unit = {
    //对于每个元素者加上下划线
    val it = source_a.collect{
      case a=>a+"_"
    }
    println(it)
    while(it.hasNext){
      println(it.next())
    }

  }

  def test_2():Unit = {
    println(source_a.descr)
  }


  /**
   * 遍历source 中的元素，相当于foldRight 操作
   */
  def test_1():Unit = {
    val buf = StringBuilder.newBuilder
    // /: 相当于 foldLeft
    val result = source_a./:(buf){
      case (a,b)=>a.append(b)
    }
    println(result)
  }










  def it(iterator:Iterator[String]):Unit ={
    while(iterator.hasNext){
      println(iterator.next())
    }
  }

}
