package com.kh.finalPrjAm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDTO {
    private String grantType; // 토큰의 형태
    private String accessToken;
    private Long tokenExpiresIn;
}
