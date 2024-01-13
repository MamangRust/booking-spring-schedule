package com.sanedge.bookinghotel.service.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanedge.bookinghotel.models.ResetToken;
import com.sanedge.bookinghotel.models.User;
import com.sanedge.bookinghotel.repository.ResetTokenRepository;
import com.sanedge.bookinghotel.service.ResetTokenService;

@Service
public class ResetTokenServiceImpl implements ResetTokenService {
    @Autowired
    private ResetTokenRepository resetTokenRepository;

    @Override
    public ResetToken createResetToken(User user) {
        ResetToken resetToken = new ResetToken();
        resetToken.setUser(user);
        resetToken.setToken(UUID.randomUUID().toString());
        resetToken.setExpiryDate(Instant.now().plus(24, ChronoUnit.HOURS)); // Token expiry in 24 hours
        return resetTokenRepository.save(resetToken);
    }

    @Override
    public void deleteResetToken(Long userId) {
        resetTokenRepository.deleteByUserId(userId);
    }

    @Override
    public Optional<ResetToken> findByToken(String token) {
        return resetTokenRepository.findByToken(token);
    }

    @Override
    public void updateExpiryDate(ResetToken resetToken) {
        resetToken.setExpiryDate(Instant.now().plus(24, ChronoUnit.HOURS));
        resetTokenRepository.save(resetToken);
    }
}
