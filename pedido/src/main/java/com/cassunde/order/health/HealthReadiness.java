package com.cassunde.order.health;

import com.cassunde.order.fetch.StockFetch;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Readiness
public class HealthReadiness implements HealthCheck {

    @Inject
    @RestClient
    private StockFetch stockFetch;

    @Override
    public HealthCheckResponse call() {

        try{
            stockFetch.getStock();
            return HealthCheckResponse.up("pode receber request");
        }catch (Exception e){
            return HealthCheckResponse.down("deu zebra");
        }
    }
}
