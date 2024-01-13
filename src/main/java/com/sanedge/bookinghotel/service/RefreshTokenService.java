package com.sanedge.bookinghotel.service;

import java.util.Optional;

import com.sanedge.bookinghotel.models.RefreshToken;

public interface RefreshTokenService {
    Optional<RefreshToken> findByToken(String token);

    RefreshToken createRefreshToken(Long userId);

    RefreshToken verifyExpiration(RefreshToken token);

    int deleteByUserId(Long userId);
}
