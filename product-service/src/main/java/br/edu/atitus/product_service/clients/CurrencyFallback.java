package br.edu.atitus.product_service.clients;

import org.springframework.stereotype.Component;

@Component
public class CurrencyFallback implements CurrencyClient{

	@Override
	public CurrencyResponse getCurrency(double value, String source, String target) {
		CurrencyResponse fallbackResponse = new CurrencyResponse();
		fallbackResponse.setConvertedValue(-1.0);
		return fallbackResponse;
	}

}