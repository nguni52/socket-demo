package za.co.expertism;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SocketDemoApplication.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class SocketDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
