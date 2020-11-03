package com.cc.gatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
@SpringBootApplication
public class GatewayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayDemoApplication.class, args);
    }

    /**
     * Before 路由断言测试
     * 两分钟后对于"/testBefore/**"匹配的请求都将失效
     * @param builder
     * @return RouteLocator
     */
//    @Bean
//    public RouteLocator beforeCustomRouteLocator(RouteLocatorBuilder builder) {
//        ZonedDateTime datatime = LocalDateTime.now().plusMinutes(2).atZone(ZoneId.systemDefault());
//        return builder.routes().route("/testBefore/**", r -> r.before(datatime).uri("https://example.org/")).build();
//    }

    /**
     * After 路由断言测试
     * 一分钟后对于"/testAfter/**" 匹配的请求才有效
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator afterCustomRouteLocator(RouteLocatorBuilder builder) {
//        // 当前时间往后一分钟
//        ZonedDateTime datatime = LocalDateTime.now().plusMinutes(1).atZone(ZoneId.systemDefault());
//        return builder.routes().route("/testAfter/**", r -> r.after(datatime).uri("https://example.org/")).build();
//    }

    /**
     * Betweem 路由断言测试
     * 匹配当前时间一分钟至两分钟的请求
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator betweenCustomRouteLocator(RouteLocatorBuilder builder){
//        ZonedDateTime dateTime1 = LocalDateTime.now().plusMinutes(1).atZone(ZoneId.systemDefault());
//        ZonedDateTime dateTime2 = LocalDateTime.now().plusMinutes(2).atZone(ZoneId.systemDefault());
//        return builder.routes().route("/testBetween/**",r -> r.between(dateTime1,dateTime2).uri("https://example.org/")).build();
//    }

//    /**
//     * Cookie 路由断言工厂
//     * 判定某个Cookie参数是否满足某个正则式，满足时匹配路由
//     * @param builder
//     * @return
//     */
//    @Bean
//    public RouteLocator cookieCustomRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes().route("/testCookie/**",r -> r.cookie("chocolate","ch.p").uri("https://example.org/")).build();
//    }

    /**
     * Header 路由断言工厂
     * 判定某个Header参数是否满足某个正则式，满足时路由匹配
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator headerCustomRouteLocator(RouteLocatorBuilder builder){
//        String regex = "^[0-9]*$"; // 0-9数字
//        return builder.routes().route("/testHeader/**",r->r.header("myHeader",regex).uri("https://example.org/")).build();
//    }

    /**
     * Host 路由断言工厂
     * 判定访问主机名称是否满足某个正则式，满足时路由匹配
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator hostCustomRouteLocator (RouteLocatorBuilder builder){
//        String host1 = "**.cwx.cc.com:8080";
//        String host2 = "**.cwx.cc.net:8080";
//        return builder.routes().route("/testHost/**",r->r.host(host1,host2).uri("https://example.org/")).build();
//    }

    /**
     * Method路由断言工厂
     * 判断HTTP请求类型
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator methodCustomRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes().route("/testMethod/**",r->r.method(HttpMethod.GET).uri("https://example.org/")).build();
//    }

    /**
     * Path路由断言工厂
     * 判断请求路径正则
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator pathCustomRouteLocator(RouteLocatorBuilder builder){
//        String path1 = "/testPath/info";
//        String path2 = "/testPath/{id}";
//        String path3 = "/testPath/**";
//        return builder.routes().route("testPath",r->r.path(path1,path2,path3).uri("https://example.org/")).build();
//    }

    /**
     * Query 路由断言工厂
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator queryCustomRouteLocator(RouteLocatorBuilder builder){
//        String regex = "^[0-9]*$";
//        return builder.routes().route("testQuery",r->r.query("id",regex).uri("https://example.org/")).build();
//    }

    /**
     * RemoteAddr路由断言工厂
     * 判断远程服务器地址
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator remoteAddrCustomRouteLocator(RouteLocatorBuilder builder){
//        String addr1 = "192.168.75.0/0";
//        String addr2 = "192.168.75.0/32";
//        return builder.routes().route("testRemoteAddr",r->r.remoteAddr(addr1,addr2).uri("https://example.org/")).build();
//    }

    /**
     * Weight 路由断言工厂
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator weightCustomRouteLocator(RouteLocatorBuilder builder){
//        String path="/testWeight/**";
//        return builder.routes()
//                .route("testHighWeight",r->r.path(path).and().weight("myGoroup",80).uri("https://example.org/"))
//                .route("testLowWeight",r->r.path(path).and().weight("myGoroup",20).uri("https://www.springcloud.cc/"))
//                .build();
//    }


    /**
     * AddRequestHeader过滤器工厂
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator addRequestHeaderCustomRouteLocator(RouteLocatorBuilder builder){
//        String path = "/testAddRequestHeader/**";
//        return builder.routes()
//                .route("testAddRequestHeader",r->r.path(path)
//                        .filters(f->f.addRequestHeader("id","1"))
//                        .uri("https://example.org/"))
//                .build();
//    }

    /**
     * AddRequestParameter过滤器工厂
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator addRequestParamterCustomRouteLocator(RouteLocatorBuilder builder){
//        String path = "/testAddRequestParameter/**";
//        return builder.routes()
//                .route("testAddRequestParameter",r->r.path(path)
//                        .filters(f->f.addRequestParameter("id","1"))
//                        .uri("https://example.org/"))
//                .build();
//    }

    /**
     * AddResponseHeader过滤器工厂
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator addResponseHeaderCustomRouteLocator(RouteLocatorBuilder builder){
//        String path = "/testAddResponseHeader/**";
//        return builder.routes()
//                .route("testAddResponseHeader",r->r.path(path)
//                    .filters(f->f.addResponseHeader("id","1"))
//                    .uri("https://example.org/"))
//                .build();
//    }

    /**
     * Retry过滤器工厂（第一种方法）
     * 重试两次(不包含第一次)
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator retryCustomRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes().route("testRetry",r->r.path("/testRetry/**").filters(f->f.retry(2)).uri("https://example.org/")).build();
//    }

    /**
     * Retry过滤器工厂（第二种方法）
     * 重试两次(不包含第一次)
     * @param
     * @return
     */
//    @Bean
//    public RouteLocator retryCustomRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route("testRetry",r->r.path("/testRetry/**")
//                                            .filters(f->f.retry(retryConfig -> {
//                                                retryConfig.setRetries(2);
//                                                retryConfig.setMethods(HttpMethod.GET,HttpMethod.POST);
//                                                retryConfig.setStatuses(HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.BAD_REQUEST);
//                                                retryConfig.setSeries(HttpStatus.Series.SERVER_ERROR);
//                                                }))
//                                            .uri("https://example.org/"))
//                .build();
//    }


    @RequestMapping("/hystrixfallback")
    public String hystrixfallback() {
        return "This is a fallback";
    }

    /**
     * 自定义KeyResolver
     * 每次请求需携带参数userToken
     * @return
     */
//    @Bean
//    public KeyResolver userKeyResolver(){
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userToken"));
//    }

    /**
     * Hystrix 过滤器工厂
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator hystrixCustomRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes().route("testHystrix",r->r.path("/testHystrix/**").filters(f->f.hystrix(config -> {
//            config.setName("hystrix");
//            config.setFallbackUri("forward:/hystrixfallback");
//        })).uri("https://xxxx.com/")).build();
//    }

    /**
     * RewritePath过滤器工厂
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator rewritePathCustomRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes().route("testRewritePath",r->r.path("/testRewritePath/**").filters(f->f.rewritePath("/testRewritePath/aa","/bb")).uri("https://example.org/")).build();
//    }

//    /**
//     * SetStatus 过滤器工厂
//     * @param builder
//     * @return
//     */
//    @Bean
//    public RouteLocator setStatusCustomRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes().route("setStatus",r->r.path("/setStatus/**").filters(f->f.setStatus(HttpStatus.BAD_REQUEST.value())).uri("https://example.org/")).build();
//    }

    /**
     * StripPrefix 过滤器工厂
     * 对请求/aa/bb/mypath/的请求，转换为https://example.org/mypath
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator stripPrefixCustomRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes().route("stripPrefix",r->r.path("/aa/bb/**").filters(f->f.stripPrefix(2)).uri("https://example.org/")).build();
//    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("path_route", r -> r.path("/get")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://httpbin.org"))
//                .route("host_route", r -> r.host("*.myhost.org")
//                        .uri("http://httpbin.org"))
//                .route("rewrite_route", r -> r.host("*.rewrite.org")
//                        .filters(f -> f.rewritePath("/foo/(?<segment>.*)",
//                                "/${segment}"))
//                        .uri("http://httpbin.org"))
//                .route("hystrix_route", r -> r.host("*.hystrix.org")
//                        .filters(f -> f.hystrix(c -> c.setName("slowcmd")))
//                        .uri("http://httpbin.org"))
//                .route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
//                        .filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
//                        .uri("http://httpbin.org"))
//                .route("limit_route", r -> r
//                        .host("*.limited.org").and().path("/anything/**")
//                        .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
//                        .uri("http://httpbin.org"))
//                .route("websocket_route", r -> r.path("/echo")
//                        .uri("ws://localhost:9000"))
//                .build();
//    }

//    @Bean
//    RedisRateLimiter redisRateLimiter() {
//        return new RedisRateLimiter(1, 2);
//    }
//
//    @Bean
//    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
//        return http.httpBasic().and()
//                .csrf().disable()
//                .authorizeExchange()
//                .pathMatchers("/anything/**").authenticated()
//                .anyExchange().permitAll()
//                .and()
//                .build();
//    }
//
//    @Bean
//    public MapReactiveUserDetailsService reactiveUserDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
//        return new MapReactiveUserDetailsService(user);
//    }
}
