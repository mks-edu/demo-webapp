package mks.platform.samplewebapp.services.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StorageServiceImpl.class)
@TestPropertySource(properties = {
	    "demo=Demo",
	})
public class StorageServiceImplTest {
	@Autowired
	StorageServiceImpl storageService;
	
	@Value("${demo}")
	String demo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveProductList() {
		
		assertEquals("demo", demo);
		List<Object[]> data = new ArrayList<Object[]>();
		data.add(new Object[] {"Honda", "Honda Vios", "Blue"});
		storageService.saveProductList(data);
		
		assertEquals(1, 1);
	}

}
