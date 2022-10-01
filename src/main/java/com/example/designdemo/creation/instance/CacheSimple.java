package com.example.designdemo.creation.instance;

public class CacheSimple {
    //根据时间戳存储
    private String cacheKey;
    //过期时间戳，在最后一次访问该key的时候计算得到
    private long timeoutStamp;

    public CacheSimple() {
        super();
    }

    public CacheSimple(String cacheKey, long timeoutStamp) {
        super();
        this.cacheKey = cacheKey;
        this.timeoutStamp = timeoutStamp;
    }

    public String getCacheKey() {
        return cacheKey;
    }
    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }
    public long getTimeoutStamp() {
        return timeoutStamp;
    }
    public void setTimeoutStamp(long timeoutStamp) {
        this.timeoutStamp = timeoutStamp;
    }
}
