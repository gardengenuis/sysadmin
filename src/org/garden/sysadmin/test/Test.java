/*
 * Copyright (c) 2004, 2014, Garden Lee. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 
package org.garden.sysadmin.test;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.garden.sysadmin.dao.model.SysRole;
import org.garden.sysadmin.service.SystemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * Test.java
 *
 * @author Garden
 * create on 2014年9月4日 下午4:10:56
 */
public class Test {
	private static Log log = LogFactory.getLog(Test.class);
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		IConnection conn = new HibernateRawTest();
		String datasourceXml=System.getProperty("user.dir") + File.separator + "config" + File.separator + "spring" + File.separator + "spring-datasource.xml";
		String daoXml=System.getProperty("user.dir") + File.separator + "config" + File.separator + "spring" + File.separator + "spring-dao.xml";
		String serviesXml=System.getProperty("user.dir") + File.separator + "config" + File.separator + "spring" + File.separator + "spring-services.xml";
		ApplicationContext context =
			    //new ClassPathXmlApplicationContext(new String[] {"spring-datasource.xml"});
				new FileSystemXmlApplicationContext(datasourceXml, daoXml, serviesXml);
		
		SystemService dao = (SystemService) context.getBean("sysSecurityService");
		dao.getSysResourceByUserCode("garden");
		
//		List<SysRole> roles = dao.getSysRoleByUserCode("garden");
//		
//		for (SysRole role:roles) {
//			System.out.println(role.getRoleName());
//			System.out.println(role.getRoleCode());
//		}
		
//		dao.f
		
	}

}
