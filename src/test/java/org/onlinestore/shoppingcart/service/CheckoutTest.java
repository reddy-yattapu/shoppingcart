package org.onlinestore.shoppingcart.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.onlinestore.shoppingcart.service.CheckoutService;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.onlinestore.shoppingcart.model.Fruit;

public class CheckoutTest {

    private CheckoutService checkoutService;

	@Before
	public void setUp() throws Exception {
		checkoutService = new CheckoutService();
	}

    @Test
    public void total_should_calculate_correct_total_for_a_shopping_basket_for_a_single_apple() {
        // Given
        List<Fruit> shoppingBasket = Arrays.asList(Fruit.APPLE, Fruit.APPLE);

        // When
        double total = checkoutService.total(shoppingBasket);

        // Then
        assertThat("The total price is incorrect ", total, is(1.20));
    }
}
