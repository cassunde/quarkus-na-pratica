package com.cassunde.order.services;

import com.cassunde.order.fetch.StockFetch;
import com.cassunde.order.model.vo.ProductVO;
import io.smallrye.faulttolerance.FaultToleranceBinding;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class StockServices {

    @Inject
    @RestClient
    private StockFetch stockFetch;

    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = 0.5,
            delay = 2000L,
            successThreshold = 2
    )
    @Fallback(fallbackMethod = "getStockFallback")
    public ProductVO getStock(){
        System.out.println("Try connect");
        return stockFetch.getStock();
    }

    public ProductVO getStockFallback(){
        return new ProductVO("PROD - FALLBACK", false);
    }
}
