import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;

/* Generated By:JJTree: Do not edit this line. ASTdeclarationValue.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTDeclarationValue extends SimpleNode {

  public String signal = null;
  public Integer value = null;

  public ASTDeclarationValue(int id) {
    super(id);
  }

  public ASTDeclarationValue(Parser p, int id) {
    super(p, id);
  }

  public String getValueSigned() {
    if (signal != null && value != null)
      return "" + this.signal + this.value;
    else if (value != null && signal == null)
      return "" + this.value;
    else
      return "";
  }

  // DeclarationValue(+/- value)
  @Override
  public String toString(String prefix) {

    if (signal != null && value != null)
      return prefix + " " + toString() + " ( " + this.signal + this.value + " )";
    else if (value != null && signal == null)
      return prefix + " " + toString() + " ( " + this.value + " )";
    else
      return prefix + " " + toString();
  }

  @Override
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {

    ASTElement element = (ASTElement) this.parent.jjtGetChild(0);
    ;
    String declarationVariableName = element.name;
    Boolean elementIsArray = element.isArray;

    Symbol declaration = parent.lookupVariable(declarationVariableName);

    // VERIFICATION: to check if a[] =1;
    if (declaration == null) {

      if (elementIsArray) {
        elementIsArray = false;
      }
      // if variable is not defined push it
      parent.pushVariable(declarationVariableName, elementIsArray, true);

    } else {

      // VERIFICATION: new element is a declaration value but already exists an
      // uninitialized array with the same name (a[]; a=3;)
      if (declaration.isArray() && !declaration.isInitialized()) {
        throw new ParseException(this, "Declaration Array " + declarationVariableName + " has not size specified");
      }

      if (elementIsArray == declaration.isArray()) {
        declaration.setInitialized(true);
      }

      // VERIFICATION: check if new variable is not array while there's another
      // variable already defined as int
      if (elementIsArray != declaration.isArray() && declaration.isArray() == false) {
        throw new ParseException(this,
            "Declaration Variable " + declarationVariableName + " already exists as a diferent type");
      }
    }
    return new SimpleEntry<>(true, false);

  }

  public ArrayList<LinkedHashMap<String, ArrayList>> getJVMCode(GlobalTable parent,
      ArrayList<LinkedHashMap<String, ArrayList>> insts, LinkedHashMap<String, String> statics_array_sizes) {
    ASTElement element = (ASTElement) this.parent.jjtGetChild(0);
    String elemName = element.name;
    ArrayList<LinkedHashMap<String, ArrayList>> instructions = insts;

    String module_name = parent.getModuleName();

    Boolean setDec = false;
    if (instructions.get(1).get(elemName) == null)
      setDec = true;
    Symbol symbol = parent.getFromAll(elemName);
    String dec = ".field static " + elemName;

    String value = getValueSigned();

    int dec_locals_counter = ((ArrayList<Integer>) instructions.get(3).get("counters")).get(0);

    if (symbol.isArray()) {

      String arr_size = statics_array_sizes.get(elemName);
      if (arr_size != null) {
        if (value != null) {

          ArrayList staticInsts = new ArrayList<>();

          for (String key : instructions.get(1).keySet()) {
            ArrayList lis = instructions.get(1).get(key);
            for (int i = 0; i < lis.size(); i++) {
              staticInsts.add(lis.get(i).toString());
              // System.out.println(lis.get(i));
            }
          }

          ArrayList staList = instructions.get(1).get(elemName);
          staList.addAll(initializeArray(dec_locals_counter, arr_size, value, module_name, elemName, staticInsts));
          // dec_stack_counter = setStackCounter(dec_stack_counter, 3);

          dec_locals_counter += 2;

          instructions.get(1).put(elemName, staList);

        }
        dec += " [I ";
      } else {
        dec += " I ";

        if (value != "") {
          dec += "= " + value;
        }

      }
    } else {
      dec += " I ";
      if (value != "") {
        dec += "= " + value;
      }
    }

    if (setDec) {
      instructions.get(0).get("declarations").add(dec);
    }

    instructions.get(3).get("counters").set(0, dec_locals_counter);

    return instructions;

  }

  public ArrayList initializeArray(int reg, String arr_size, String value, String module_name, String name,
      ArrayList insts) {
    int size = reg;
    reg++;
    int iterator = reg;
    reg++;

    ArrayList ret = new ArrayList<>();
    try {
      Integer.parseInt(arr_size);
      ret.add("ldc " + arr_size);
    } catch (Exception e) {
      if (arr_size.contains("arraylength")) {
        String sizeVar = arr_size.substring(11, arr_size.length());
        ret.add("getstatic " + module_name + "/" + sizeVar + " [I");
        ret.add("arraylength");
      } else
        ret.add("getstatic " + module_name + "/" + arr_size + " I");
    }

    int loopCount = getLoopCount(insts);

    ret.add("istore " + size); // cria variavel para o size do ArrayList
    ret.add("iconst_0");
    ret.add("istore " + iterator); // cria variavel para o iterador do loop de inicializacao

    ret.add("loop" + loopCount + ":");

    ret.add("iload " + iterator);
    ret.add("iload " + size);

    ret.add("if_icmpge loop_end" + loopCount);

    ret.add("getstatic " + module_name + "/" + name + " [I");
    ret.add("iload " + iterator);
    ret.add("ldc " + value);
    ret.add("iastore");

    ret.add("iinc " + iterator + " 1");

    ret.add("goto loop" + loopCount);

    ret.add("loop_end" + loopCount + ":");

    ret.add("");

    return ret;
  }

}
/*
 * JavaCC - OriginalChecksum=f6252d80a18ca6058cc57a45c8f379c8 (do not edit this
 * line)
 */
