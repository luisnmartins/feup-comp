package parser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;
import table.*;

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

  // ArraySize( [variable.size] ) or ArraySize( [variable] ) or ArrraySize(
  // [number] )
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
      // sizeVariable doesn't exist (a = [N] but N is not defined)
      if ((sizeVariable = parent.getFromAll(this.sizeVar)) == null) {
        throw new ParseException(this, "Variable " + this.sizeVar + " doesn't exist");

        // sizeVariable is not initialized (a = [N] but N is not initialized)
      } else if (!sizeVariable.isInitialized() || sizeVariable.getMayBeUninitialized()) {
        throw new ParseException(this, "Variable " + this.sizeVar + " is not initialized");

        // sizeVariable is not an array and it doesn't try to get his size (a =[N] but N
        // is array)
      } else if ((sizeVariable.isArray() && !this.isSize)) {
        throw new ParseException(this, "Variable " + this.sizeVar + "can not be size of array since it is an array");

        // sizeVariable is an integer and it tries to get his size (a=[N.size] but N is
        // integer)
      } else if ((!sizeVariable.isArray() && this.isSize)) {
        throw new ParseException(this, "Variable " + this.sizeVar + " is an integer, so it doesn't have size");

      }
    }
    return new SimpleEntry<>(true, true);

  }

  public void getJVMCode(FunctionTable parent) {
    String module_name = parent.getParent().getModuleName();

    Symbol symbol = parent.getFromScope(sizeVar);

    Boolean accessGlobal = false;

    if (symbol == null) {
      accessGlobal = true;
      symbol = parent.getFromAll(sizeVar);
    }

    if (isSize) {
      if (accessGlobal) {
        writeToFile("getstatic " + module_name + "/" + sizeVar + " [I");
      } else {
        writeToFile(getInstWihUnderscore("aload", symbol.getRegistry()));
      }
      writeToFile("arraylength");
    } else if (sizeVar != null) {
      if (accessGlobal) {
        writeToFile("getstatic " + module_name + "/" + sizeVar + " I");
      } else {
        writeToFile(getInstWihUnderscore("iload", symbol.getRegistry()));
      }
    } else {
      writeToFile(getConstInst(size));
    }

    writeToFile("newarray int");

    setMaxStack(1);



    return;
  }

  public ArrayList<LinkedHashMap<String, ArrayList>> getJVMCode(GlobalTable parent,
      ArrayList<LinkedHashMap<String, ArrayList>> insts, LinkedHashMap<String, String> statics_array_sizes) {
    ASTElement element = (ASTElement) this.parent.jjtGetChild(0);
    String elemName = element.name;
    ArrayList<LinkedHashMap<String, ArrayList>> instructions = insts;
    LinkedHashMap<String, String> array_sizes = statics_array_sizes;

    String module_name = parent.getModuleName();

    String dec = ".field static " + elemName;

    int dec_locals_counter = ((ArrayList<Integer>) instructions.get(3).get("counters")).get(0);

    ArrayList staList = new ArrayList<>();
    if (isSize) {
      staList.add("getstatic " + module_name + "/" + sizeVar + " [I");
      staList.add("arraylength");
      String sizeStr = "arraylength" + sizeVar;      
      array_sizes.put(elemName, sizeStr);
    } else if (sizeVar != null) {
      staList.add("getstatic " + module_name + "/" + sizeVar + " I");
      array_sizes.put(elemName, sizeVar);
    } else {

        staList.add(getConstInst(size));
      array_sizes.put(elemName, "" + size);

    }

    staList.add("newarray int");
    staList.add("putstatic " + module_name + "/" + element.name + " [I");
    staList.add("");
    instructions.get(1).put(elemName, staList);

    dec_locals_counter++;

    instructions.get(3).get("counters").set(0, dec_locals_counter);

    int maxStack = ((ArrayList<Integer>) instructions.get(3).get("counters")).get(1);

    maxStack = setStackCounter(maxStack, 1);

    instructions.get(3).get("counters").set(1, maxStack);



    // dec_stack_counter = setStackCounter(dec_stack_counter, 2);

    dec += " [I ";

    instructions.get(0).get("declarations").add(dec);

    return instructions;

  }


}
/*
 * JavaCC - OriginalChecksum=197ebed6e1f42dc9eb62527d2eedd3b8 (do not edit this
 * line)
 */
