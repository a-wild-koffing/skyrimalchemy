import java.util.Comparator;


public class PotionComparator implements Comparator<Potion>{

	@Override
	public int compare(Potion arg0, Potion arg1) {
		if(arg0.getValue() < arg1.getValue())
			return -1;
		else if(arg0.getValue() > arg1.getValue())
			return 1;
		else return 0;
	}

}
