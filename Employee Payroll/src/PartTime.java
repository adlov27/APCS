/**
 *c)Part Time --> hourly worker with no deduction for net.  Can not work over 
 *20 hours. Part-Time employee should be a subclass of Hourly Employee.
 * @author Andrew
 *
 */
public class PartTime extends HourlyWorker
{

	public PartTime (int hours, int wage, String N)
	{
		super(hours, wage, N);
	}
	
	public double grossSalary()
	{
		if(hoursworked > 20)
			hoursworked = 20;
		
		return hoursworked * hourlywage;
	}

	public double netSalary()
	{
		return grossSalary();
	}
	
}
