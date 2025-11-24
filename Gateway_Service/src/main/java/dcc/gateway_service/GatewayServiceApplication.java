package dcc.gateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    /*
    @Bean
    RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/v1/enseignants/**").uri("http://localhost:8081"))
                .route(r -> r.path("/v1/chercheurs/**").uri("http://localhost:8082"))
                .route(r -> r.path("/v1/projets/**").filters(f -> f.addRequestParameter("a", "5")).uri("http://localhost:8083"))
                .build();
    }
    */

    @Bean
    DiscoveryClientRouteDefinitionLocator Locator
            (ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){

        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }
}
