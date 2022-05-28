package com.strinv.cache;

import com.strinv.db.CacheEntity;
import com.strinv.db.CacheRepository;
import com.strinv.domain.StringInversion;
import com.strinv.logger.appLogger;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Component
public class StringCache {

    @Autowired
    public StringCache(CacheRepository repository) {
        this.repository = repository;
    }

    private final CacheRepository repository;

    public void add(StringInversion params, String key) {
        if (repository.findCacheEntityByKey(key) == null) {
            repository.save(new CacheEntity(key, params));
            appLogger.setLog(Level.INFO, "String " + params + " @" + key + " added to cache");
        }
    }

    public boolean isCached(String key) {
        appLogger.setLog(Level.INFO, "Cache: " + Arrays.toString(repository.findAll().stream().map(CacheEntity::getKey).toArray()));
        return repository.findCacheEntityByKey(key) != null;
    }

    public StringInversion find(String key) {
        if (repository.findCacheEntityByKey(key) != null) {
            appLogger.setLog(Level.INFO, "String " + key + " found in cache");
            return new StringInversion(repository.getCacheEntitiesByKey(key));
        }
        appLogger.setLog(Level.INFO, "String " + key + " not found in cache");
        return null;
    }
}
