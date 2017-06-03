package packageMain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App1Application.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Controller_ClassTest {

	@LocalServerPort
	private int port;
	private String url;
	private TestRestTemplate testRestTemplate = new TestRestTemplate();
	String actual;
	String expected;
	
	@Before
	public void beforeTest(){
		url="http://localhost:"+port+"/account";
	}
	
	@Test
	public void getAllTest_present() {
		actual=testRestTemplate.getForObject(url, String.class);
		expected="[{name:A},{name:B},{name:C},{name:D},{name:E}]";
		JSONAssert.assertEquals(expected, actual, false);
	}
	
	@Test
	public void getAllTest_notPresent(){
		actual=testRestTemplate.getForObject(url, String.class);
		JSONAssert.assertEquals("[]", actual, true);
	}
	
	@Test
	public void getTest_present(){
		actual=testRestTemplate.getForObject(url+"/1",String.class);
		JSONAssert.assertEquals("{name:A,accountNumber:1}", actual, false);
	}

	@Test(expected=NullPointerException.class)
	public void getTest_notPresent(){
		actual=testRestTemplate.getForObject(url+"/43",String.class);
		JSONAssert.assertEquals(null, actual, false);
	}
	
	@Test
	public void postTest(){
		actual=testRestTemplate.postForObject(url,new Account(43,"Singh",125000.0),String.class);
		assertEquals("Account Created", actual);
	}

}
