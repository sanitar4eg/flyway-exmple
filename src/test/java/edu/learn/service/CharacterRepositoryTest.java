package edu.learn.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import edu.learn.domain.Character;
import org.junit.Assert;
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
public class CharacterRepositoryTest {

	@Autowired
	CharacterRepository repository;

	@Test
	public void findsFirstPageOfCities() {
		Page<Character> characters = this.repository.findAll(new PageRequest(0, 5));
		assertThat(characters.getTotalElements()).isGreaterThan(6L);
	}

	@Test
	public void findByStatusContainingAllIgnoringCase() {
		Page<Character> characters = this.repository
			.findByStatusContainingAllIgnoringCase("Died", new PageRequest(0, 10));
		assertThat(characters.getTotalElements()).isEqualTo(1);
	}

	@Test
	public void findByNameAllIgnoringCase() {
		Character character = this.repository.findByNameAllIgnoringCase("Birdperson");
		assertThat(character).isNotNull();
		assertThat(character.getSpecies()).isEqualTo("Bird person");
	}
}