package com.example.demo.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.HttpUtils;
import okhttp3.Response;

/**
 * @Auther: Spenser
 * @Date: 2018/6/18 10:17
 * @Description:
 */
public class RechangeBTM {

    public static void main(String[] args) throws Exception{
        for(int i=1;i<40000;i++){
            Response s = HttpUtils.post("http://localhost:9888/get-block","{\"block_height\": "+i+"}");


            JSONObject json = JSONObject.parseObject(s.body().string());
            if (json.containsKey("status") && json.get("status").equals("success")) {
                JSONArray transactions = json.getJSONObject("data").getJSONArray("transactions");

                if(!transactions.isEmpty() && transactions.size()>0){
                    for(Object transaction: transactions){
                        JSONArray outputs = JSONObject.parseObject(transaction.toString()).getJSONArray("outputs");
                        for(Object output: outputs){
                            JSONObject outputInfo = JSONObject.parseObject(output.toString());
                            if(outputInfo.getString("type").equals("control")){
                                String id = outputInfo.getString("id");
                                Integer position = outputInfo.getInteger("position");
                                String assetId = outputInfo.getString("asset_id");
                                Integer amount = outputInfo.getInteger("amount");
                                String controlProgram = outputInfo.getString("control_program");
                                String address = outputInfo.getString("address");
                                JSONObject asset_definition = outputInfo.getJSONObject("asset_definition");
//                                System.out.println("id == "+id);
//                                System.out.println("position == "+position);
//                                System.out.println("amount == "+amount);
//                                System.out.println("assetId == "+assetId);
//                                System.out.println("controlProgram == "+controlProgram);
//                                System.out.println("address == "+address);
                                if(null !=asset_definition && !asset_definition.isEmpty()){
                                    System.out.println("blockNumber = "+i+"asset_definition == "+asset_definition);
                                }

                            }
                        }
                    }
                }
            }

//            System.out.print(json);
        }

    }
}
