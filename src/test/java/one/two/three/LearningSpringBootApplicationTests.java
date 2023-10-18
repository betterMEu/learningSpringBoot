package one.two.three;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LearningSpringBootApplicationTests {

	@LocalServerPort
	int port;

	@Test
	void contextLoads() {
		String str = "";
		System.out.println(str.replaceAll("\\n", "").replaceAll(" ", ""));
	}



}
