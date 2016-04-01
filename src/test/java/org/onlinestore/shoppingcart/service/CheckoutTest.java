package org.onlinestore.shoppingcart.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.onlinestore.shoppingcart.service.CheckoutService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.onlinestore.shoppingcart.exception.EmptyCartException;
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
		List<Fruit> shoppingBasket = Arrays.asList(Fruit.APPLE);

		// When
		double total = checkoutService.total(shoppingBasket);

		// Then
		assertThat("The total price is incorrect ", total, is(0.60));
	}

	@Test
	public void total_should_calculate_correct_total_for_a_shopping_basket_for_a_single_orange() {
		// Given
		List<Fruit> shoppingBasket = Arrays.asList(Fruit.ORANGE);

		// When
		double total = checkoutService.total(shoppingBasket);

		// Then
		assertThat("The total price is incorrect ", total, is(0.25));
	}

	@Test
	public void total_should_calculate_correct_total_for_a_shopping_basket_with_mixed_fruits() {
		// Given
		List<Fruit> shoppingBasket = Arrays.asList(Fruit.APPLE, Fruit.APPLE,
				Fruit.ORANGE, Fruit.ORANGE, Fruit.APPLE);

		// When
		double total = checkoutService.total(shoppingBasket);

		// Then
		assertThat("The total price is incorrect ", total, is(1.70));
	}
	
	@Test(expected = EmptyCartException.class)
	public void should_throw_exception_for_null_cart() {
		// Given
		List<Fruit> shoppingBasket = null;

		// When
		double total = checkoutService.total(shoppingBasket);

	}
	
	@Test(expected = EmptyCartException.class)
	public void should_throw_exception_for_empty_cart() {
		// Given
		List<Fruit> shoppingBasket = new ArrayList<Fruit>();

		// When
		double total = checkoutService.total(shoppingBasket);

	}
	
	  @Test
	  public void total_should_calculate_correct_total_with_by_one_get_one_offer_for_apples() {
	      // Given (assumption, the cart has the correct number of apples based on the offer)
	      List<Fruit> shoppingBasket = Arrays.asList(Fruit.APPLE, Fruit.APPLE);
	 
	      // When
	      double total = checkoutService.total(shoppingBasket);
	 
	      // Then
	      assertThat("The total price is incorrect ", total, is(0.60));
	  }


}
