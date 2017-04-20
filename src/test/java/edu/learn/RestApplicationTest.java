package edu.learn;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RestApplicationTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void findByName() throws Exception {
		this.mvc.perform(
			get("/api/characters/search/findByNameAllIgnoringCase?name=Unity"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("species", equalTo("Hivemind")))
			.andExpect(jsonPath("age", equalTo(-1)));
	}

	@Test
	public void findByContaining() throws Exception {
		this.mvc.perform(
			get("/api/characters/search/findByStatusContainingAllIgnoringCase?status=Alive"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("_embedded.characters", hasSize(7)));
	}

}
