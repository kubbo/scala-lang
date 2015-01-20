package lang

/**
 * Created by zhuwei on 2015/1/20.
 *
 * 参数是function 类型的传递 方式
 */
object FunctionParamDemo  extends App{


  /**
   * 举一个最简单的例子,list.filter 方法
   */

  var result = (1 to 100 ) filter((a:Int)=>{a==100})
  println(result)

  //参数类型可以推断出来，此时可以不写,方法体语句只有一句，不用写{}
  result = (1 to 100) filter(a=>a == 100)


  //直接用 _ 写 方法内容
  result = (1 to 100 )filter(_ == 100)


  //利用case
  result = (1 to 100).filter{
    case a => a == 100
  };


  //带有 if 的 case
  result = (1 to 100).filter{
    case a if a == 100 => true
    case _ => false
  }

  println(result)

}
