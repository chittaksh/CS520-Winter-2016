package models;

import java.util.Date;
import java.util.Comparator;

public class Application {

	private int id;
	private String name;
	private Date receivedOn;
	private float gpa;
	private status status;

	public Application(int id, String name, Date receivedOn, float gpa, models.status status) {
		super();
		this.id = id;
		this.name = name;
		this.receivedOn = receivedOn;
		this.gpa = gpa;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getReceivedOn() {
		return receivedOn;
	}

	public void setReceivedOn(Date receivedOn) {
		this.receivedOn = receivedOn;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public status getStatus() {
		return status;
	}

	public void setStatus(status status) {
		this.status = status;
	}

	public static Comparator<Application> sortByName = new Comparator<Application>() {

		public int compare(Application a1, Application a2) {
			String a1Name = a1.getName().toLowerCase();
			String a2name = a2.getName().toLowerCase();

			// ascending order
			return a1Name.compareTo(a2name);

			// descending order
			// return a2name.compareTo(a1Name);
		}
	};

	public static Comparator<Application> sortByDate = new Comparator<Application>() {

		public int compare(Application a1, Application a2) {
			Date a1Date = a1.getReceivedOn();
			Date a2Date = a2.getReceivedOn();

			// ascending order
			// return a1Date.compareTo(a2Date);

			// descending order
			return a2Date.compareTo(a1Date);
		}
	};

	public static Comparator<Application> sortByGpa = new Comparator<Application>() {

		public int compare(Application a1, Application a2) {
			float a1Gpa = a1.getGpa();
			float a2Gpa = a2.getGpa();

			// ascending order
			// return Float.compare(a1Gpa, a2Gpa);

			// descending order
			 return Float.compare(a2Gpa, a1Gpa);
		}
	};

	public static Comparator<Application> sortByStatus = new Comparator<Application>() {

		public int compare(Application a1, Application a2) {
			String a1Status = a1.getStatus().getDisplayName();
			String a2Status = a2.getStatus().getDisplayName();

			// ascending order
			return a1Status.compareTo(a2Status);

			// descending order
			// return a2Status.compareTo(a1Status);
		}
	};
}
