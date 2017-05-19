package com.test.testSSI.remote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

/**
 * elasticsearch连接池的实现
 * 
 * Created by tgg on 16-3-17.
 * 
 * http://blog.csdn.net/u011404265/article/details/51322121
 */
public class ClientHelper {

	private Settings setting;

	private Map<String, Client> clientMap = new ConcurrentHashMap<String, Client>();

	private Map<String, Integer> ips = new HashMap<String, Integer>();

	private String clusterName = "elasticsearch";

	private ClientHelper() {
		init();
	}

	public static final ClientHelper getInstance() {
		return ClientHolder.INSTANCE;
	}

	private static class ClientHolder {
		private static final ClientHelper INSTANCE = new ClientHelper();
	}

	/**
	 * 初始化默认的client 
	 */
	public void init() {
		ips.put("118.89.110.248", 9300);
		setting = ImmutableSettings.settingsBuilder().put("cluster.name", clusterName).build();
		addClient(setting, getAllAddress(ips));
	}

	/**
	 * 获得所有的地址端口
	 *
	 * @return
	 */
	public List<InetSocketTransportAddress> getAllAddress(Map<String, Integer> ips) {
		List<InetSocketTransportAddress> addressList = new ArrayList<InetSocketTransportAddress>();
		for (String ip : ips.keySet()) {
			addressList.add(new InetSocketTransportAddress(ip, ips.get(ip)));
		}
		return addressList;
	}

	public Client getClient() {
		return getClient(clusterName);
	}

	public Client getClient(String clusterName) {
		return clientMap.get(clusterName);
	}

	@SuppressWarnings("resource")
	public void addClient(Settings setting, List<InetSocketTransportAddress> transportAddress) {
		Client client = new TransportClient(setting).addTransportAddresses(
				transportAddress.toArray(new InetSocketTransportAddress[transportAddress.size()]));
		clientMap.put(setting.get("cluster.name"), client);
	}
}