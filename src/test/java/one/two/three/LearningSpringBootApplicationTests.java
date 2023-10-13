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
		String str = "{\n" +
				"  \"pagination\": {\n" +
				"    \"total\": 10419,\n" +
				"    \"pageSize\": 20,\n" +
				"    \"page\": 1\n" +
				"  },\n" +
				"  \"filters\": {},\n" +
				"  \"sorter\": {},\n" +
				"  \"searchTextMap\": {},\n" +
				"  \"searchParams\": {\n" +
				"  },\n" +
				"  \"sqlParams\": {},\n" +
				"  \"initParams\": {},\n" +
				"  \"sign\": \"zhxg_gyxt_fjgl\"\n" +
				"}";
		System.out.println(str.replaceAll("\\n", "").replaceAll(" ", ""));
	}



}
