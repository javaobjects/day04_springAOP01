package aop;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args){

		//1.加载并且解析applicationContext.xml
		//积极加载，在加载与解析xml的同时，即完成所有bean的实例化
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("----------IOC容器加载完成--------------------");
		
		//2.无代理，无日志记录
		IUserDao userDao = (IUserDao) factory.getBean("userDao");
		IUserDao userDao2 = (IUserDao) factory.getBean("userDao2");
		IDeptDao deptDao = (IDeptDao) factory.getBean("deptDao");
		
		userDao.selectUser();
		userDao2.selectUser();
		deptDao.selectDept();;
		
		deptDao.insertDept("软件事业部");
	}

}
