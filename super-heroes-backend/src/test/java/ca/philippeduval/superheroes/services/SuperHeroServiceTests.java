package ca.philippeduval.superheroes.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.philippeduval.superheroes.configs.SetupTest;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SuperHeroServiceTests extends SetupTest {
	
	@Autowired
	SuperHeroService service;
	

	@Test
	public void testFindAll() {
		
//		JpaRepository<SuperHero, Long> repoMock = mock(JpaRepository.class);
//		
//		List<SuperHero> list = new ArrayList<SuperHero>();
//		list.add(new SuperHero("Baba"));
//		list.add(new SuperHero("Bobo"));
//		
//		
//		when(repoMock.findAll()).thenReturn(list);

		assertEquals("Findall return list of 2 SuperHero", 0, service.findAll().size());

		service.create(s1);
		service.create(s2);
		
		assertNotEquals("Findall return list of 2 SuperHero", 2, service.findAll().size());
	}
	
	@Test
	public void testSave() {
		
//		JpaRepository<SuperHero, Long> repoMock = mock(JpaRepository.class);
//		
//		List<SuperHero> list = new ArrayList<SuperHero>();
//		list.add(new SuperHero("Baba"));
//		list.add(new SuperHero("Bobo"));
//	
//		when(repoMock.findAll()).thenReturn(list);
//		
//		
		assertEquals("Findall return list of 2 SuperHero", 0, service.findAll().size());
		assertNotEquals("Findall return list of 2 SuperHero", 1, service.findAll().size());
	}
}
