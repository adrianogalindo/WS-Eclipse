package exempleSingleton;


public class ModeControl {
	
	private  int mode; 
	private ModeControl(){
		mode=1;
	}
	
    public void setInsertMode(){
    	mode=1;
    }
    public void setUpdateMode(){
    	mode=2;
    }
    public boolean IsInsertMode(){
    	return mode==1;
    }
    public boolean IsUpdateMode(){
    	return mode==2;
    }
    
    static private ModeControl mc= new ModeControl();
    static public ModeControl getModeControl(){
    	return mc;
    }		

}
