package org.lagou.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * hdfs客户端Demo
 *
 * @author guoqing
 * @since ： 2020/7/9 18:35
 */
public class HdfsClientDemo {
    public static void main(String[] args) throws URISyntaxException, IOException,
            InterruptedException {
        // 1 获取⽂文件系统
        Configuration configuration = new Configuration();
        configuration.set("dfs.replication", "2");
        FileSystem fs = FileSystem.get(new URI("hdfs://master:9000"),
                configuration, "root");
        // 2 上传⽂文件
        fs.copyFromLocalFile(new Path("e:/lagou.txt"), new
                Path("/lagou.txt"));
        // 3 关闭资源
        fs.close();
        System.out.println("end");
    }
}
