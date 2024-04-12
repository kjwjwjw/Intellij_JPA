package com.example.boot2.comm;

import org.junit.jupiter.api.Test;

class cm_encrypTest {


    /*
     단방향 암호화
     */
    @Test
    void encryptSha256() {

        Cm_encrypt cmEncrypt = new Cm_encrypt();

        String strName="1234";
        System.out.println(cmEncrypt.encryptSha256(strName));
    }


    /*
     양방향 암호화
     */
    @Test
    void encryptAes() throws Exception {
        Cm_encrypt cmEncrypt = new Cm_encrypt();

        String strKey16="ABCdefg123456plm";
        String strName="홍길동 아버지는 누구인가";

        System.out.println(cmEncrypt.encryptAes(strName, strKey16));

    }

    /*
     복호화
     */
    @Test
    void decryptAes() throws Exception {
        Cm_encrypt cmEncrypt = new Cm_encrypt();

        String strKey16="ABCdefg123456plm";
        String strName="SPKO6H7KLWeK7A8nyPZDbxUzxsKFauBgef4U+Ac8e2ynxl/4odo0KRYvAAiLEUqD";

        System.out.println(cmEncrypt.decryptAes(strName, strKey16));
    }
}