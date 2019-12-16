package com.microservives.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// the url is used when only sinngle instance of the service is running, hence hard coded the url
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
/* since multiple instances are runnning hence we use this */
//@FeignClient(name = "currency-exchange-service") if useing gateway user below
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	// @GetMapping("/currency-exchange/from/{from}/to/{to}") without APIGateWay
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);

}
