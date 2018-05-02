
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.AbstractMap.SimpleEntry;
/* Generated By:JJTree: Do not edit this line. ASTStmtlst.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTStmtlst extends SimpleNode {
  public ASTStmtlst(int id) {
    super(id);
  }

  public ASTStmtlst(Parser p, int id) {
    super(p, id);
  }

  @Override
  public SimpleEntry<Boolean,Boolean> createAndCheckSymbol(SymbolTable parent) {
    Boolean allCorrect = true;
    for(int i=0; i<this.jjtGetNumChildren(); i++) {
      try {
        if(this.jjtGetChild(i).createAndCheckSymbol(parent).getKey() == false)
          allCorrect=false;
      }catch(ParseException e) {
        System.out.println(e.getMessage());
        allCorrect = false;
      }
    
    }
    return new SimpleEntry<>(allCorrect, null);
  }

  @Override
  public int setRegistry(FunctionTable parent, int registry) {
    int reg = registry;

    for (int i = 0; i < children.length; i++) {
      reg = children[i].setRegistry(parent, reg);
    }

    return reg;

  }

  public ArrayList getJVMCode(FunctionTable parent, ArrayList instList) {
    ArrayList instructions = instList;

    for (int i = 0; i < children.length; i++) {
      instructions = children[i].getJVMCode(parent, instructions);
    }

    return instructions;

  }


  

}
/* JavaCC - OriginalChecksum=ffd35f7c1211e909898eab0efdf3baf6 (do not edit this line) */
