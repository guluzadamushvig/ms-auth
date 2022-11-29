package com.example.auth.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

@Component
@Slf4j
@RequiredArgsConstructor
public class CacheUtil {
    private final RedissonClient redissonClient;

    public <T> T getBucket(String cacheKey) {
        RBucket<T> bucket = redissonClient.getBucket(cacheKey);
        return bucket == null ? null : bucket.get();
    }

    public <T> void saveToCache(String key, T value, Long expireTime, TemporalUnit temporalUnit) {

        var bucket = redissonClient.getBucket(key);
        bucket.set(value);
        bucket.expire(Duration.of(expireTime, temporalUnit));
    }
}
