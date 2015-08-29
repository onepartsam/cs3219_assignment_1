package DataFlow;

import java.util.LinkedList;

/**
 * -------------------------------------------------------------------------
 * Pipe Class for the DataFlow Architectural Design.
 * -------------------------------------------------------------------------
 * Basic Functionality - 
 * to transfer/buffer data and sync active neighbours.
 * ------------------------------------------------------------------------- 
 * Non-functional functions -
 * Pipe class is easily expandable, by just adding the 
 * desired Data Type and the required constructor, setter and getter func.
 * For example, the 'int' and 'String' datatype has been added.
 * -------------------------------------------------------------------------
 * @author Bay Chuan Wei Candiie A0112898U
 * -------------------------------------------------------------------------
 */
public class Pipe {

	int intValue;
	String strValue;
	
	String[] arrValue;
	LinkedList<String> linkedListValue;
			
	//Constructors
	public Pipe () {
		intValue = 0;
		strValue = "";
		arrValue = null;
		linkedListValue = null;
	}
	
	
	//Setters
	public void setIntValue (int inVal)	{
		intValue = inVal;
	}
	
	public void setStrValue (String inVal)	{
		strValue = inVal;
	}
	
	public void setArrValue (String[] inVal)	{
		arrValue = inVal;
	}
	
	public void setLinkedListValue (LinkedList<String> inVal)	{
		linkedListValue = inVal;
	}
	
	
	//Getters
	public int getIntValue ()	{
		return intValue;
	}
	
	public String getStrValue ()	{
		return strValue;
	}
	
	public String[] getArrValue ()	{
		return arrValue;
	}
	
	public LinkedList<String> getLinkedListValue ()	{
		return linkedListValue;
	}
	
}
