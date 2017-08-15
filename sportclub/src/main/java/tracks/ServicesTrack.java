package tracks;

public class ServicesTrack {
	private boolean takeGeneralMassage;
	private boolean takeSolyariy;
	private boolean takeKrosfit;
	private boolean takeYoga;
	private int numberVisitsMonthly;

	public ServicesTrack(){
	}

	public ServicesTrack(boolean takeGeneralMassage, boolean takeSolyariy,
			boolean takeKrosfit, boolean takeYoga, int numberVisitsMonthly) {
		this.takeGeneralMassage = takeGeneralMassage;
		this.takeSolyariy = takeSolyariy;
		this.takeKrosfit = takeKrosfit;
		this.takeYoga = takeYoga;
		this.numberVisitsMonthly = numberVisitsMonthly;
	}

	public boolean isTakeGeneralMassage() {
		return takeGeneralMassage;
	}

	public boolean isTakeSolyariy() {
		return takeSolyariy;
	}

	public boolean isTakeKrosfit() {
		return takeKrosfit;
	}

	public boolean isTakeYoga() {
		return takeYoga;
	}

	public int getNumberVisitsMonthly() {
		return numberVisitsMonthly;
	}

	public void setTakeGeneralMassage(boolean takeGeneralMassage) {
		this.takeGeneralMassage = takeGeneralMassage;
	}

	public void setTakeSolyariy(boolean takeSolyariy) {
		this.takeSolyariy = takeSolyariy;
	}

	public void setTakeKrosfit(boolean takeKrosfit) {
		this.takeKrosfit = takeKrosfit;
	}

	public void setTakeYoga(boolean takeYoga) {
		this.takeYoga = takeYoga;
	}

	public void setNumberVisitsMonthly(int numberVisitsMonthly) {
		this.numberVisitsMonthly = numberVisitsMonthly;
	}

	@Override
	public String toString() {
		return "ServicesTrack [takeGeneralMassage=" + takeGeneralMassage + ", takeSolyariy=" + takeSolyariy
				+ ", takeKrosfit=" + takeKrosfit + ", takeYoga=" + takeYoga + ", numberVisitsMonthly="
				+ numberVisitsMonthly + "]";
	}

}
