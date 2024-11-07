package com.openmind.ezdg.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(host, port);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        // Kryo Serializer 적용 - 여기서 Object.class를 명확히 지정합니다.
        KryoSerializer<Object> kryoSerializer = new KryoSerializer<>(Object.class);
        redisTemplate.setValueSerializer(kryoSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer()); // 키는 문자열 직렬화 유지

        return redisTemplate;
    }
}
