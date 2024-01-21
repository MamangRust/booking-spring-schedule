package com.sanedge.bookinghotel.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import com.sanedge.bookinghotel.models.ResetToken;
import com.sanedge.bookinghotel.models.User;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ResetTokenRepositoryTest {

    @Autowired
    private ResetTokenRepository resetTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByToken() {
        Optional<ResetToken> resetToken = resetTokenRepository.findByToken("yourToken");
        assertTrue(resetToken.isPresent());
    }

    @Test
    public void deleteByUserId() {
        Optional<User> user = userRepository.findById(1L);

        resetTokenRepository.deleteByUserId(user.get().getId());
        assertTrue(true);
    }
}
