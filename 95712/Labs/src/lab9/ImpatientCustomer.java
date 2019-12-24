// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab9;

public class ImpatientCustomer extends Customer{
	final static int BALK_LENGTH = 5;
	static int impatientCustomerCount;
	ImpatientCustomer(){
		super();
		impatientCustomerCount++;
	}
	@Override
	boolean joinQueue() {
		if (QueueManager.queue.size() >= BALK_LENGTH)
			return false;
		else
			return super.joinQueue();
	}
}
