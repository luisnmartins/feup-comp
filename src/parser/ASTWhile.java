package parser;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import table.*;

/* Generated By:JJTree: Do not edit this line. ASTWhile.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTWhile extends SimpleNode {
  FunctionTable variablesWhile;

  public ASTWhile(int id) {
    super(id);
  }

  public ASTWhile(Parser p, int id) {
    super(p, id);
  }

  @Override
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {
    boolean allCorrect = true;
    SymbolTable newParent = null;

    try {
      newParent = parent.clone();
    } catch (CloneNotSupportedException e) {
      e.getMessage();
    }

    variablesWhile = (FunctionTable) newParent;
    variablesWhile.setisClone(true);

    for (int i = 0; i < this.jjtGetNumChildren(); i++) {
      if (this.jjtGetChild(i).createAndCheckSymbol(newParent).getKey() == false) {
        allCorrect = false;
      }
    }
    return new SimpleEntry<>(allCorrect, null);
  }

  @Override
  public int setRegistry(FunctionTable parent, int registry) {
    int reg = registry;

    Boolean retHasReg = false;
    if (parent.getReturnParameter() != null)
      if (parent.getReturnParameter().getValue().getRegistry() != null || parent.getRetHasReg())
        retHasReg = true;

    variablesWhile.setRetHasReg(retHasReg);

    if (jjtGetNumChildren() == 0)
      return reg;
    

    for (int i = 0; i < children.length; i++) {
      reg = children[i].setRegistry(variablesWhile, reg);
    }

    return reg;

  }

  public void getJVMCode(FunctionTable parent) {

    if(YAL.optimized){
      makeOptimizedWhile(parent);
      return;
    }
    int loopCount = parent.getParent().getLoopCount();
    parent.getParent().incLoopCount();
    variablesWhile.setParent(parent.getParent());

    String module_name = parent.getParent().getModuleName();

    writeToFile("loop" + loopCount + ":");

    writeToFile("");

    this.jjtGetChild(0).getJVMCode(parent);

    String op = getLastLine();
    editLastLine(op + " loop_end" + loopCount);

    variablesWhile.setMaxRegistry(parent.getMaxRegistry());

    int maxStack = this.jjtGetChild(0).getMaxStack();

    if (variablesWhile.getReturnParameter() != null) {
      if (variablesWhile.getReturnParameter().getValue().getRegistry() == null)
        variablesWhile.getReturnParameter().getValue()
            .setRegistry(parent.getReturnParameter().getValue().getRegistry());
    }

    this.jjtGetChild(1).getJVMCode(variablesWhile);


    maxStack = setStackCounter(maxStack, this.jjtGetChild(1).getMaxStack());

    setMaxStack(maxStack);


    parent.setMaxRegistry(variablesWhile.getMaxRegistry());

    


    writeToFile("goto loop" + loopCount);

    writeToFile("loop_end" + loopCount + ":");

    

    return;

  }

  private void makeOptimizedWhile(FunctionTable parent){
    
    int loopCount = parent.getParent().getLoopCount();
    parent.getParent().incLoopCount();
    variablesWhile.setParent(parent.getParent());
   
    String module_name = parent.getParent().getModuleName();

    this.jjtGetChild(0).getJVMCode(parent);

    String op = getLastLine();
    editLastLine(op + " loop_end" + loopCount);

    writeToFile("loop" + loopCount + ":");

    writeToFile("");

    variablesWhile.setMaxRegistry(parent.getMaxRegistry());

    int maxStack = this.jjtGetChild(0).getMaxStack();

    if (variablesWhile.getReturnParameter() != null) {
      if (variablesWhile.getReturnParameter().getValue().getRegistry() == null)
        variablesWhile.getReturnParameter().getValue()
            .setRegistry(parent.getReturnParameter().getValue().getRegistry());
    }

    this.jjtGetChild(1).getJVMCode(variablesWhile);

    maxStack = setStackCounter(maxStack, this.jjtGetChild(1).getMaxStack());

    setMaxStack(maxStack);

    parent.setMaxRegistry(variablesWhile.getMaxRegistry());

    this.jjtGetChild(0).getJVMCode(parent, true);

    op = getLastLine();
    editLastLine(op + " loop" + loopCount);

    writeToFile("loop_end" + loopCount + ":");

    return;
  }

}
/*
 * JavaCC - OriginalChecksum=6da5aeac38e50f236962e83070b4bc22 (do not edit this
 * line)
 */
