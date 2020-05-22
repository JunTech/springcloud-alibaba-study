package top.juntech.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/22 11:13
 * @ClassName 类名
 * @Descripe 描述
 */
//@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("payment_route",
                r->r.path("/payment/get/**").uri("http://localhost:8001")).build();

        return routes.build();
    }
}
