import java.util.ArrayList;

/* Generated By:JJTree: Do not edit this line. ASTArgument.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTArgument extends SimpleNode {

  public String value;
  public boolean isID=false;

  public ASTArgument(int id) {
    super(id);
  }

  public ASTArgument(Parser p, int id) {
    super(p, id);
  }
  
  //Argument ( value )
  @Override
  public String toString(String prefix) {
    return prefix + " " + toString()+ " ( "+ this.value+ " -> isID:  " + this.isID +" )";
  } 

  public ArrayList getJVMCode(FunctionTable parent, ArrayList instList) {
    ArrayList instructions = instList;

    String module_name = parent.getParent().getModuleName();

    Symbol symbol = parent.getFromAll(value);

    if (symbol != null) {
      Boolean argGlobal = false;
      if (parent.getFromScope(value) == null)
        argGlobal = true;
      if (!symbol.isArray())
        if (argGlobal)
          instructions.add("getstatic " + module_name + "/" + value + " I");
        else
          instructions.add("iload " + symbol.getRegistry());
    } else {
      try {
        int valueInt = Integer.parseInt(value);
        instructions.add("bipush " + valueInt);
      } catch (Exception e) {
        instructions.add("ldc " + value);
      }
    }

    return instructions;

  }

  public String getFuncParams(FunctionTable parent) {
    String newFuncParams = "";
    Symbol symbol = parent.getFromAll(value);

    if (symbol != null) {
      if (symbol.isArray())
        newFuncParams += "[I";
      else {
        newFuncParams += "I";
      }
    } else {
      try {
        Integer.parseInt(value);
        newFuncParams += "I";

      } catch (Exception e) {
        newFuncParams += "Ljava/lang/String;";

      }
    }

    return newFuncParams;
  }

}
/* JavaCC - OriginalChecksum=8bdabdf4b7f89add12350809cf11e15d (do not edit this line) */
