import java.util.ArrayList;
import java.util.List;

public class ToolFactory {

	// List of Tools
	public List<Tool> ListOfTools;

	// Default Constructor
	public ToolFactory(){
		ListOfTools = new ArrayList<Tool>();
		this.ListOfTools = CreateListOfTools();
	}

	// Getter method for List of Tools
	public List<Tool> getListOfTools(){
		return this.ListOfTools;
	}

	// Factory
	public static Tool getTool(String name, String category){
		if(category.equals("Painting")) {
			return new Painting(name, "Painting");
		}
		if(category.equals("Concrete")) {
			return new Concrete(name, "Concrete");
		}
		if(category.equals("Plumbing")) {
			return new Plumbing(name, "Plumbing");
		}
		if(category.equals("Woodwork")) {
			return new Woodwork(name,"Woodwork");
		}
		if(category.equals("Yardwork")) {
			return new Yardwork( name,"Yardwork");
		}
		else
			return null;
	}

	// Create list of Tools
	public List<Tool> CreateListOfTools(){

		Tool Painting1 = ToolFactory.getTool("Painting1", "Painting");
		Tool Painting2 = ToolFactory.getTool("Painting2", "Painting");
		Tool Painting3 = ToolFactory.getTool("Painting3", "Painting");
		Tool Painting4 = ToolFactory.getTool( "Painting4", "Painting");
		Tool Painting5 = ToolFactory.getTool( "Painting5","Painting");

		Tool Concrete1 = ToolFactory.getTool( "Concrete1", "Concrete");
		Tool Concrete2 = ToolFactory.getTool( "Concrete2", "Concrete");
		Tool Concrete3 = ToolFactory.getTool( "Concrete3", "Concrete");
		Tool Concrete4 = ToolFactory.getTool( "Concrete4", "Concrete");
		Tool Concrete5 = ToolFactory.getTool( "Concrete5", "Concrete");

		Tool Plumbing1 = ToolFactory.getTool( "Plumbing1", "Plumbing");
		Tool Plumbing2 = ToolFactory.getTool( "Plumbing2", "Plumbing");
		Tool Plumbing3 = ToolFactory.getTool( "Plumbing3", "Plumbing");
		Tool Plumbing4 = ToolFactory.getTool( "Plumbing4", "Plumbing");
		Tool Plumbing5 = ToolFactory.getTool( "Plumbing5", "Plumbing");

		Tool Woodwork1 = ToolFactory.getTool("Woodwork1", "Woodwork");
		Tool Woodwork2 = ToolFactory.getTool("Woodwork2", "Woodwork");
		Tool Woodwork3 = ToolFactory.getTool("Woodwork3", "Woodwork");
		Tool Woodwork4 = ToolFactory.getTool("Woodwork4", "Woodwork");
		Tool Woodwork5 = ToolFactory.getTool( "Woodwork5", "Woodwork");

		Tool Yardwork1 = ToolFactory.getTool("Yardwork1", "Yardwork");
		Tool Yardwork2 = ToolFactory.getTool( "Yardwork2", "Yardwork");
		Tool Yardwork3 = ToolFactory.getTool("Yardwork3", "Yardwork");
		Tool Yardwork4 = ToolFactory.getTool( "Yardwork4", "Yardwork");

		ListOfTools.add(Painting1);
		ListOfTools.add(Painting2);
		ListOfTools.add(Painting3);
		ListOfTools.add(Painting4);
		ListOfTools.add(Painting5);
		ListOfTools.add(Concrete1);
		ListOfTools.add(Concrete2);
		ListOfTools.add(Concrete3);
		ListOfTools.add(Concrete4);
		ListOfTools.add(Concrete5);
		ListOfTools.add(Plumbing1);
		ListOfTools.add(Plumbing2);
		ListOfTools.add(Plumbing3);
		ListOfTools.add(Plumbing4);
		ListOfTools.add(Plumbing5);
		ListOfTools.add(Woodwork1);
		ListOfTools.add(Woodwork2);
		ListOfTools.add(Woodwork3);
		ListOfTools.add(Woodwork4);
		ListOfTools.add(Woodwork5);
		ListOfTools.add(Yardwork1);
		ListOfTools.add(Yardwork2);
		ListOfTools.add(Yardwork3);
		ListOfTools.add(Yardwork4);
		return this.ListOfTools;
	}

	// Method for printing
	public String toString(){
		String str = "In the tool list : ";
		for(Tool tool: ListOfTools){
			str += "( " + tool.getCategory() + ", " + tool.getName() + ", "+ tool.getPrice() + " )";
		}
		return str;
	}
}
