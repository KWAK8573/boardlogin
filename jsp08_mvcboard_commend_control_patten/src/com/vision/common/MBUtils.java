package com.vision.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 마이바티스를 부릴때에 사용할 수 있는 유틸리티 클래스
// 임의 생성
public class MBUtils {
	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "com/vision/common/SqlMapConfig.xml";
		InputStream reader = null;
		try {
			reader = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// 새로운 예외로 발생시키기 
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(reader);
	}
	
	public static SqlSession getSession() {
		return getSqlSessionFactory().openSession(true);
	}
}
