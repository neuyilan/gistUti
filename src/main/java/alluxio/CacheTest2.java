//package alluxio.examples;
//
//import alluxio.hadoop.LocalCacheFileSystem;
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.nio.ByteBuffer;
//import java.nio.charset.StandardCharsets;
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.fs.FSDataInputStream;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.hdfs.DistributedFileSystem;
//
///**
// * @author HouliangQi (neuyilan@163.com)
// * @description
// * @since 2021-04-22 10:15
// */
//public class CacheTest2 {
//
//  private org.apache.hadoop.fs.FileSystem mExternalFileSystem;
//  private Configuration mHadoopConf;
//  private LocalCacheFileSystem localCacheFileSystem;
//
//
//  public CacheTest2() {
//
//  }
//
//  public void init() {
//    mHadoopConf = new Configuration();
//    mHadoopConf.set("fs.hdfs.impl", "alluxio.hadoop.LocalCacheFileSystem");
//    mHadoopConf.set("alluxio.user.local.cache.enabled", "true");
//    mHadoopConf.set("alluxio.user.client.cache.dir", "/tmp/qhl/alluxio");
//    mHadoopConf.set("alluxio.user.client.cache.store.type", "ROCKS");
//    mHadoopConf.set("alluxio.user.client.cache.async.write.enabled", "false");
//
//    org.apache.hadoop.fs.FileSystem fileSystem = new DistributedFileSystem();
//    fileSystem.setConf(mHadoopConf);
//    localCacheFileSystem = new LocalCacheFileSystem(fileSystem);
//  }
//
//  public void init2(String uriString) throws URISyntaxException, IOException {
//    URI uri = new URI(uriString);
//    localCacheFileSystem.initialize(uri, mHadoopConf);
//  }
//
//  public FSDataInputStream openFile(Path path) throws IOException {
//    FSDataInputStream cachingInputStream = localCacheFileSystem.open(path, 1024);
//    return cachingInputStream;
//  }
//
//
//  public void close() throws IOException {
//    localCacheFileSystem.close();
//  }
//
//  public static void main(String[] args) throws IOException, URISyntaxException {
//    CacheTest2 test = new CacheTest2();
//    test.init();
//    String uriStr = "hdfs://172.16.48.5:9000";
//    test.init2(uriStr);
//    String path = "/bii.parq";
//    System.out.println("11111111");
//    FSDataInputStream inputStream = test.openFile(new Path(path));
//    byte[] buffer = new byte[10];
//    int res = inputStream.read(buffer, 0, 10);
//    System.out.println("3333");
//    System.out.println(res + ", " + StandardCharsets.UTF_8.decode(ByteBuffer.wrap(buffer)));
//    System.out.println("66666");
//    inputStream.close();
//    test.close();
//  }
//}
