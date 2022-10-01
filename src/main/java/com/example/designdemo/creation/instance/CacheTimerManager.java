package com.example.designdemo.creation.instance;

import java.util.*;

/**
 * <ul>缓存管理器</ul>
 * <li>在缓存的时候，同时记录下该key,缓存时间，失效周期</li>
 * <li>在读取缓存的时候，更新该key的缓存时间，</li>
 * <li>定时器每两分钟运行一次，检查每个key是否过期，如果过期，删除该key-cacheSimple</li>
 * <li>线程安全</li>
 */
public class CacheTimerManager {
    //毫秒
    private static final long SECOND_TIME = 1000;
    //默认过期时间 :2分钟
    private static final long DEFUALT_VALIDITY_TIME = SECOND_TIME * 60 * 2;
    private static final Timer timer ;
    private static final Map<String, CacheSimple> map;
    //单例
    private static CacheTimerManager cacheTimerMamager = null;

    public static synchronized CacheTimerManager getInstance(){
        if(cacheTimerMamager == null){
            cacheTimerMamager = new CacheTimerManager();
        }
        return cacheTimerMamager;
    }

    static{
        timer = new Timer();
        map = new HashMap<String, CacheSimple>();
        //schedule方法参数  timer线程、方法执行延时、方法间隔时间
        timer.schedule(new CacheTimerTask(), 10*SECOND_TIME, DEFUALT_VALIDITY_TIME);
    }

    /**
     * 增加或更新缓存对象
     * @param key
     */
    public synchronized void  addCache(String key){
        CacheSimple cacheSimple = map.get(key);
        long outTime = System.currentTimeMillis()+DEFUALT_VALIDITY_TIME;
        if(cacheSimple == null){
            cacheSimple = new CacheSimple(key, outTime);
            map.put(key, cacheSimple);
        }
    }
    /**
     * 根据key 移除缓存的方法
     * @param key
     */
    public synchronized boolean remove(String key){
        Iterator<Map.Entry<String, CacheSimple>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, CacheSimple> entry = it.next();
            if(entry.getKey().equals(key)){
                it.remove();
                return true;
            }
        }
        return false;
    }
    /**
     * 静态自动移除cache方法
     */
    public static synchronized void removeCache() {
        CacheSimple cacheSimple;
        long currentTime = System.currentTimeMillis();
        Iterator<Map.Entry<String, CacheSimple>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, CacheSimple> entry = it.next();
            cacheSimple = map.get(entry.getKey());
            if(cacheSimple.getTimeoutStamp()<=currentTime){
                it.remove();
            }
        }
    }
    static class CacheTimerTask extends TimerTask {
        @Override
        public void run() {
            //移除cache
            CacheTimerManager.removeCache();
        }
    }

    /**
     * 根据key判断该缓存是否存在
     * @return true 存在
     */
    public boolean isCache(String key){
        CacheSimple cacheSimple = null;
        try {
            cacheSimple = map.get(key);
            if(cacheSimple!=null){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 根据key得到缓存的值
     * @param key
     * @return
     */
    @SuppressWarnings("unused")
    public CacheSimple get(String key) {
        CacheSimple cacheSimple;
        for (String key1 : map.keySet()) {
            if(key1.equals(key)){
                cacheSimple = map.get(key);
                return map.get(key);
            }
        }
        return null;
    }

}