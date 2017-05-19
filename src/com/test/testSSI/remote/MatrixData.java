package com.test.testSSI.remote;

import java.util.Date;

public class MatrixData {
	private String storeid; // 商品所属店铺id
	private String storename; // 商品所属店铺名称
	private Date generationtime; // 商品所属店铺开张时间
	private String productkeywords; // 商品名称，用于关键字模糊查询
	private Integer reviewcount; // 商品近6个月的评价总数
	private String preimg; // 商品主图
	private String productid; // 商品id，与es中数据集的主键相同
	private String productdirectory; // 商品的叶子类目
	private String productdirectorys; // 商品所属的类目层次，从高到低
	private Double minprice; // 商品价格区间的最低价格
	private Integer orders; // 商品近6个月的订单数
	private Integer quantity; // 热卖商品标记,日订单超过1400单的商品
	private Integer salesweek1; // 商品7天销售件数
	private Integer paymentweek1; // 商品7天销售金额
	private Integer growthweek1; // 商品7天销售增幅

	public MatrixData() {
		super();
	}

	public MatrixData(String storeid, String storename, Date generationtime, String productkeywords, Integer reviewcount,
			String preimg, String productid, String productdirectory, String productdirectorys, Double minprice,
			Integer orders, Integer quantity, Integer salesweek1, Integer paymentweek1, Integer growthweek1) {
		super();
		this.storeid = storeid;
		this.storename = storename;
		this.generationtime = generationtime;
		this.productkeywords = productkeywords;
		this.reviewcount = reviewcount;
		this.preimg = preimg;
		this.productid = productid;
		this.productdirectory = productdirectory;
		this.productdirectorys = productdirectorys;
		this.minprice = minprice;
		this.orders = orders;
		this.quantity = quantity;
		this.salesweek1 = salesweek1;
		this.paymentweek1 = paymentweek1;
		this.growthweek1 = growthweek1;
	}

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}

	public String getProductkeywords() {
		return productkeywords;
	}

	public void setProductkeywords(String productkeywords) {
		this.productkeywords = productkeywords;
	}

	public Date getGenerationtime() {
		return generationtime;
	}

	public void setGenerationtime(Date generationtime) {
		this.generationtime = generationtime;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public Integer getReviewcount() {
		return reviewcount;
	}

	public void setReviewcount(Integer reviewcount) {
		this.reviewcount = reviewcount;
	}

	public String getPreimg() {
		return preimg;
	}

	public void setPreimg(String preimg) {
		this.preimg = preimg;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductdirectory() {
		return productdirectory;
	}

	public void setProductdirectory(String productdirectory) {
		this.productdirectory = productdirectory;
	}

	public String getProductdirectorys() {
		return productdirectorys;
	}

	public void setProductdirectorys(String productdirectorys) {
		this.productdirectorys = productdirectorys;
	}

	public Double getMinprice() {
		return minprice;
	}

	public void setMinprice(Double minprice) {
		this.minprice = minprice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public Integer getSalesweek1() {
		return salesweek1;
	}

	public void setSalesweek1(Integer salesweek1) {
		this.salesweek1 = salesweek1;
	}

	public Integer getPaymentweek1() {
		return paymentweek1;
	}

	public void setPaymentweek1(Integer paymentweek1) {
		this.paymentweek1 = paymentweek1;
	}

	public Integer getGrowthweek1() {
		return growthweek1;
	}

	public void setGrowthweek1(Integer growthweek1) {
		this.growthweek1 = growthweek1;
	}
}