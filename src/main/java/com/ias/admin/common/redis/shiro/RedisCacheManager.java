package com.ias.admin.common.redis.shiro;

import com.ias.admin.common.util.MyLogger;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * redis缓存管理器
 * @author dududu
 * @email 345912664@qq.com
 * @date 2018-04-04
 */
public class RedisCacheManager implements CacheManager {

    private static final MyLogger logger = MyLogger.getLogger(RedisCacheManager.class);

    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();

    private RedisManager redisManager;

    private String keyPrefix = "shiro_redis_cache:";

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        logger.debug("获取名称为: " + name + "的RedisCache实例");

        Cache c = caches.get(name);

        if(c == null){
            redisManager.init();

            c = new RedisCache<K, V>(redisManager, keyPrefix);

            caches.put(name, c);
        }
        return c;
    }

    public RedisManager getRedisManager() {
        return redisManager;
    }

    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }

}
