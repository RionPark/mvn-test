package com.mvn.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mvn.test.vo.UserInfoVO;

public class Test {

	public static void main(String[] args) {
		try {
			String str = "1a23";
			if(!"124".equals(str)) {
				throw new Exception("난 123이 아니야!!!");
			}
			System.out.println("커밋되야됨");
		}catch(Exception e) {
			System.out.println("롤백해야됨");
			e.printStackTrace();
		}finally {
			System.out.println("종료되야지");
		}
		
	}
}
