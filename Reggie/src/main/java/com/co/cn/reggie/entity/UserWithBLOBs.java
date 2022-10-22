package com.co.cn.reggie.entity;

import lombok.Data;

@Data
public class UserWithBLOBs extends User {
    private byte[] sslCipher;

    private byte[] x509Issuer;

    private byte[] x509Subject;

    private String authenticationString;
}