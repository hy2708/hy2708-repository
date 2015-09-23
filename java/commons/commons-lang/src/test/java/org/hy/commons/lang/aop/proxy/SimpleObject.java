package org.hy.commons.lang.aop.proxy;

public class SimpleObject implements SimpleInterface {

	/* (non-Javadoc)
	 * @see org.hy.commons.lang.reflect.example.SimpleInterfac#work(java.lang.String)
	 */
	@Override
	public void work(String text) {
		System.out.println(text);
	}
}
