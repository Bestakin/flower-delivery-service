package com.example.flower_delivery.service;

import com.example.flower_delivery.entity.Delivery;
import com.example.flower_delivery.entity.Plant;
import com.example.flower_delivery.repository.PlantRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FlowerDeliveryServiceApplicationTests {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	PlantRepository plantRepository;

	@Test
	public void testPriceLessThan() {
		Plant p = testEntityManager.persist(new Plant("Foo Leaf", 4.99));
		testEntityManager.persist(new Plant("Bar Weed", 5.01));

		List<Plant> cheapPlants = plantRepository.findByPriceLessThan(BigDecimal.valueOf(5));
		Assertions.assertEquals(1, cheapPlants.size(), "Size should be 1");
		Assertions.assertEquals(p.getId(), cheapPlants.get(0).getId(), "IDs should match");
	}

	@Test
	public void testDeliveryCompleted() {
		Plant p = testEntityManager.persist(new Plant("Baz Root", 9.99));
		Delivery d = testEntityManager.persist(
				new Delivery("Leonard Bernstein", "234 West Side", LocalDateTime.now())
		);

		d.setPlants(Lists.newArrayList(p));
		p.setDelivery(d);

		Assertions.assertFalse(plantRepository.deliveryCompleted(p.getId()), "Should not be completed yet");

		d.setCompleted(true);
		Assertions.assertTrue(plantRepository.deliveryCompleted(p.getId()), "Should be completed now");
	}
}
