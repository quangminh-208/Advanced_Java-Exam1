package it602003;

import java.util.ArrayList;
import java.util.Scanner;

import it602003.objects.ProductGroupObject;
import it602003.process.processImpl.ProductGroupImpl;

public class Main {
	static ArrayList<ProductGroupObject> pro;
	static ProductGroupImpl process;
	static ProductGroupObject pgObj;

	public static void main(String[] args) {
		process = new ProductGroupImpl();
		
//		Hiển thị bảng
//		pro = process.getProductGroupObjects();
//
//		for (ProductGroupObject a : pro) {
//			System.out.println(a);
//		}
//		System.out.println("-----------");

//		Thêm hàng
//		pgObj = new ProductGroupObject();
//		pgObj.setPg_name("Quan ao mua dong");
//		pgObj.setPg_name_en("Winter clothes");
//		System.out.println(process.addProductGroup(pgObj));
		
//		Sửa hàng
		pgObj = new ProductGroupObject();
		pgObj.setPg_id((short) 54);
		pgObj.setPg_name("Quan ao mua he");
		pgObj.setPg_name_en("Summer clothes");
		System.out.println(process.updateProductGroupObject(pgObj));
		
//		Xóa hàng
	}
}
