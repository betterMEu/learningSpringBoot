package one.two.three;

import jakarta.annotation.Resource;
import one.two.three.entity.TestUser;
import one.two.three.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LearningSpringBootApplicationTests {

	@LocalServerPort
	int port;

	@Resource
	private TestService testService;



	@WithMockUser(roles="ADMIN")
	@Test
	void readAccountWithAdminRoleThenInvokes() {
		System.out.println(testService.testMethodSafe());
		// ... assertions
	}

	@WithMockUser(username="owner")
	@Test
	void updateAccountsWhenOwnedThenReturns() {
		TestUser ownedBy = new TestUser("owner", 18);
		TestUser ownedBy1 = new TestUser("fghfg", 18);
		Collection<TestUser> ss = new ArrayList<>();
		ss.add(ownedBy1);
		ss.add(ownedBy);
		System.out.println(testService.updateAccounts(ss));
//		System.out.println(testService.updateAccounts(ownedBy1, ownedBy));

	}

	@Test
	void contextLoads() {
		String str = "";
		System.out.println(str.replaceAll("\\n", "").replaceAll(" ", ""));
	}



}
