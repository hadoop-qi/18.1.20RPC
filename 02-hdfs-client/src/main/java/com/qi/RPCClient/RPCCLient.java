package com.qi.RPCClient;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import com.qi.service.FileService;

public class RPCCLient {

	public static void main(String[] args) throws IOException {
		Configuration conf=new Configuration();
		FileService proxy=RPC.getProxy(FileService.class, 
				FileService.versionID,
				new InetSocketAddress("192.168.6.95", 8534), 
				conf);
		
		boolean flag=proxy.isExixtsByPath("D:/hadoop");
		System.out.println(flag? "存在":"不存在");
		RPC.stopProxy(proxy);
	}
}
