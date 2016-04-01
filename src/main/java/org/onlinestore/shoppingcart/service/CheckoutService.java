package org.onlinestore.shoppingcart.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.onlinestore.shoppingcart.model.Fruit;

/**
 * online store checkout Service.
 */
public class CheckoutService {
	
    private static final Map<Fruit, Double> priceCatalog = new HashMap<Fruit, Double>();

    static {
        priceCatalog.put(Fruit.APPLE, 0.60);
    }
    
    public double total(final List<Fruit> shoppingBasket) {
    	 return shoppingBasket.stream().map(priceCatalog::get)
    			 	.reduce(0D, (runningResult, currElement) -> runningResult + currElement);
    }
}
