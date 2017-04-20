package edu.learn.service;

import static org.assertj.core.api.Assertions.assertThat;

import edu.learn.domain.Gadget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class GadgetRepositoryTest {

	@Autowired
	GadgetRepository repository;

	@Test
	public void findAll() {
		Page<Gadget> gadgets = this.repository.findAll(new PageRequest(0, 2));
		assertThat(gadgets.getTotalElements()).isGreaterThan(2L);
	}

	@Test
	public void findByTypeContainingAllIgnoringCase() {
		Page<Gadget> gadgets = this.repository
			.findByTypeContainingAllIgnoringCase("robot", new PageRequest(0, 10));
		assertThat(gadgets.getTotalElements()).isEqualTo(2);
	}

	@Test
	public void findByNameIgnoringCase() {
		Gadget gadget = this.repository.findByNameIgnoringCase("Interdimensional Cable");
		assertThat(gadget).isNotNull();
		assertThat(gadget.getType()).isEqualTo("Machine");
	}
}