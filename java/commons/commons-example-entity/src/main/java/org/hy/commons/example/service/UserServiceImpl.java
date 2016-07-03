package org.hy.commons.example.service;

public class UserServiceImpl implements UserService {

	/* (non-Javadoc)
	 * @see org.hy.commons.example.service.UserService#add()
	 */
	@Override
	public void add() throws Exception{
		System.out.println("add");
	}
	
	/* (non-Javadoc)
	 * @see org.hy.commons.example.service.UserService#delete()
	 */
	@Override
	public void delete() throws Exception{
		System.out.println("delete");
		throw new RuntimeException("delete error");
	}
	
	/* (non-Javadoc)
	 * @see org.hy.commons.example.service.UserService#find()
	 */
	@Override
	public void find() throws Exception{
		System.out.println("find");
	}
	
	/* (non-Javadoc)
	 * @see org.hy.commons.example.service.UserService#update()
	 */
	@Override
	public void update() throws Exception{
		System.out.println("update");
	}
}
