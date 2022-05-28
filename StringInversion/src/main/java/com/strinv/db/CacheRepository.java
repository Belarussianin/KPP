package com.strinv.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheRepository extends JpaRepository<CacheEntity, Long> {
    CacheEntity findCacheEntityByKey(String key);
    CacheEntity getCacheEntitiesByKey(String key);
}