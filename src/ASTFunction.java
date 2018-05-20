import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;

/* Generated By:JJTree: Do not edit this line. ASTFunction.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTFunction extends SimpleNode {

  public String name;
  public String returnValue;
  public Boolean returnArray = false;

  public ASTFunction(int id) {
    super(id);
  }

  public ASTFunction(Parser p, int id) {
    super(p, id);
  }

  // returnValue = Function(name) or returnValue[] = Function(name) or
  // Function(name)
  @Override
  public String toString(String prefix) {
    if (returnValue != null) {
      if (!returnArray)
        return prefix + " " + this.returnValue + " = " + toString() + " " + this.name;
      else
        return prefix + " " + this.returnValue + "[] = " + toString() + " " + this.name;
    } else
      return prefix + " " + toString() + " " + this.name;
  }

  @Override
  public SimpleEntry<Boolean, Boolean> tableHandler(GlobalTable parent) throws ParseException {

    // create function table setting return and parameters
    if (parent.getFunction(name) != null) {
      throw new ParseException(this, "Function " + name + " already exists");

    }
    FunctionTable newFunction = new FunctionTable(parent);
    parent.addFunction(name, newFunction);

    if (this.returnValue != null) {
      newFunction.setReturnParameter(this.returnValue, this.returnArray, false);
    }
    for (int i = 0; i < this.jjtGetChildren().length; i++) {

      if (!this.jjtGetChild(i).setParameter(newFunction)) {
        throw new ParseException(this, "Function " + name + " states parameters with same name");
      }
    }

    return new SimpleEntry<>(true, false);
  }

  @Override
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {
    boolean allCorrect = true;
    FunctionTable table = parent.getFunction(name);
    for (int k = 0; k < this.jjtGetNumChildren(); k++) {
      try {
        if (this.jjtGetChild(k).createAndCheckSymbol(table).getKey() == false) {
          allCorrect = false;
        }
      } catch (ParseException e) {
        allCorrect = false;
        System.out.println(e.getMessage());
      }

    }

    if (returnValue != null) {
      Symbol returnVar;
      if ((returnVar = table.getFromScope(returnValue)) != null) {
        if (returnVar.isArray() != returnArray || !returnVar.isInitialized()) {
          throw new ParseException(this, "Function " + name + " return variable " + returnValue
              + " is not initialized or it has a different type in the function scope");
        }
      } else {
        throw new ParseException(this,
            "Function " + name + " return variable " + returnValue + " doesn't exist in the function scope");
      }
    }

    return new SimpleEntry<>(allCorrect, null);
  }

  @Override
  public int setRegistry(SymbolTable parent, int registry) {
    FunctionTable table = parent.getFunction(name);
    int reg = registry;

    // if (name.compareTo("main") == 0)
    //   reg = 1;

    LinkedHashMap<String, Symbol> parameters = table.getParameters();

    for (Symbol symbol : parameters.values()) {
      symbol.setRegistry(reg);
      reg++;
    }

    for (int i = 0; i < children.length; i++) {
      reg = children[i].setRegistry(table, reg);
    }

    if (name.compareTo("main") != 0)
      reg--;

    table.setMaxRegistry(reg);

    return reg;

  }

  public ArrayList<LinkedHashMap<String, ArrayList>> getJVMCode(GlobalTable parent,
      ArrayList<LinkedHashMap<String, ArrayList>> insts, LinkedHashMap<String, String> statics_array_sizes) {
    ArrayList<LinkedHashMap<String, ArrayList>> instructions = insts;
    FunctionTable table = parent.getFunction(name);

    LinkedHashMap<String, Symbol> parameters = table.getParameters();

    String funcParams = "";

    for (Symbol symbol : parameters.values()) {
      if (symbol.isArray())
        funcParams += "[I";
      else
        funcParams += "I";
    }

    String returnType;

    if (returnValue != null)
      if (returnArray)
        returnType = "[I";
      else
        returnType = "I";
    else
      returnType = "V";

    ArrayList funcList = new ArrayList<>();

    ArrayList instList = new ArrayList<>();

    int maxStack = 0;

    for (int i = 0; i < children.length; i++) {
      instList = children[i].getJVMCode(table, instList);

      maxStack = setStackCounter(maxStack, children[i].getMaxStack());
    }

    if (returnValue != null)
      if (returnArray) {

      } else {
        String retKey = table.getReturnParameter().getKey();
        Symbol ret = table.getFromAll(retKey);

        instList.add("iload " + ret.getRegistry());
        instList.add("ireturn");

      }
    else
      instList.add("return");

    if (name.compareTo("main") == 0)
      funcList.add(".method public static " + name + "([Ljava/lang/String;" + funcParams + ")V");
    else {
      funcList.add(".method public static " + name + "(" + funcParams + ")" + returnType);
    }

    funcList.add(".limit stack " + 100);
    funcList.add(".limit locals " + (table.getMaxRegistry() + 1));

    funcList.add("");

    instList.add(".end method");

    instList.add("");

    funcList.addAll(instList);

    instructions.get(2).put(name, funcList);

    return instructions;
  }

}
/*
 * JavaCC - OriginalChecksum=bf1f69df336eb61ec8c115404ea52b68 (do not edit this
 * line)
 */
