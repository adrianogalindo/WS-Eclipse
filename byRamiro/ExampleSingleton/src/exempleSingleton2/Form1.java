package exempleSingleton2;


class ModeControl {
	
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


public class Form1 {
	
   	//public int mode;	
    public  ModeControl Mode = ModeControl.getModeControl(); 

	public void display(){
		
		if (Mode.IsInsertMode()){ 
			System.out.println("I am in insert mode.");
		}
		else if (Mode.IsUpdateMode()) {
			System.out.println("I am in update mode.");
		}
		else {
			System.out.println("Invalid mode");
		}
	}

}
