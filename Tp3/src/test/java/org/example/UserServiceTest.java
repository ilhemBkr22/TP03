package org.example;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

    private UserService userService;
    private UserRepository userRepositoryMock;

    @Before
    public void setUp() {
        userRepositoryMock = mock(UserRepository.class);
        userService = new UserService(userRepositoryMock);
    }

    @Test
    public void testGetUserById() {
        long userId = 123L;
        User u = new User(userId, "ilhem bekri");
        when(userRepositoryMock.findUserById(userId)).thenReturn(u);
        
        User u2 = userService.getUserById(userId);
      verify(userRepositoryMock).findUserById(userId);
      assertEquals(u, u2);
    }
}
