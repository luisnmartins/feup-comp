package parser;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

/* Generated By:JJTree: Do not edit this line. ASTIf.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTIf extends SimpleNode {
  FunctionTable variablesIf;
  FunctionTable variablesElse;

  public ASTIf(int id) {
    super(id);
  }

  public ASTIf(Parser p, int id) {
    super(p, id);
  }

  @Override
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {
    boolean allCorrect = true;
    Boolean isElse = false;
    Stack<SymbolTable> symbolStack = new Stack<>();
    SymbolTable toPass = null;
    // if create table
    try {
      toPass = parent.clone();
      symbolStack.push(toPass);
    } catch (CloneNotSupportedException e) {
      e.getMessage();
    }

    variablesIf = (FunctionTable) toPass;
    variablesIf.setisClone(true);

    for (int i = 0; i < this.jjtGetNumChildren(); i++) {
      if (this.jjtGetChild(i) instanceof ASTElse) {
        try {
          toPass = parent.clone();
          symbolStack.push(toPass);
          isElse = true;
        } catch (CloneNotSupportedException e) {
          e.getMessage();
        }
        variablesElse = (FunctionTable) toPass;
        variablesElse.setisClone(true);
      }
      if (this.jjtGetChild(i).createAndCheckSymbol(toPass).getKey() == false) {
        allCorrect = false;
      }
      if (isElse) {
        try {
          mergeSymbolTables(symbolStack, parent);
          parent.print();
        }catch(ParseException e) {
          System.out.println(e.getMessage());
          allCorrect = false;
        }
      }
    }
    if(!isElse) {
      mergeIf(symbolStack.pop(), parent);
    }

    return new SimpleEntry<>(allCorrect, null);
  }

  public void mergeSymbolTables(Stack<SymbolTable> symbols, SymbolTable parent) throws ParseException{

    FunctionTable elseTable = (FunctionTable) symbols.pop();
    FunctionTable ifTable = (FunctionTable) symbols.pop();

    LinkedHashMap<String, Symbol> ifVariables = ifTable.getVariables();
    Symbol tempVariable;
    for (Map.Entry<String, Symbol> entry : ifVariables.entrySet()) {
      parent.pushVariable(entry.getKey(), entry.getValue());
      if ((tempVariable = elseTable.lookupVariable(entry.getKey())) != null) {
        if(!tempVariable.equals(entry.getValue())) {
          throw new ParseException("Variable " + entry.getKey() + " can not be reasigned as a different type in else statement");
        }
      } else {
        entry.getValue().setMayBeUninitialized(true);
      }
    }
    LinkedHashMap<String, Symbol> elseVariables = elseTable.getVariables();
    for (Map.Entry<String, Symbol> entry : elseVariables.entrySet()) {
      if ((tempVariable = ifTable.lookupVariable(entry.getKey())) == null) {
        parent.pushVariable(entry.getKey(), entry.getValue());
        entry.getValue().setMayBeUninitialized(true);
      }
    }
    SimpleEntry<String, Symbol> finalReturn = elseTable.getReturnParameter();
    if (ifTable.getReturnParameter() != null && finalReturn != null) {
      if (finalReturn.getValue().equals(ifTable.getReturnParameter().getValue())) {
        parent.setReturnParameter(finalReturn);
      }
    }

  }

  public void mergeIf(SymbolTable ifTable, SymbolTable parent) {
    LinkedHashMap<String, Symbol> ifVariables = ifTable.getVariables();
    for (Map.Entry<String, Symbol> entry : ifVariables.entrySet()) {
      if ((parent.lookupVariable(entry.getKey())) == null) {
        parent.pushVariable(entry.getKey(), entry.getValue());
        entry.getValue().setMayBeUninitialized(true);
      }
    }
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
    String module_name = parent.getParent().getModuleName();
    
    int ifCount = parent.getParent().getIfCount();
    parent.getParent().incIfCount();
    Boolean hasElse = false;
    if (this.jjtGetNumChildren() == 3)
      hasElse = true;

    this.jjtGetChild(0).getJVMCode(parent);

    String op = getLastLine(module_name);
    if (hasElse)
      editLastLine(op + " if_else" + ifCount, module_name);
    else
      editLastLine(op + " if_end" + ifCount, module_name);

    writeToFile("", module_name);

    int maxStack = this.jjtGetChild(0).getMaxStack();

    this.jjtGetChild(1).getJVMCode(parent);

    maxStack = setStackCounter(maxStack, this.jjtGetChild(1).getMaxStack());

    if (hasElse) {
      writeToFile("goto if_end" + ifCount, module_name);
      writeToFile("", module_name);
      writeToFile("if_else" + ifCount + ":", module_name);

      this.jjtGetChild(2).getJVMCode(parent);

      maxStack = setStackCounter(maxStack, this.jjtGetChild(2).getMaxStack());

    }

    setMaxStack(maxStack);

    writeToFile("if_end" + ifCount + ":", module_name);

    writeToFile("", module_name);

    

    return;

  }

}
/*
 * JavaCC - OriginalChecksum=4f68923b47f767356ea2837b579bfe29 (do not edit this
 * line)
 */