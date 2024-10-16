package com.example.Gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
    @Autowired
    RouteValidator routeValidator;

//    @Autowired
//    RestClient restClient;

    AuthenticationFilter(){
        super(Config.class);
    }

    public static class Config {
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {

            if(routeValidator.isSecured.test(exchange.getRequest())){
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Missing Authorization Header");
                }
                String authHeaderToken=exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

                if(authHeaderToken!=null && authHeaderToken.startsWith("Bearer")){
                    authHeaderToken=authHeaderToken.substring(7);
                }
                try{
                    RestClient restClient=RestClient.create();
                    restClient
                            .get()
                            .uri("http://localhost:8090/api/auth/validate/token?token="+authHeaderToken)
                            .retrieve()
                            .body(Boolean.class);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                    throw new RuntimeException("Invalid Access!!"+e.getMessage());
                }

            }
            return chain.filter(exchange);
        });
    }
}
