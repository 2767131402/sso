//package com.macro.cloud.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
///**
// * 使用redis存储token的配置
// */
//@Configuration
//public class RedisTokenStoreConfig {
//
//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;
//
//    @Bean
//    public TokenStore tokenStore(){
//        return new RedisTokenStore(redisConnectionFactory);
//    }
//
//    @Bean
//    @Primary
//    public DefaultTokenServices defaultTokenServices() {
//        DefaultTokenServices services = new DefaultTokenServices();
//        services.setAccessTokenValiditySeconds(60 * 60 * 12);//设置token 20秒过期
//        services.setRefreshTokenValiditySeconds(60 * 60 * 24 * 30);//设置刷新token的过期时间
//        services.setTokenStore(tokenStore());
//        return services;
//    }
//}
