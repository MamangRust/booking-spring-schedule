package com.sanedge.bookinghotel.service;

import java.util.Optional;

import com.sanedge.bookinghotel.models.ResetToken;
import com.sanedge.bookinghotel.models.User;

public interface ResetTokenService {
    ResetToken createResetToken(User user);

    void deleteResetToken(Long userId);

    Optional<ResetToken> findByToken(String token);

    void updateExpiryDate(ResetToken resetToken);
}
