package com.sanedge.bookinghotel.service;

import com.sanedge.bookinghotel.domain.request.auth.ForgotRequest;
import com.sanedge.bookinghotel.domain.request.auth.LoginRequest;
import com.sanedge.bookinghotel.domain.request.auth.RegisterRequest;
import com.sanedge.bookinghotel.domain.request.auth.ResetPasswordRequest;
import com.sanedge.bookinghotel.domain.response.MessageResponse;
import com.sanedge.bookinghotel.domain.response.auth.TokenRefreshResponse;
import com.sanedge.bookinghotel.models.User;

public interface AuthService {
    public MessageResponse login(LoginRequest loginRequest);

    public MessageResponse register(RegisterRequest registerRequest);

    public TokenRefreshResponse refreshToken(String refreshToken);

    User getCurrentUser();

    public MessageResponse logout();

    public MessageResponse forgotPassword(ForgotRequest request);

    public MessageResponse resetPassword(ResetPasswordRequest request);

    public MessageResponse verifyEmail(String token);
}
