package com.javapoint.servicetest;
import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.javapoint.entities.User;
import com.javapoint.repository.UserRepo;
import com.javapoint.service.UserService;


@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepo userRepo;

	@Test
	public void getUserTest() {
		when(userRepo.findAll()).thenReturn((List<User>) 
		Stream.of(new User(11, "Hema", "Latha", "female", 22, "9640969876", "hema@gmail.com", "Hemalatha","Hema"))
				.collect(Collectors.toList()));
		assertEquals(1, userService.getAllUserDetails().size());
	}

	@Test
	public void saveUserTest() {
		User user = new User(19,"Hema", "Latha", "female", 22, "9640969876", "hema@gmail.com", "Hemalatha","Hema");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userService.saveUserDetails(user));
	}

	@Test
	public void getUserByIdTest() {
		int id = 1;
		User user = new User(11, "Hema", "Latha", "female", 22, "9640969876", "hema@gmail.com", "Hemalatha","Hema");
		when(userRepo.findById(1)).thenReturn((user));
		assertEquals(user, userService.getUserDetailsById(id));
	}

	@Test
	public void deleteUserTest() {
		User user = new User(20, "Hema", "Latha", "female", 22, "9640969876", "hema@gmail.com", "Hemalatha","Hema");
		userService.deleteUserById(1);
		verify(userRepo, times(0)).delete(user);
	}

}

