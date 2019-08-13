package liskov2;

import java.util.*;

public interface Polygone {
	

	public abstract List<Integer> listCotes();
	
	public abstract int perimetre() ;
	public abstract int surface() ;

}
