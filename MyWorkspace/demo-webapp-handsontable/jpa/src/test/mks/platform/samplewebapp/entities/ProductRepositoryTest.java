package mks.platform.samplewebapp.entities;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mks.platform.samplewebapp.entity.Product;
import mks.platform.samplewebapp.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProductRepository.class)
@EnableJpaRepositories(basePackageClasses = ProductRepository.class)
//@EntityScan(basePackageClasses = Product.class)
//@TestPropertySource(properties = {
//    "azure.clientId=f6d8b0ca-8012-4e8a-b815-c827202f23f3",
//    "azure.tenantId=24da48c7-889d-4865-81c5-272a77bc88e2",
//    "azure.scope=https://graph.microsoft.com/.default",
//    "azure.clientSecret=s018Q~yBmbskzMOexqx_QAohUstiDb1dQGeKBa3W",
//    "user.attributes=id, displayName, givenName, mail, surname, userPrincipalName, jobTitle, officeLocation",
//    "cached.folder=D:/Temp/"
//})
@ExtendWith(SpringExtension.class)
public class ProductRepositoryTest {
	
	@Autowired
	ProductRepository productRepo;

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
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveAllIterableOfS() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		Product e = new Product(null, "A", "B", "White");
		Product p = productRepo.save(e );
		
		assertNotNull(p.getId());
	}

}
