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
package de.odysseus.el.tree.impl.ast;

import javax.el.ELContext;

import de.odysseus.el.tree.Bindings;

public final class AstBoolean extends AstLiteral {
	private final boolean value;

	public AstBoolean(boolean value) {
		this.value = value;
	}

	@Override 
	public Object eval(Bindings bindings, ELContext context) {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}	

	@Override 
	public void appendStructure(StringBuilder b, Bindings bindings) {
		b.append(value);
	}
}
