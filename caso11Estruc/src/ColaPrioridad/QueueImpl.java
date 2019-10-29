package ColaPrioridad;

public class QueueImpl<T> extends Queue<T>	{
 	
	
	@Override
	public void enqueue(T pValue) {
		enqueue(pValue, QueuePriorities.NORMAL);
	}
	
	@Override
	public void enqueue(T pValue, QueuePriorities priority) {
		// TODO Auto-generated method stub
		colas[priority.getValue()].add(pValue);
			
	}
			
	@Override
	public T dequeue() {
		T result = null;
		// TODO Auto-generated method stub
		for(QueuePriorities priority : QueuePriorities.values()) {
			if(!colas[priority.getValue()].isEmpty()){
				result = colas[priority.getValue()].remove(0);
				break;	
			}
		}
		return result;
	}

	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(QueuePriorities priority : QueuePriorities.values()) {
			colas[priority.getValue()].clear();
		}
	}
}
