package dataStructures.linearTable.stack;

public class SampleBrower {
	//存放前进的数据
	private LinkStack<String> backStack = new LinkStack<String>();
	//存放回退的数据
	private LinkStack<String> forwardStack = new LinkStack<String>();
	//当前页
	private String currentPage = null;
	
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public void open(String url) {
		if (backStack.getTop() != null) {
			backStack.setTop(null);
		}
		forwardStack.push(url);
		showUrl(url, "Open");
	}
	
	public void showUrl(String url, String prefix) {
		this.currentPage = url;
        System.out.println(prefix + " page == " + url);
	}
	
	/**
	 * 点后退按钮
	 */
	public void goBack() {
		if (!canBack()) {
			System.out.println("没有后退页");
			return;
		}
		String value = forwardStack.pop();
		if (forwardStack.getTop() != null) {
			showUrl(forwardStack.getTop().getData(), "goBack");
		} else {
			
		}
		
		backStack.push(value);
	}
	
	/**
	 * 点前进按钮
	 */
	public void goForward() {
		if (!canForward()) {
			System.out.println("没有前进页");
			return;
		}
		String value = backStack.pop();
		showUrl(value, "goForward");
		forwardStack.push(value);
	}
	
	/**
	 * 是否可以后退
	 * @return
	 */
	public boolean canBack() {
		return forwardStack.getSize() > 0;
	}
	
	/**
	 * 是否可以前进
	 * @return
	 */
	public boolean canForward() {
		return backStack.getSize() > 0;
	}
	
	public void printAll() {
		System.out.println("前进栈:");
		forwardStack.printAll();
		System.out.println("后退栈");
		backStack.printAll();
	}
	
	public static void main(String[] args) {
		SampleBrower browser = new SampleBrower();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
	}

}
