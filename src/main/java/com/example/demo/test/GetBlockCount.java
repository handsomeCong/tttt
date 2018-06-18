package com.example.demo.test;

import com.example.demo.util.HttpUtils;
import okhttp3.Response;

/**
 * @Auther: Spenser
 * @Date: 2018/6/18 10:27
 * @Description:
 */
public class GetBlockCount {

    public static void main(String[] args) throws Exception{
        Response s = HttpUtils.post("http://localhost:9888/get-block-count","{}");

        System.out.print(s.body().string());
    }
}
