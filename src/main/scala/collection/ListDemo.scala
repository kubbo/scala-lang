package collection

/**
 * Created by zhuwei on 2015/1/21.
 */
object ListDemo extends App {


  //  caseMathEmptyList()
  val list = (1 to 10).toList;


  takeWhile()

  /**
   * takeWhile 获取满足条件的前n个
   * dropWhile去掉满足条件的前n个
   * span 是takeWhile 与 dropWhile的合并
   */
  def takeWhile(): Unit = {
    println(list takeWhile (_ < 3))
    println(list dropWhile (_ < 2))
    println(list span (_ < 3))

  }

  /**
   * 仅返回满足条件的第一个元素
   */
  def find(): Unit = {
    val result = list find (_ > 1)
    println(result)

  }

  /**
   * 与filter 类型，filter 只是返满足条件，partition 把不满足条件的也进行了返回
   */
  def partition(): Unit = {
    val result = list partition (_ > 4)
    println(result._1)
    println(result._2)

  }


  /**
   * flatMap 与map 的区别在于高阶参数的不同
   * map:输入为元素，输出为新列表的元素，都是单个元素
   * flatMap:输入为元素，输出为新列表的元素，输出的元素也是列表类型
   */
  def flatMap(): Unit = {
    val result = list flatMap {
      case a => 1 to a
    }
    result foreach {
      case a => println(a)

    }
  }

  /**
   * 对列表进行打印输出
   */
  def mkString(): Unit = {
    println(list.toString)
    val result = list mkString ("-")
    val result2 = list mkString("list:", ",", "end")
    println(result)
    println(result2)
  }

  /**
   * 将两个列表组成一个对偶例表，列表的元素是(a,b) 这种
   */

  def zip(): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    val result = list1 zip list2
    result foreach {
      case (a, b) => println(a + ":" + b)
    }
  }

  def indies(): Unit = {
    val result = list.indices
    println(result)

  }

  //apply 实现与  array 同样的方法，以  index进行数据读写
  def apply(): Unit = {
    println(list(1))
  }


  /**
   * take n ：获取 前n 个元素
   * drop n ; 去掉前n 个元素
   */
  def take(): Unit = {
    val list1 = list take 2
    val list2 = list drop 2
    println(list1)
    println(list2)

  }

  def reverse(): Unit = {
    println(list == list.reverse.reverse)
  }


  /**
   * head 返回链接首元素
   * tail 返回除链接首元素外的所有元素列表
   * last 返回链接尾元素
   * init 返回除链接尾元素外的所有元素列表
   */
  def init(): Unit = {
    println(list.head)
    println(list.tail)
    println(list.last)
    println(list.init)
  }


  //case List() 其实就是匹配一个空的列表
  def caseMathEmptyList(): Unit = {
    val list = Nil;
    list match {
      case List() => println("OK")
      case _ => println("NO")
    }
  }

  //用:: 进行list 的模式匹配,在不知道list 元素个数的情况下进行匹配 
  def castListElement(): Unit = {
    val list = List(1, 2, 3, 4)
    list match {
      case a :: b :: other => println(a + "," + b)
      case _ => println("NO")
    }
  }

  //并行处理list
  def par(): Unit = {
    list.par.foreach {
      case a => println(Thread.currentThread().getName + ":" + a)
    }
  }

  def map(): Unit = {
    val mapList = list.map(_ + 1)
    println(mapList)

  }

  def filter(): Unit = {
    val l = list filter (_ > 5)
    println(l)
  }

  def folder(): Unit = {
    val result = list.foldLeft(0)(_ + _)
    println(result)

  }

}
