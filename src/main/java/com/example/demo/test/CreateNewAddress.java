package com.example.demo.test;

import com.example.demo.util.HttpUtils;
import okhttp3.Response;

/**
 * @Auther: Spenser
 * @Date: 2018/6/15 16:45
 * @Description:
 */
public class CreateNewAddress {

    public static void main(String[] args) throws Exception {
        Response s = HttpUtils.post("http://localhost:9888/create-account-receiver","{\"account_alias\": \"spenser\", \"account_id\": \"0F31LCK700A02\"}");

        System.out.print(s.body().string());
    }
}
