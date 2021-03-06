/*
 * Copyright 2006-2009 Odysseus Software GmbH
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
package javax.el;

import java.io.Serializable;

/**
 * This class encapsulates a base model object and one of its properties.
 * 
 * @since 2.2
 */
public class ValueReference implements Serializable {
	private static final long serialVersionUID = 1L;

	private Object base;
	private Object property;

	public ValueReference(Object base, Object property) {
		this.base = base;
		this.property = property;
	}

	public Object getBase() {
		return base;
	}

	public Object getProperty() {
		return property;
	}
}