package aop;


public class DeptDaoImpl implements IDeptDao {

	public DeptDaoImpl()
	{
		System.out.println("new DeptDaoImpl() 实例化");
	}
	
	@Override
	public void selectDept() {
		//System.out.println("DeptDaoImpl.selectDept()............日志记录开始");
		
		System.out.println("DeptDaoImpl.selectDept..........软件开发事业部11111");
		
		//System.out.println("DeptDaoImpl.selectDept()............日志记录结束");
	}

	@Override
	public boolean insertDept(String deptname) {
		//System.out.println("DeptDaoImpl.insertDept("+deptname+")............日志记录开始");
		
		System.out.println("DeptDaoImpl.insertDept("+deptname+")");
		
		//System.out.println("DeptDaoImpl.insertDept()............日志记录开始,返回结果：" + true);
		
		return true;
	}
}
