import cn.jl.provice.Application;
import cn.jl.provice.Pruduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testRedis(){
        RedisConnection connection = redisConnectionFactory.getConnection();
        connection.set("hello".getBytes(), "world".getBytes());
        System.out.println(new String(connection.get("hello".getBytes())));
    }

    @Test
    public void testRedisTemplet(){
        redisTemplate.opsForValue().set("key1", "value1");
        System.out.println(redisTemplate.opsForValue().get("key1"));
    }

    @Test
    public void testList(){
        Pruduct p1 = new Pruduct(1, "洗发水", "500ml");
        Pruduct p2 = new Pruduct(2, "沐浴液", "200ml");
        redisTemplate.opsForList().rightPush("pruduct", p1);
        redisTemplate.opsForList().rightPush("pruduct", p2);
//        List<Object> prodList = redisTemplate.opsForList().range("pruduct", 0,redisTemplate.opsForList().size("pruduct")-1);
//        for(Object object : prodList){
//            System.out.println((Pruduct)object);
//        }
    }


}
