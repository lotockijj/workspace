package tracks;

public class AbonnementsTrack {
	private boolean base;
	private boolean baseAllDay;
	private boolean baseUnlimited;
	private boolean baseAllDayUnlimited;
	private boolean personalCoach;

	public AbonnementsTrack(){
	}
	
	public AbonnementsTrack(boolean base, boolean baseAllDay, boolean baseUnlimited, boolean baseAllDayUnlimited,
			boolean personalCoach) {
		this.base = base;
		this.baseAllDay = baseAllDay;
		this.baseUnlimited = baseUnlimited;
		this.baseAllDayUnlimited = baseAllDayUnlimited;
		this.personalCoach = personalCoach;
	}
	
	public boolean isBase() {
		return base;
	}
	public boolean isBaseAllDay() {
		return baseAllDay;
	}
	public boolean isBaseUnlimited() {
		return baseUnlimited;
	}
	public boolean isBaseAllDayUnlimited() {
		return baseAllDayUnlimited;
	}
	public boolean isPersonalCoach() {
		return personalCoach;
	}

	public void setBase(boolean base) {
		if(base) setAllTracks("base");
		this.base = base;
	}
	public void setBaseAllDay(boolean baseAllDay) {
		if(baseAllDay) setAllTracks("baseAllDay");
		this.baseAllDay = baseAllDay;
	}
	public void setBaseUnlimited(boolean baseUnlimited) {
		if(baseUnlimited) setAllTracks("baseUnlimited");
		this.baseUnlimited = baseUnlimited;
	}
	public void setBaseAllDayUnlimited(boolean baseAllDayUnlimited) {
		if(baseAllDayUnlimited) setAllTracks("baseAllDayUnlimited");
		this.baseAllDayUnlimited = baseAllDayUnlimited;
	}
	public void setPersonalCoach(boolean personalCoach) {
		this.personalCoach = personalCoach;
	}

	private void setAllTracks(String abonnements) {
		switch(abonnements){
			case "base" : baseAllDay = baseUnlimited = baseAllDayUnlimited = false;
				break;
			case "baseAllDay" : base = baseUnlimited = baseAllDayUnlimited = false;
				break;
			case "baseUnlimited" : base = baseAllDay = baseAllDayUnlimited = false;
				break;
			case "baseAllDayUnlimited" : base = baseAllDay = baseUnlimited = false;
				break;
		}
	}

	@Override
	public String toString() {
		return "AbonnementsTrack [base=" + base + ", baseAllDay=" + baseAllDay + ", baseUnlimited=" + baseUnlimited
				+ ", baseAllDayUnlimited=" + baseAllDayUnlimited + ", personalCoach=" + personalCoach + "]";
	}
	
}
