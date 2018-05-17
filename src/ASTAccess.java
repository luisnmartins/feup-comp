import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

import javax.sound.midi.SysexMessage;

/* Generated By:JJTree: Do not edit this line. ASTAccess.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTAccess extends SimpleNode {

  public String name;
  public Boolean isSize = false; // Variable that checks if it is has an arrayAccess, and if it does, ".size" is
                                 // added to the string

  public ASTAccess(int id) {
    super(id);
  }

  public ASTAccess(Parser p, int id) {
    super(p, id);
  }

  // Access(variable.size) or Access(variable)
  @Override
  public String toString(String prefix) {
    if (isSize) {
      return prefix + " " + toString() + " ( " + this.name + ".size ) ";
    } else {
      return prefix + " " + toString() + " ( " + this.name + " ) ";
    }
  }

  @Override
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {
    boolean hasIndex = false;
    for (int i = 0; i < jjtGetNumChildren(); i++) {
      hasIndex = true;
      if (!jjtGetChild(i).createAndCheckSymbol(parent).getKey()) {
        return new SimpleEntry<>(false, null);
      }

    }
    Symbol access;
    if ((access = parent.getFromAll(name)) == null) {
      throw new ParseException(this, "Variable " + name + " doesn't exist");
    } else {
      if (!access.isInitialized()) {
        throw new ParseException(this, "Variable " + name + " insn't initialized");
      }

      if (hasIndex && !access.isArray()) {
        throw new ParseException(this, "Can't access variable " + name + " with an index since it is not an array");
      }

      if (isSize && !access.isArray()) {
        throw new ParseException(this, "Can't get variable " + name + " size since it is not an array");
      }

    }
    if (hasIndex || isSize)
      return new SimpleEntry<>(true, false);
    else
      return new SimpleEntry<>(true, access.isArray());
  }

  @Override
  public int setRegistry(FunctionTable parent, int registry) {
    int reg = registry;
    Symbol symbol = parent.hasRegistry(name);
    System.out.println("Access name " + name);
    if (symbol != null) {
      symbol.setRegistry(reg);
      reg++;
    } else {
      SimpleEntry<String, Symbol> symbolEntry = parent.getReturnParameter();
      if (symbolEntry != null && !parent.getRetHasReg()) {
        if(parent.isClone){
          System.out.println("I'm CLONE");
        }else{
          System.out.println("I'm NOT CLONE");
        }
        symbol = symbolEntry.getValue();
        if (!symbol.isRegistered()) {
          symbol.setRegistry(reg);
          reg++;

        }
      }
    }

    return reg;

  }

  public ArrayList getJVMCode(FunctionTable parent, ArrayList instList) {
    ArrayList instructions = instList;

    String module_name = parent.getParent().getModuleName();

    Symbol symbol = parent.getFromScope(name);
    Boolean accessGlobal = false;
    if (symbol == null) {
      accessGlobal = true;
      symbol = parent.getFromAll(name);
    }

    if (this.jjtGetNumChildren() > 0) {
      // x = a[2];
      if (accessGlobal)
        instructions.add("getstatic " + module_name + "/" + name + " [I");
      else
        instructions.add("aload " + symbol.getRegistry());

      instructions = jjtGetChild(0).getJVMCode(parent, instructions);

      instructions.add("iaload");

    } else {

      if (symbol.isArray()) {
        // a = [10]; b = a; ou x = a.size;

        if (isSize) {
          // x = a.size;

          if (accessGlobal) {
            instructions.add("getstatic " + module_name + "/" + name + " [I");
          } else {
            instructions.add("aload " + symbol.getRegistry());
          }
          instructions.add("arraylength");

        } else {

          // a = [10]; b = a;

        }

      } else {
        // x = a;

        if (accessGlobal)
          instructions.add("getstatic " + module_name + "/" + name + " I");
        else
          instructions.add("iload " + symbol.getRegistry());
        // countStack = setStackCounter(countStack, 1);

      }

    }

    return instructions;

  }
}
/*
 * JavaCC - OriginalChecksum=4ba1678d017435dc0581d9f0bda7fe02 (do not edit this
 * line)
 */
