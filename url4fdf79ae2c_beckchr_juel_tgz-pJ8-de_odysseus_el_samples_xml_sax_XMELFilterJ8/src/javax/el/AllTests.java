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

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for javax.el");
		//$JUnit-BEGIN$
		suite.addTestSuite(ArrayELResolverTest.class);
		suite.addTestSuite(BeanELResolverTest.class);
		suite.addTestSuite(CompositeELResolverTest.class);
		suite.addTestSuite(ListELResolverTest.class);
		suite.addTestSuite(MapELResolverTest.class);
		suite.addTestSuite(ResourceBundleELResolverTest.class);
		suite.addTestSuite(ELContextTest.class);
		suite.addTestSuite(MethodInfoTest.class);
		suite.addTestSuite(ExpressionFactoryTest.class);
		suite.addTestSuite(ValueReferenceTest.class);
		//$JUnit-END$
		return suite;
	}

}
