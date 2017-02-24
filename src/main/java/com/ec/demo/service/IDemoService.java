package com.ec.demo.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

/**
 * @ClassName: IDemoService
 * @Description: demo服务接口
 * @author longqingping
 * @date 2016年10月14日 上午10:04:00
 */
public interface IDemoService {

    /**
     *
     * @Title: accesstoken
     * @Description: 获取accesstoken
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String accesstoken() throws ClientProtocolException, IOException;

    public String findUserInfoById() throws ClientProtocolException, IOException;

    /**
     *
     * @Title: structure
     * @Description: 获取部门及员工信息
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String structure() throws ClientProtocolException, IOException;

    /**
     *
     * @Title: getCustomFieldMapping
     * @Description: 获取自定义字段信息
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String getCustomFieldMapping() throws ClientProtocolException, IOException;

    /**
     *
     * @Title: getCustomerGroup
     * @Description: 获取某个员工客户库分组信息
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String getCustomerGroup() throws ClientProtocolException, IOException;

    /**
     *
     * @Title: get
     * @Description: 批量精确查询客户
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String get() throws ClientProtocolException, IOException;

    /**
     *
     * @Title: getCustomerList
     * @Description: 批量范围查询客户
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String getCustomerList() throws ClientProtocolException, IOException;

    /**
     *
     * @Title: addCustomer
     * @Description: 创建客户
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String addCustomer() throws ClientProtocolException, IOException;

    /**
     *
     * @Title: addCustomer
     * @Description: 获取标签信息
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String getLabelInfo() throws ClientProtocolException, IOException;

    /**
     *
     * @Title: addLabel
     * @Description: 批量添加客户标签
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String addLabel() throws ClientProtocolException, IOException;

    /**
     *
     * @Title: updateCustomer
     * @Description: 修改客户资料
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String updateCustomer() throws ClientProtocolException, IOException;

    /**
     *
     * @Title: findUserTrajectory
     * @Description: 修改客户资料
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String findUserTrajectory() throws ClientProtocolException, IOException;

    /**
     * @Title: create
     * @Description: TODO
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @return String
     * @throws
     */
    public String create() throws ClientProtocolException, IOException;

    public String telRecordHistory() throws ClientProtocolException, IOException;

    public String telRecord() throws ClientProtocolException, IOException;

    public String getChannelSource() throws ClientProtocolException, IOException;

    public String getTrajectory() throws ClientProtocolException, IOException;

}
