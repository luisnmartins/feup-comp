package parser;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
/* Generated By:JJTree: Do not edit this line. ASTElse.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTElse extends SimpleNode {
  public ASTElse(int id) {
    super(id);
  }

  public ASTElse(Parser p, int id) {
    super(p, id);
  }

  @Override
  public SimpleEntry<Boolean,Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {
    boolean allCorrect = true;

    for (int i = 0; i < this.jjtGetNumChildren(); i++){
      if(this.jjtGetChild(i).createAndCheckSymbol(parent).getKey() == false){
        allCorrect = false;
      }
    }
    return new SimpleEntry<>(allCorrect,null);
  }

  @Override
  public int setRegistry(FunctionTable parent, int registry) {
    int reg = registry;

    if (jjtGetNumChildren() == 0)
      return reg;
      
    for (int i = 0; i < children.length; i++) {
      reg = children[i].setRegistry(parent, reg);
    }

    return reg;

  }

  public void getJVMCode(FunctionTable parent) {

    this.jjtGetChild(0).getJVMCode(parent);

    setMaxStack(this.jjtGetChild(0).getMaxStack());
    return;

  }


}
/* JavaCC - OriginalChecksum=42ca64cb610de9331eb67819a27fb9be (do not edit this line) */