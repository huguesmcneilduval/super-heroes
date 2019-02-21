package ca.philippeduval.superheroes.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ca.philippeduval.superheroes.beans.Mission;
import ca.philippeduval.superheroes.beans.SuperHero;
import ca.philippeduval.superheroes.repositories.SuperHeroRepository;
import ca.philippeduval.superheroes.services.exceptions.BadRequestException;
import ca.philippeduval.superheroes.services.impl.SuperHeroServiceImpl;

public class SuperHeroServiceTest {

    SuperHeroRepository repoMock;

    SuperHeroService service;

    @Before
    public void before() {
        service = new SuperHeroServiceImpl();
        repoMock = mock(SuperHeroRepository.class);
        ((SuperHeroServiceImpl) service).setRepository(repoMock);
    }

    @Test
    public void testCreate_withValidHero_shouldPass() throws BadRequestException {

        // Arrange
        SuperHero s1 = new SuperHero("toot", "tata", "oprgojie", new ArrayList<Mission>());
        when(repoMock.save(Mockito.any())).thenReturn(s1);

        // Act
        SuperHero heroCreated = new SuperHero();
        heroCreated = service.create(s1);

        Assert.assertEquals("Hero is well the hero created", s1, heroCreated);

    }

    @Test(expected = BadRequestException.class)
    public void testCreate_withHeroWithInvalidMission_shouldThrowBadRequestException() throws BadRequestException {

        // Arrange
        List<Mission> list = new ArrayList<Mission>();
        Mission m1 = new Mission();

        list.add(m1);

        SuperHero s1 = new SuperHero("toot", "tata", "oprgojie", list);

        when(repoMock.save(Mockito.any())).thenThrow(new RuntimeException());

        // Act
        service.create(s1);


        // Assert
        Assert.fail("Should not reach. Meaning service accepted invalid mission in SuperHero");

    }

}
