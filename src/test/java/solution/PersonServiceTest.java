package solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonServiceTest {
  private PersonRepository personRepository;
  private PersonService personService;
  
  @BeforeEach
  public void setUp() {
    personRepository = mock(PersonRepository.class);
    personService = new PersonService(personRepository);
  }

  @Test
  public void testGetPersonById() {
    long personId = 1L;
    Person mockPerson = new Person();
    mockPerson.setId(personId);
    when(personRepository.findById(personId)).thenReturn(Optional.of(mockPerson));

    Person result = personService.getPersonById(personId);

    assertEquals(personId, result.getId());
  }

  @Test
  public void testGetPersonByIdPersonNotFound() {
    long personId = 1L;
    when(personRepository.findById(personId)).thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(personId));
  }

  @Test
  public void testGetPersonByUsername() {
    String username = "testuser";
    Person mockPerson = new Person();
    mockPerson.setUsername(username);
    when(personRepository.findByUsername(username)).thenReturn(Optional.of(mockPerson));

    Person result = personService.getPersonByUsername(username);

    assertEquals(username, result.getUsername());
  }

  @Test
  public void testGetPersonByUsernamePersonNotFound() {
    String username = "testuser";
    when(personRepository.findByUsername(username)).thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> personService.getPersonByUsername(username));
  }

  @Test
  public void testCreatePerson() {
    Person personToCreate = new Person();
    when(personRepository.save(personToCreate)).thenReturn(personToCreate);

    Person result = personService.create(personToCreate);

    assertNotNull(result);
  }

}
