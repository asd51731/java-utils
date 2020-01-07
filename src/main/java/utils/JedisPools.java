package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description
 * @Author asd51731
 * @Date 2019-06-22
 * @Ide IntelliJ IDEA
 */


public class JedisPools {
    private static JedisPool jedisPool = null;
    private static String redisHost = "";
    private static int redisPort = 6379;
    private static String redisPswd = "";

    //静态代码初始化池配置
    static {
        try {
            //创建jedis池配置实例
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxWaitMillis(100000);
            config.setMaxTotal(10000);
            config.setTestOnBorrow(false);
            config.setTestOnReturn(false);

            //根据配置实例化jedis池
            jedisPool = new JedisPool(config, redisHost, redisPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得jedis对象，帖子用户对应关系
     */
    public static Jedis getJedisByIndex(int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.auth(redisPswd);
        jedis.select(index);
        return jedis;
    }


    /**
     * 归还jedis对象
     */
    public static void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}
