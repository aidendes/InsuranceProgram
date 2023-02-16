package ie.atu.dip;

/**
 * @author aiden desmond <G00398273@atu.ie>
 *
 * Agile Software Development Project
 */
public interface Quote {

	public abstract int basicInsurance();
	public abstract int surcharge(int age);
	public abstract int loading(int acc);

}
