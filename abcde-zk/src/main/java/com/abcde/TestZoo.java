package com.abcde;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class TestZoo {


    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {


                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println(watchedEvent);
                }
            }
        };

        ZooKeeper zoo = new ZooKeeper("127.0.0.1" , 5000, watcher);
        zoo.create("/a","abcdef".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        byte[] rs = zoo.getData("/a",true,new Stat());
        System.out.println(new String(rs));
    }


}
