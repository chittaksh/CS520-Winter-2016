package models;

public enum status {
	Incomplete(1, "Application Incomplete"), Review(2, "Pendinig Review"), Rejected(3, "Rejected"), Accepted(4, "Accepted"), OfferSent(5, "Admission Offer Sent"), OfferAccepted(6, "Admission Offer Accepted");
	
	private int value;
	private String displayName;

	private status(int Value, String DisplayName)
	{
		this.setValue(Value);
		this.setDisplayName(DisplayName);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public static status getStatus(int value){
		status temp = null;
		for(status status: status.values()){
			if(status.value==value){
				temp = status;
				break;
			}
		}
		return temp;
	}
	
	// Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }
}
