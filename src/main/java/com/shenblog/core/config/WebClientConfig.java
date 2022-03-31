//package com.shenblog.core.config;
//
//import com.shenblog.core.authentication.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
///**
// * @author ShenChuanBiao
// * @title: WebClientConfig
// * @projectName system
// * @description: TODO
// * @date 2022/3/30 17:04
// */
//@Configuration
//@EnableAuthorizationServer
//public class WebClientConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
////    @Autowired
////    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//
//        clients.inMemory()
//                .withClient("client")
//                .resourceIds("rid")
//                .secret("secret")
//                .authorizedGrantTypes("password","refresh_token")
//                .accessTokenValiditySeconds(1800)
//                .refreshTokenValiditySeconds(7200)
//                .scopes("all");
//
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//
//                .userDetailsService(userDetailsService)
//
//                .tokenStore(new RedisTokenStore(redisConnectionFactory));
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        //允许客户端表单认证
//        security.allowFormAuthenticationForClients();
//    }
//}
