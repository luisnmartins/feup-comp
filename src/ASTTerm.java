import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

/* Generated By:JJTree: Do not edit this line. ASTTerm.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTTerm extends SimpleNode {

  public String operation = null; 
  public Integer value = null;

  public ASTTerm(int id) {
    super(id);
  }

  public ASTTerm(Parser p, int id) {
    super(p, id);
  }

  public String getValueSigned() {
    if (operation != null && value != null)
      return "" + this.operation + this.value;
    else if (value != null && operation == null)
      return "" + this.value;
    else
      return "";
  }


  //Term(+/-value) or Term(value) ex: Term(-100) or Term(100)
  @Override
  public String toString(String prefix) { 
    
    if(operation != null  && value != null)
      return prefix + " " + toString() +" ( "+ this.operation + this.value+" )";
    else if(value != null)
      return prefix + " " + toString() +" ( "+ this.value+" )";
    else
     return prefix + " " + toString();
  }

  @Override
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException{
    if(this.jjtGetNumChildren() > 0) {
      return this.jjtGetChild(0).createAndCheckSymbol(parent);
    }
    return new SimpleEntry<>(true, false);
  }

  public ArrayList getJVMCode(FunctionTable parent, ArrayList instList) {
    ArrayList instructions = instList;

    String value_str = getValueSigned();
    
    if (value_str != "") {
      int valueInt = Integer.parseInt(value_str);
      instructions.add(getConstInst(valueInt));
      setMaxStack(1);
    } else {
      instructions = this.jjtGetChild(0).getJVMCode(parent, instList);
      setMaxStack(this.jjtGetChild(0).getMaxStack());
    }

    System.out.println("TERM MAX: " + getMaxStack());    

    return instructions;

  }

}
/* JavaCC - OriginalChecksum=e6ec0e95745f8f6c69fa849f6df483ea (do not edit this line) */
