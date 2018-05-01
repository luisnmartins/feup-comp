import java.util.AbstractMap.SimpleEntry;

/* Generated By:JJTree: Do not edit this line. ASTArraySize.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTArraySize extends SimpleNode {

  public Boolean isSize = false;
  public String sizeVar;
  public Integer size;
  public Boolean isDeclaration = false;

  public ASTArraySize(int id) {
    super(id);
  }

  public ASTArraySize(Parser p, int id) {
    super(p, id);
  }

  // ArraySize( [variable.size] ) or ArraySize( [variable] ) or ArrraySize( [number] )
  @Override
  public String toString(String prefix) {
    if (isSize) {
      return prefix + " " + toString() + " ( [" + this.sizeVar + ".size] )";
    } else if (this.sizeVar != null) {
      return prefix + " " + toString() + " ( [" + this.sizeVar + "] ) ";
    } else {
      return prefix + " " + toString() + " ( [" + this.size + "] ) ";
    }
  }

  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {


    
    if (this.sizeVar != null) {
      Symbol sizeVariable;
      //sizeVariable doesn't exist (a = [N] but N is not defined)
      if ((sizeVariable = parent.getFromAll(this.sizeVar)) == null) {
        throw new ParseException(this, "Variable " + this.sizeVar + " doesn't exist");

        //sizeVariable is not initialized (a = [N] but N is not initialized)
      } else if (!sizeVariable.isInitialized()) {
        throw new ParseException(this, "Variable " + this.sizeVar + " is not initialized");

        //sizeVariable is not an array and it doesn't try to get his size (a =[N] but N is array)
      } else if ((sizeVariable.isArray() && !this.isSize)) {
        throw new ParseException(this, "Variable " + this.sizeVar + "can not be size of array since it is an array");

        //sizeVariable is an integer and it tries to get his size (a=[N.size] but N is integer)
      } else if ((!sizeVariable.isArray() && this.isSize)) {
        throw new ParseException(this, "Variable " + this.sizeVar + " is an integer, so it doesn't have size");

      }
    }
    return new SimpleEntry<>(true,true);
    
  }

}
/* JavaCC - OriginalChecksum=197ebed6e1f42dc9eb62527d2eedd3b8 (do not edit this line) */
