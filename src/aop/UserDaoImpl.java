package aop;


public class UserDaoImpl implements IUserDao {

	public UserDaoImpl()
	{
		System.out.println("new UserDaoImpl() 实例化");
	}
	
	@Override
	public void selectUser() {
		//System.out.println("UserDaoImpl.selectUser()............日志记录开始");
		
		System.out.println("UserDaoImpl.selectUser..........杰成11111");
		
		//System.out.println("UserDaoImpl.selectUser()............日志记录结束");
	}

	@Override
	public boolean insertUser(String username) {
		//System.out.println("UserDaoImpl.insertUser("+username+")............日志记录开始");
		
		System.out.println("UserDaoImpl.insertUser("+username+")");
		
		//System.out.println("UserDaoImpl.insertUser()............日志记录开始,返回结果：" + true);
		
		return true;
	}
}
