package com.test.testSSI.local;

import java.io.IOException;
import com.test.testSSI.local.Medicine;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

/**
 *
 */
public class JsonUtil {

	/**
	 * 实现将实体对象转换成json对象
	 * 
	 * @param medicine
	 * 
	 * @return Medicine对象
	 */
	public static String obj2JsonData(Medicine medicine) {
		String jsonData = null;
		try {
			// 使用XContentBuilder创建json数据
			XContentBuilder jsonBuild = XContentFactory.jsonBuilder();
			jsonBuild.startObject().field("id", medicine.getId()).field("name", medicine.getName())
					.field("funciton", medicine.getFunction()).endObject();
			jsonData = jsonBuild.string();
			System.out.println(jsonData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonData;
	}

}