package com.ec.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.demo.common.Appconfiguration;
import com.ec.demo.common.ResourceURL;
import com.ec.demo.http.HttpRequest;

/**
 * @ClassName: DemoServiceImpl
 * @Description: demo服务接口实现
 * @author longqingping
 * @date 2016年10月14日 上午10:37:33
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private HttpRequest request;

    @Override
    public String accesstoken() throws ClientProtocolException, IOException {
        String param = "{\"appId\": " + Appconfiguration.appId + ",\"appSecret\": \"" + Appconfiguration.appSecret + "\"}";
        return request.tokenRequest(ResourceURL.ACCESSTOKEN, param);
    }

    @Override
    public String structure() throws ClientProtocolException, IOException {
        return request.businessRequest(ResourceURL.STRUCTURE, accesstoken(), "");
    }

    @Override
    public String getCustomFieldMapping() throws ClientProtocolException, IOException {
        return request.businessRequest(ResourceURL.GETCUSTOMFIELDMAPPING, accesstoken(), "{\"type\": 1}");
    }

    @Override
    public String getCustomerGroup() throws ClientProtocolException, IOException {
        return request.businessRequest(ResourceURL.GETCUSTOMERGROUP, accesstoken(), "{\"userId\": 2580461}");
    }

    @Override
    public String get() throws ClientProtocolException, IOException {
        /**
         * 主要针对精确查询客户资料的场景
         */
        String param = readFileByLines("get.xml");
        return request.businessRequest(ResourceURL.GET, accesstoken(), param);
    }

    @Override
    public String getCustomerList() throws ClientProtocolException, IOException {
        /**
         * 批量查询客户，用于查询公司所有客户的资料， 1.全量同步客户资料 通过createTime参数设置后面的时间为比当前时间点大来全量同步客户
         * 2.增量同步客户资料
         * 当新增一个客户的时候，modifyTime和createTime是相同的，后面修改客户资料的时候modifyTime会更新
         * ，createTime是始终不变的 增量同步客户资料可以通过modifyTime条件来获取新增的客户或者是资料更新的客户
         * 3.建议增量同步频率每5分钟一次 4.查询到的结果包含了公共库的客户
         */
        System.out.println(accesstoken());
        return null;
        // String param = readFileByLines("getCustomerList.xml");
        // return request.businessRequest(ResourceURL.GETCUSTOMERLIST,
        // accesstoken(), param);
    }

    private String readFileByLines(String fileName) {
        StringBuilder sb = new StringBuilder(System.getProperty("user.dir"));
        sb.append("\\src\\main\\resources\\").append(fileName);
        File file = new File(sb.toString());
        BufferedReader reader = null;
        StringBuilder result = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                result.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return result.toString().replaceAll(" ", "");
    }

    @Override
    public String addCustomer() throws ClientProtocolException, IOException {
        String param = readFileByLines("addCustomer.xml");
        return request.businessRequest(ResourceURL.ADDCUSTOMER, accesstoken(), param);
    }

    @Override
    public String create() throws ClientProtocolException, IOException {
        String param = readFileByLines("create.xml");
        return request.businessRequest(ResourceURL.CREATE, accesstoken(), param);
    }

    @Override
    public String getLabelInfo() throws ClientProtocolException, IOException {
        return request.businessRequest(ResourceURL.GETLABELINFO, accesstoken(), "");
    }

    @Override
    public String addLabel() throws ClientProtocolException, IOException {
        String param = readFileByLines("addLabel.xml");
        return request.businessRequest(ResourceURL.ADDLABEL, accesstoken(), param);
    }

    @Override
    public String updateCustomer() throws ClientProtocolException, IOException {
        String param = readFileByLines("updateCustomer.xml");
        return request.businessRequest(ResourceURL.UPDATECUSTOMER, accesstoken(), param);
    }

    @Override
    public String findUserTrajectory() throws ClientProtocolException, IOException {
        String param = readFileByLines("export.xml");
        return request.businessRequest(ResourceURL.FINDUSERTRAJECTORY, accesstoken(), param);
    }

    @Override
    public String findUserInfoById() throws ClientProtocolException, IOException {
        String param = readFileByLines("findUserInfo.xml");
        return request.businessRequest(ResourceURL.FINDUSERINFOBYID, accesstoken(), param);
    }

    @Override
    public String telRecordHistory() throws ClientProtocolException, IOException {
        String param = readFileByLines("telRecordHistory.xml");
        return request.businessRequest(ResourceURL.TELRECORDHISTORY, accesstoken(), param);
    }

    @Override
    public String getChannelSource() throws ClientProtocolException, IOException {
        return request.businessRequest(ResourceURL.GETCHANNELSOURCE, accesstoken(), "");
    }

    @Override
    public String getTrajectory() throws ClientProtocolException, IOException {
        String param = readFileByLines("getTrajectory.xml");
        return request.businessRequest(ResourceURL.GETTRAJECTORY, accesstoken(), param);
    }

    @Override
    public String telRecord() throws ClientProtocolException, IOException {
        String param = readFileByLines("telRecord.xml");
        return request.businessRequest(ResourceURL.TELRECORD, accesstoken(), param);
    }

}
