package parser;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import table.*;

/* Generated By:JJTree: Do not edit this line. ASTExprtest.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTExprtest extends SimpleNode {

  public String operator;

  public ASTExprtest(int id) {
    super(id);
  }

  public ASTExprtest(Parser p, int id) {
    super(p, id);
  }

  // Exprtest(</>/>>/<<..)
  @Override
  public String toString(String prefix) {
    return prefix + " " + toString() + " ( " + this.operator + " )";
  }

  @Override
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {

    ASTAccess leftSide = (ASTAccess) this.jjtGetChild(0);
    SimpleEntry<Boolean, Boolean> lhs = this.jjtGetChild(0).createAndCheckSymbol(parent);
    Symbol newVar = parent.getFromAll(leftSide.name);

    if (lhs.getKey() == false) {
      return new SimpleEntry<>(false, null);
    }

    if (this.jjtGetChild(1) != null) {
      SimpleEntry<Boolean, Boolean> rhs = this.jjtGetChild(1).createAndCheckSymbol(parent);
      if (rhs.getKey() == false) {
        return new SimpleEntry<>(false, null);
      } else {
        if (rhs.getValue() != false) {
          throw new ParseException(this, "Can only compare integers");

        }
        if (newVar != null) {

          if (!newVar.isInitialized() || newVar.getMayBeUninitialized()) {
            throw new ParseException(this, "Variable " + leftSide.name + " is not initialized!");

          }
          if (lhs.getValue()) {
            throw new ParseException(this, "Variable " + leftSide.name + " is an array can't be compared");
          }

        }
      }
    }

    return new SimpleEntry<>(true, null);
  }

  public void getJVMCode(FunctionTable parent) {

    String module_name = parent.getParent().getModuleName();

    if (jjtGetNumChildren() == 0)
      return;

    int maxStack = 0;

    for (int i = 0; i < children.length; i++) {
      children[i].getJVMCode(parent);

      maxStack = setStackCounter(maxStack, children[i].getMaxStack() + 1);

    }    

    maxStack = setStackCounter(maxStack, 2); //No minimo sao 2!

    setMaxStack(maxStack);


    writeToFile(getOperationReverse(operator));

    return;
  }

  public String getOperationReverse(String op) {
    switch (op) {
    case ">":
      return "if_icmple";
    case "<":
      return "if_icmpge";
    case "<=":
      return "if_icmpgt";
    case ">=":
      return "if_icmplt ";
    case "==":
      return "if_icmpne";
    case "!=":
      return "if_icmpeq";
    default:
      return "";
    }
  }

  public void getJVMCode(FunctionTable parent, Boolean notReverse) {

    String module_name = parent.getParent().getModuleName();

    if (jjtGetNumChildren() == 0)
      return;

    int maxStack = 0;

    for (int i = 0; i < children.length; i++) {
      children[i].getJVMCode(parent);

      maxStack = setStackCounter(maxStack, children[i].getMaxStack() + 1);

    }

    maxStack = setStackCounter(maxStack, 2); // No minimo sao 2!

    setMaxStack(maxStack);

    if(notReverse)
      writeToFile(getOperation(operator));

    return;
  }

  public String getOperation(String op) {
    switch (op) {
    case ">":
      return "if_icmpgt";
    case "<":
      return "if_icmplt";
    case "<=":
      return "if_icmple";
    case ">=":
      return "if_icmpge ";
    case "==":
      return "if_icmpeq";
    case "!=":
      return "if_icmpne";
    default:
      return "";
    }
  }

}
/*
 * JavaCC - OriginalChecksum=583babd77beef46dab385c625b5ec4a0 (do not edit this
 * line)
 */
