package com.tyron.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tyron.o2o.BaseTest;
import com.tyron.o2o.entity.LocalAuth;
import com.tyron.o2o.entity.PersonInfo;

/**
 * @Description: 本地用户信息数据层测试
 */
public class LocalAuthDaoTest extends BaseTest {

	@Autowired
	private LocalAuthDao localAuthDao;
	private static final String username = "root";
	private static final String password = "654321";

	/**
	 * 测试插入用户
	 * 
	 * @throws Exception
	 */
	@Test
	//@Ignore
	public void testInsertLocalAuth() throws Exception {
		// 新增一条本地用户
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		localAuth.setPersonInfo(personInfo);
		// 设置用户名和密码
		localAuth.setUsername(username);
		localAuth.setPassword(password);
		localAuth.setCreateTime(new Date());
		int effectNum = localAuthDao.insertLocalAuth(localAuth);
		assertEquals(1, effectNum);
	}

	/**
	 * 根据用户名和账号查询用户
	 */
	@Test
	public void testQueryLocalByUsernameAndPwd() {
		LocalAuth localAuth = localAuthDao.queryLocalByUsernameAndPwd(username, password);
		assertEquals("root", localAuth.getPersonInfo().getName());
	}

	/**
	 * 根据用户Id查询本地账号信息
	 */
	@Test
	//@Ignore
	public void testQueryLocalByLocalAuthId() {
		LocalAuth localAuth = localAuthDao.queryLocalByLocalAuthId(2L);
		assertEquals("king", localAuth.getPersonInfo().getName());
	}

	/**
	 * 更新账号信息
	 */
	@Test
	//@Ignore
	public void testUpdateLocalAuth() {
		Date now = new Date();
		int effectNum = localAuthDao.updateLocalAuth(username, password, "6543210", now);
		assertEquals(1, effectNum);
	}

}
