package com.ample16.springcloud.consumer.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

public class EncryptTest {
    public static void main(String[] args) {
        String pwd = "kaka2324125153sdgsdzsdff";
        String salt = "123";
        Md5Hash md5Hash = new Md5Hash(pwd, salt);
        System.out.println(md5Hash.toString());
        System.out.println(md5Hash.toBase64());
        System.out.println(md5Hash.toHex());
    }
}
