/*
 * Fetion Open Platform
 *  
 * Create by GavinHwa 2011-12-20
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.sdk;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.feinno.sdk.api.FriendsApi;
import com.feinno.sdk.api.UserApi;
import com.feinno.sdk.http.authorization.AuthToken;
import com.feinno.sdk.model.FetionException;
import com.feinno.sdk.model.FetionUser;
import com.feinno.sdk.model.FriendGroup;
import com.feinno.sdk.model.UserPair;
import com.feinno.sdk.util.ConfigUtil;
import com.feinno.sdk.util.UrlUtil;

/**
 * AccountTest
 * 
 * @author larry
 */
public class ApiTest{
	
	private static Log log = LogFactory.getLog(ApiTest.class);
	
	private String sessionKey = UrlUtil.urlDecode("0.x178ii2et5gysd2slijp2itrhpauo%2bipwcgxqgy6bcg%3d.1331524584-15306638");
	
	private AuthToken token = new AuthToken(sessionKey,ConfigUtil.getProperty("fetion.appSecret"));
	
	public void areFridends(){//失败
		List<UserPair> pairList = new ArrayList<UserPair>();
		pairList.add(new UserPair(222,333));
		pairList.add(new UserPair(444,555));
		try {
			pairList = FriendsApi.areFridends(token, pairList);
			log.debug(pairList.toString());
		} catch (FetionException e) {
			log.error("areFriends出错",e);
		}
	}
	
	public void getFriendIds(){
		try {
			int [] ids = FriendsApi.getFriendsId(token);
			log.debug("好友个数:"+ids.length);
		} catch (FetionException e) {
			log.error("getFriendsIds出错",e);
		}
	}
	
	public void getFriends(){
		List<FriendGroup> friends = null;
		try {
			friends = FriendsApi.getFriends(token);
			log.debug(friends.size()+"");
		} catch (FetionException e) {
			log.error("getFriends出错",e);
		}
	}
	
	public void getAppFriendIds(){
		try {
			int [] ids = FriendsApi.getAppFriendIds(token);
			log.debug("app好友个数:"+ids.length);
		} catch (FetionException e) {
			log.error("getFriendsIds出错",e);
		}
	}
	
	public void getAppFriends(){
		List<FriendGroup> friends = null;
		try {
			friends = FriendsApi.getAppFriends(token);
			log.debug(friends.toString());
		} catch (FetionException e) {
			log.error("getAppFriends",e);
		}
	}
	
	public void getUserInfo(){//user字段整理
		List<FetionUser> userList = null;
		try {
			userList = UserApi.getUserInfo(token, "212338137");
			log.debug(userList.toString());
		} catch (FetionException e) {
			log.error("getUserInfo",e);
		}
	}
	
	public void getLogedinUid(){
		try {
			int uid = UserApi.getLoggedInUserId(token);
			log.debug(String.valueOf(uid));
		} catch (FetionException e) {
			log.error("getLogedinUid",e);
		}
	}
	
	public void isAppUser(){
		try {
			boolean isAppUser = UserApi.isAppUser(token, null, 212338137);
			log.debug(String.valueOf(isAppUser));
		} catch (FetionException e) {
			log.error("getLogedinUid",e);
		}
	}
}