package com.wishalpha.schoolmanagement.master.service.impl;

import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.DataAlreadyExistsException;
import com.wishalpha.schoolmanagement.common.utils.enums.Gender;
import com.wishalpha.schoolmanagement.master.dtos.user.CreateUserDTO;
import com.wishalpha.schoolmanagement.master.dtos.user.UserDTO;
import com.wishalpha.schoolmanagement.master.entities.UserEntity;
import com.wishalpha.schoolmanagement.master.mapper.UserMapper;
import com.wishalpha.schoolmanagement.master.repository.UserRepository;
import com.wishalpha.schoolmanagement.master.utils.CodeGenerator;
import com.wishalpha.schoolmanagement.master.utils.enums.AccountStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@Slf4j
@DisplayName("User Service Unit Tests")
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private CodeGenerator codeGenerator;


    @InjectMocks
    private UserServiceImpl userService;

    private CreateUserDTO createUserDTO;
    private UserEntity user;

    @BeforeEach
    void setUp(){

        createUserDTO = new CreateUserDTO();
        createUserDTO.setName("Priyanshu Chourasia");
        createUserDTO.setDob(LocalDate.of(2000, Month.OCTOBER,6));
        createUserDTO.setEmail("admin@admin.com");
        createUserDTO.setAccountStatus(AccountStatus.ACTIVE);
        createUserDTO.setGender(Gender.MALE);
        createUserDTO.setContactNo("6203163193");
        createUserDTO.setAltContactNo("900000000");


        user = new UserEntity();
        user.setPassword("1234567890");
        user.setCode("PRI-001");
    }

    @Nested
    @DisplayName("createUser()")
    class CreateUserTests{

        @Test
        @DisplayName("should throw exception if user exists by email")
        void shouldThrowExceptionIfUserExists(){
            when(userRepository.existsByEmail("admin@admin.com")).thenReturn(true);

            assertThrows(
                    DataAlreadyExistsException.class,
                    ()-> userService.create(createUserDTO)
            );
            verify(userRepository,never()).save(any());
        }

        @Test
        @DisplayName("Should create User with password encoded")
        void shouldCreateUserWithPasswordEncoder(){
//            Given
            when(userRepository.existsByEmail("admin@admin.com")).thenReturn(false);
            when(passwordEncoder.encode("1234567890")).thenReturn("1234567890");
            when(codeGenerator.generateCode(createUserDTO.getEmail())).thenReturn("PRI-001");
            when(userRepository.save(any(UserEntity.class))).thenReturn(user);

//            When
            UserDTO result = userService.create(createUserDTO);

//            Then
            assertNotNull(result);
            verify(passwordEncoder,times(1)).encode("1234567890");
            verify(codeGenerator,times(1)).generateCode("admin@admin.com");
            verify(userRepository,times(1)).save(any(UserEntity.class));
        }
    }
}