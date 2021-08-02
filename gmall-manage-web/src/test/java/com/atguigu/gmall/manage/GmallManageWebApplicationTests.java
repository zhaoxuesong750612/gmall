package com.atguigu.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws MyException, IOException {
        //配置fdfs的全局链接
        String tacker = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(tacker);
        TrackerClient trackerClient = new TrackerClient();

        //获得trackerServer的实例
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        //通过trackerServer获得一个storage的连接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);

        String[] uploadInfos = storageClient.upload_file("/Users/zhaoxuesong/Downloads/VueProj/build-a-bot/src/data/images/head-big-eye.png", "png", null);
        for (String uploadInfo : uploadInfos) {
            System.out.println(uploadInfo);
        }
    }
}
