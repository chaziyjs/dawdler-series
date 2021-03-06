/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.anywide.dawdler.client;
import com.anywide.dawdler.client.net.aio.session.SocketSession;
/**
 * 
 * @Title:  TransactionProvider.java
 * @Description:    Transaction提供者，传入groupName获取Transaction
 * @author: jackson.song    
 * @date:   2015年03月26日     
 * @version V1.0 
 * @email: suxuan696@gmail.com
 */
public class TransactionProvider {
	public final static String DEFAULTGRUOPNAME="defaultgroup";
	public static Transaction getTransaction(){
		ConnectionPool cp = ConnectionPool.getConnectionPool(DEFAULTGRUOPNAME);
		DawdlerConnection con = cp.getConnection();
		SocketSession session = con.getSession();
		Transaction tr = new Transaction(session,con.getPath(),con.getSerializer());
		return tr;
	}
	
	public static Transaction getTransaction(String groupName){
		ConnectionPool cp = ConnectionPool.getConnectionPool(groupName);
		DawdlerConnection con = cp.getConnection();
		SocketSession session = con.getSession();
		Transaction tr = new Transaction(session,con.getPath(),con.getSerializer());
		return tr;
	}
}
