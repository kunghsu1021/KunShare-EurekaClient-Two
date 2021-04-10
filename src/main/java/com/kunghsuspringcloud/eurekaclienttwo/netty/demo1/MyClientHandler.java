package com.kunghsuspringcloud.eurekaclienttwo.netty.demo1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 客户端处理事件
 * Created by xuyaokun On 2021/4/10 17:12
 * @desc:
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 处理服务端返回的消息
     * @param ctx
     * @param msg
     * @throws Exception
     */
    //@Sharable
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //这里输出的线程名并不是发送消息的线程，输出的是netty的ioEventLoopGroup工作线程
        //选工作线程的机制是轮询的，所以这里每次看到的线程名都不一样
        System.out.println(Thread.currentThread().getName() + "client receieve message: "+msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(Thread.currentThread().getName() + "get client exception :"+cause.getMessage());
    }
}
