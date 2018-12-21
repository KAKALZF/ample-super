package com.ample16.springcloud.consumer.shiro.util;

import com.ample16.springcloud.consumer.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private static final String ALGORITHMNAME = "md5";
    private static final int hashiterations = 2;

    public static void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                ALGORITHMNAME,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                hashiterations).toHex();
        user.setPassword(newPassword);
    }

    public static void main(String[] args) {
        System.out.println(randomNumberGenerator.nextBytes().toHex());
    }
}
