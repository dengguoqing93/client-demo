package org.lagou.mr;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

/**
 * HdfsClientDemo Tester.
 *
 * @author $author
 * @version 1.0
 * @since <pre>07/10/2020</pre>
 */
public class HdfsClientDemoTest {

    FileSystem fs;

    @Before
    public void before() throws Exception {
        Configuration configuration = new Configuration();
        configuration.set("dfs.replication", "2");
        fs = FileSystem.get(new URI("hdfs://master:9000"),
                configuration, "root");
    }

    @After
    public void after() throws Exception {
        fs.close();
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
        //TODO: Test goes here... 
    }

    @Test
    public void testCopyFromLocal() throws IOException {
        // 2 上传⽂文件
        fs.copyFromLocalFile(new Path("e:/lagou.txt"), new
                Path("/lagou.txt"));
    }


}
