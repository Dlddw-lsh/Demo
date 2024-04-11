package org.lsh.rpc.provider;

import org.lsh.rpc.netty.server.NettyServer;

// 启动一个服务的提供者即NettyServer
public class ServerBootstrap {
    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1", 7000);
    }
}
