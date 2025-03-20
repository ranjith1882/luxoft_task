package com.ark.sub;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.dto.ProbeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SubApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testInitializeValid() throws Exception
	{
		String jsonInput = "{\"direction\":\"S\",\"coOrdinates\":{\"x\":2,\"y\":3}}";
		mockMvc.perform(post("/explore/initialize")
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonInput)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}


}
