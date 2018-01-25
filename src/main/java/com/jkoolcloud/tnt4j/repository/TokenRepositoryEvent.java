/*
 * Copyright 2014-2018 JKOOL, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jkoolcloud.tnt4j.repository;

import java.util.EventObject;

/**
 * <p>
 * An event class for reporting updates on a token repository object.
 * </p>
 * <p>
 * The following standard events are generated by typical token repository implementations (event types are defined in
 * {@link com.jkoolcloud.tnt4j.repository.TokenRepository}):
 * </p>
 * 
 * <p>EVENT_ADD_KEY -- repository added a new key/value pair</p> 
 * <p>EVENT_SET_KEY -- repository set an existing key/value pair</p> 
 * <p>EVENT_CLEAR_KEY -- repository cleared/removed a specific key</p> 
 * <p>EVENT_CLEAR -- repository has been cleared of all keys</p> 
 * <p>EVENT_RELOAD -- repository has been reloaded</p> 
 * <p>EVENT_EXCEPTION -- an error has been encountered in the repository</p> 
 * 
 * @see TokenRepository
 *
 * @version $Revision: 2 $
 *
 */
public class TokenRepositoryEvent extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int type;
	private Object key, value;
	private Throwable error;

	/**
	 * Create a new event instance
	 * 
	 * @param source
	 *            associated with the event
	 * @param evType
	 *            event type as defined in {@link com.jkoolcloud.tnt4j.repository.TokenRepository}
	 * @param k
	 *            key associated with the event
	 * @param v
	 *            value associated with the key
	 * @param ex
	 *            exception associated with the event
	 * 
	 * @see TokenRepository
	 * 
	 */
	public TokenRepositoryEvent(Object source, int evType, Object k, Object v, Throwable ex) {
		super(source);
		type = evType;
		key = k;
		value = v;
		error = ex;
	}

	/**
	 * Get the associated event type
	 * 
	 * @return event type as defined in {@link com.jkoolcloud.tnt4j.repository.TokenRepository}
	 * @see TokenRepository
	 * 
	 */
	public int getType() {
		return type;
	}

	/**
	 * Get key associated with the event
	 * 
	 * @return key
	 * 
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * Get value associated with the event
	 * 
	 * @return value
	 * 
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Get error associated with the event
	 * 
	 * @return error
	 * 
	 */
	public Throwable getCause() {
		return error;
	}

	@Override
	public String toString() {
		return "TokenRepositoryEvent{type: " + type 
			+ ", key: " + key 
			+ ", value: " + value 
			+ ", source: " + getSource() 
			+ ", error: " + (error != null) 
			+ "}";
	}
}
