package proxy.person.bean;

public class Proxy {

	public PersonBean getOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(
				person.getClass().getClassLoader(),
				person.getClass().getInterfaces(),
				new OwnerInvocationHandler(person));
	}


	public PersonBean getNonOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(
				person.getClass().getClassLoader(),
				person.getClass().getInterfaces(),
				new NonOwnerInvocationHandler(person));
	}

	private static PersonBean newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces,
			NonOwnerInvocationHandler nonOwnerInvocationHandler) {
		// TODO Auto-generated method stub
		return null;
	}


	private static PersonBean newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces,
			OwnerInvocationHandler ownerInvocationHandler) {
		// TODO Auto-generated method stub
		return null;
	}
}
