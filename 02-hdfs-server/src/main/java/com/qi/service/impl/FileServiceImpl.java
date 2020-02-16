package com.qi.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

import com.qi.service.FileService;

public class FileServiceImpl implements FileService{

	
	
	public boolean isExixtsByPath(String path) {
		
		File file =new File(path);
		
		return file.exists();
	}
	
	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {

		Configuration conf=new Configuration();
		Server server=new RPC.Builder(conf)
				.setProtocol(FileService.class)
				.setInstance(new FileServiceImpl())
				.setBindAddress("192.168.6.95")
				.setPort(8534).build();
		server.start();
		System.out.println("RPCServer启动");
	}

}
