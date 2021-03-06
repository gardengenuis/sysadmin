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
package org.garden.sysadmin.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * SysDictField.java
 *
 * @author codegen-garden ver. 0.0.1
 * create on Tue Nov 11 23:26:00 CST 2014
 */
 
@Entity
@Table(name="SYS_DICT_FIELD" )
public class SysDictField implements Serializable {
	
	private static final long serialVersionUID = -5198925741199641089L;


	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "DICT_ID")
	private Long dictId;
	
	
	@Column(name= "DICT_NAME")
	private String dictName;
	
	
	@Column(name= "DICT_CODE")
	private String dictCode;
	
	
	@Column(name= "STATUS")
	private String status;
	
		
	
		
	/**
	 * @return the dictId
	 */
	public Long getDictId() {
		return dictId;
	}
	/**
	 * @param dictId the dictId to set
	 */
	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}	
		
	/**
	 * @return the dictName
	 */
	public String getDictName() {
		return dictName;
	}
	/**
	 * @param dictName the dictName to set
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}	
		
	/**
	 * @return the dictCode
	 */
	public String getDictCode() {
		return dictCode;
	}
	/**
	 * @param dictCode the dictCode to set
	 */
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}	
		
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}	
		
}