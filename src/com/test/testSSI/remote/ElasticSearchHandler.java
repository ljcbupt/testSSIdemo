package com.test.testSSI.remote;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;;

public class ElasticSearchHandler {
	
	private Client client;

	public ElasticSearchHandler() {
		ClientHelper ch = ClientHelper.getInstance();
		client = ch.getClient();
	}

	/**
	 * 执行搜索
	 * 
	 * @param queryBuilder
	 * @param indexname
	 * @param type
	 * @return
	 * @throws ParseException
	 */
	public List<MatrixData> searcher(QueryBuilder queryBuilder, String indexname, String type) throws ParseException {
		List<MatrixData> list = new ArrayList<MatrixData>();
		SearchResponse sr = client.prepareSearch(indexname).setTypes(type).setQuery(queryBuilder).execute().actionGet();
		SearchHits hits = sr.getHits();
		System.out.println("查询到记录数=" + hits.getTotalHits());
		SearchHit[] sh = hits.getHits();
		if (sh.length > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for (SearchHit hit : sh) {
				String storeid = (String) hit.getSource().get("storeid");
				String storename = (String) hit.getSource().get("storename");
				Date generationtime = sdf.parse(hit.getSource().get("generationtime").toString());
				String productkeywords = (String) hit.getSource().get("productkeywords");
				Integer reviewcount = (Integer) hit.getSource().get("reviewcount");
				String preimg = (String) hit.getSource().get("preimg");
				String productid = (String) hit.getSource().get("productid");
				String productdirectory = (String) hit.getSource().get("productdirectory");
				String productdirectorys = (String) hit.getSource().get("productdirectorys");
				Double minprice = (Double) hit.getSource().get("minprice");
				Integer orders = (Integer) hit.getSource().get("orders");
				Integer quantity = (Integer) hit.getSource().get("quantity");
				Integer salesweek1 = (Integer) hit.getSource().get("salesweek1");
				Integer paymentweek1 = (Integer) hit.getSource().get("paymentweek1");
				Integer growthweek1 = (Integer) hit.getSource().get("growthweek1");
				list.add(new MatrixData(storeid, storename, generationtime, productkeywords, reviewcount, preimg,
						productid, productdirectory, productdirectorys, minprice, orders, quantity, salesweek1,
						paymentweek1, growthweek1));
			}
		}
		return list;
	}

	public static void main(String[] args) throws ParseException {
		ElasticSearchHandler esHandler = new ElasticSearchHandler();
		String indexname = "matrixdata";
		String type = "product";
		// 查询条件
		QueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("productkeywords", "Breathable Wicking");
		List<MatrixData> result = esHandler.searcher(queryBuilder, indexname, type);
		for (int i = 0; i < result.size();) {
			MatrixData mds = result.get(i);
			System.out.println(++i + ":(商品id:" + mds.getProductid() + ") 商品图片链接:" + mds.getPreimg() + "商品名称:"
					+ mds.getProductkeywords() + " 所属店铺:" + mds.getStorename() + "(id:" + mds.getStoreid() + " 开业时间:"
					+ mds.getGenerationtime() + ") 近6个月订单数:" + mds.getOrders() + "评价数:" + mds.getReviewcount()
					+ "商品叶子目录:" + mds.getProductdirectory() + "商品所属的类目:" + mds.getProductdirectorys() + "最低售价:"
					+ mds.getMinprice() + "是否热卖:" + mds.getQuantity() + " 最近7天共卖出" + mds.getSalesweek1() + "件,共计"
					+ mds.getPaymentweek1() + "元,增幅为" + mds.getGrowthweek1());
		}
	}
}