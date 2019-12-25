package com.linkpets.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.linkpets.model.SysUser;

/**
 * @Author Edie
 */
public class TokenUtils {

    public String getToken(SysUser user) {
        return JWT.create().withAudience(user.getUserId()).sign(Algorithm.HMAC256(user.getPassword()));
    }

}
