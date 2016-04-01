package org.onlinestore.shoppingcart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.onlinestore.shoppingcart.exception.EmptyCartException;
import org.onlinestore.shoppingcart.model.Fruit;

/**
 * online store checkout Service.
 */
public class CheckoutService {

	private static final Map<Fruit, Double> priceCatalog = new HashMap<Fruit, Double>();

	static {
		priceCatalog.put(Fruit.APPLE, 0.60);
		priceCatalog.put(Fruit.ORANGE, 0.25);
	}

	private Function<List<Fruit>, Double> BUY_ONE_GET_ONE_DISCOUNT_FOR_APPLES = (fruits ) -> {
			long count = fruits.stream().filter(fruit -> fruit == Fruit.APPLE).count();
			return count > 1 ? priceCatalog.get(Fruit.APPLE) * (count/2) : 0.0d;
	};

	public double total(final List<Fruit> shoppingBasket) {
		if (shoppingBasket == null || shoppingBasket.isEmpty()) {
			throw new EmptyCartException("Cart should not be empty before checkout");
		}

		double totalWithoutDiscount = shoppingBasket
				.stream()
				.map(priceCatalog::get)
				.reduce(0D,
						(runningResult, currElement) -> runningResult
								+ currElement);
		double netPrice =  totalWithoutDiscount	- BUY_ONE_GET_ONE_DISCOUNT_FOR_APPLES.apply(shoppingBasket);
		return (double) Math.round(netPrice * 100) / 100;


	}
}
