package br.edu.atitus.currency_service.clients;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CurrencyBCFallback implements CurrencyBCClient{

	@Override
	public CurrencyBCResponse getCurrencyBC(String moeda) {
	    CurrencyBCResponse currency = new CurrencyBCResponse();
	    CurrencyBCResponse.values fallbackValue = new CurrencyBCResponse.values();
	    fallbackValue.setCotacaoVenda(-1.0);
	    currency.setValue(List.of(fallbackValue));
	    return currency;
	}

}
