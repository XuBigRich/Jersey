package controller;

import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Path("hello")
public class Controller {
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)//注解@Produces用于定义方法的响应实体的数据类型
    @Consumes(MediaType.APPLICATION_JSON)//@Consumes用来指定可以接受client发送过来的参数类型，
    public String  Hello(@PathParam("id") Long a){
        return a+"";
    }
    /*
    *错误示范
    * 因为客户端请求的是json格式 这里用的是@FormParam 接收 所以报错
    * */
   /* @POST
    @Path("world")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String  world(@FormParam("id") String a){
        System.out.println(a);
        return a;
    }*/
   /*
   * 这里是正确示范
   * */
   @POST
   @Path("world")
//   @Produces(MediaType.APPLICATION_JSON)
   //这里是设置编码的 上边那个也没错  但是没有设置编码
   @Produces("application/json;charset=UTF-8")
   @Consumes(MediaType.APPLICATION_JSON)
   public Map<String,Object> world(@RequestBody Map<String,Object> a){
//       输出的接收值
       System.out.println(a);
      // Set set=a.entrySet();// 遍历Map中的所有元素
       Set set=a.keySet();//遍历Map中的所有key
       Iterator it=set.iterator();
       while(it.hasNext()){
           //System.out.println(it.next()); // 输出Map所有元素
           System.out.println( a.get(it.next()));
       }
       Map<String,Object> map = new HashMap<String,Object>();
       map.put("a",a);
       //输出返回值
       System.out.println(map);
       return map;  //以json格式返回map类型
   }
}
