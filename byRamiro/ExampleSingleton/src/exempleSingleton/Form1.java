package exempleSingleton;

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
