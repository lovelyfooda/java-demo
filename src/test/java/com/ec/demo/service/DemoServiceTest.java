package com.ec.demo.service;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ec.demo.spring.AppConfig;

/**
 * @ClassName: DemoServiceTest
 * @Description: 接口测试类
 * @author longqingping
 * @date 2016年10月14日 上午10:31:44
 */
public class DemoServiceTest {

    private static ApplicationContext ctx = null;

    @BeforeClass
    public static void before() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @After
    public void after() {
    }

    @Test
    public void accesstokenTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.accesstoken();
    }

    @Test
    public void structureTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.structure();
    }

    @Test
    public void getCustomFieldMappingTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.getCustomFieldMapping();
    }

    @Test
    public void getCustomerGroupTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.getCustomerGroup();
    }

    @Test
    public void getTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.get();
    }

    @Test
    public void getCustomerListTest() throws ClientProtocolException, IOException {
        final IDemoService demoService = ctx.getBean(IDemoService.class);
        ExecutorService ser = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50; i++) {
            ser.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        demoService.getCustomerList();
                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        ser.shutdown();
        try {
            ser.awaitTermination(100, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addCustomerTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.addCustomer();
    }

    @Test
    public void getLabelInfoTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.getLabelInfo();
    }

    @Test
    public void addLabelTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.addLabel();
    }

    @Test
    public void updateCustomerTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.updateCustomer();
    }

    @Test
    public void findUserTrajectoryTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.findUserTrajectory();
    }

    @Test
    public void findUserInfoByIdTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.findUserInfoById();
    }

    @Test
    public void telRecordHistoryTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.telRecordHistory();
    }

    @Test
    public void telRecordTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.telRecord();
    }

    @Test
    public void getChannelSourceTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.getChannelSource();
    }

    @Test
    public void getTrajectoryTest() throws ClientProtocolException, IOException {
        IDemoService demoService = ctx.getBean(IDemoService.class);
        demoService.getTrajectory();
    }

}
