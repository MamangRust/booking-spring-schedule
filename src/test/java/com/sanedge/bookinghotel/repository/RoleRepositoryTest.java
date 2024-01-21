package com.sanedge.bookinghotel.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import com.sanedge.bookinghotel.enums.ERole;
import com.sanedge.bookinghotel.models.Role;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testFindByName() {

        Optional<Role> role = roleRepository.findByName(ERole.ROLE_ADMIN);
        assertTrue(role.isPresent());
    }
}
