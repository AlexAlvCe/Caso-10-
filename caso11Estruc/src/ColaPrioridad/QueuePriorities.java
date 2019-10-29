package ColaPrioridad;

public enum QueuePriorities {
	ALTA(0), MEDIA(1), NORMAL(2), BAJA(3) ;
	
	private int value;
	
	private QueuePriorities(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
