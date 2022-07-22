package com.zc;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author yeyu
 * @since 2022/7/20 15:51
 */
public class BasicDemo {
    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181").connectionTimeoutMs(200)
                .retryPolicy(new RetryOneTime(30)).build();
        client.start();
        client.getData().usingWatcher(new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getType() == Event.EventType.NodeDataChanged) {
                    System.out.println("node data changed,path:"+ event.getPath());
                }
            }
        }).forPath("/school");
        Thread.sleep(Integer.MAX_VALUE);
    }

    class Lock {
        public void lock() {

        }

        public void unLock() {

        }
    }
}
