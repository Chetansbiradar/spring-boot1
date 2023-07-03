package com.chetan.springboot1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot1ApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	//why mocking?
	// we don't care about the underlying implementation of the layer. We mock the underlying layer and give it to the layer we are testing.
	// This can be done using Mockito.

	// we are testing the service layer. So we mock the repository layer.
    // we are testing the controller layer. So we mock the service layer.
    // we are testing the repository layer. So we mock the database layer.


}
