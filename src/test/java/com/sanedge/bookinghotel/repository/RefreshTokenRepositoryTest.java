package com.sanedge.bookinghotel.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import com.sanedge.bookinghotel.models.RefreshToken;
import com.sanedge.bookinghotel.models.User;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RefreshTokenRepositoryTest {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByToken() {
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByToken("yourToken");
        assertTrue(refreshToken.isPresent(), "Refresh token should be present");
    }

    @Test
    public void testFindByUser() {

        Optional<User> user = userRepository.findByUsername("yanto");

        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByUser(user.get());
        assertTrue(refreshToken.isPresent(), "Refresh token should be present for the given user");
    }

    @Test
    public void testDeleteByUser() {
        User user = new User();

        user.setUsername("yanto");
        user.setEmail("yanto@gmail.com");
        user.setPassword("yanto123");

        userRepository.save(user);

        refreshTokenRepository.deleteByUser(user);

        Optional<RefreshToken> deletedRefreshToken = refreshTokenRepository.findByUser(user);
        assertFalse(deletedRefreshToken.isPresent(), "Refresh token should be deleted for the given user");
    }
}
