package parser;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import table.*;

/* Generated By:JJTree: Do not edit this line. ASTIndex.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTIndex extends SimpleNode {

  public Boolean isInt = false;
  public String value;

  public ASTIndex(int id) {
    super(id);
  }

  public ASTIndex(Parser p, int id) {
    super(p, id);
  }

  // Index([postion])
  @Override
  public String toString(String prefix) {
    return prefix + " " + toString() + " ( [" + value + "] ) ";
  }

  @Override
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {
    if (isInt == false) {
      Symbol index;
      if ((index = parent.getFromAll(value)) == null) {
        throw new ParseException(this, "Index variable " + value + " doesn't exist ");
        // return new SimpleEntry<>(false,false);
      }
      if (!index.isInitialized() || index.isArray() || index.getMayBeUninitialized()) {
        throw new ParseException(this, "Index variable " + value + " is not initialized or it is not of a valid type");
      } else
        return new SimpleEntry<>(true, false);
    }
    return new SimpleEntry<>(true, false);
  }

  public void getJVMCode(FunctionTable parent) {

    String module_name = parent.getParent().getModuleName();

    

    if (isInt) {
      int valueInt = Integer.parseInt(value);
      writeToFile(getConstInst(valueInt));
    } else {
      Symbol symbol = parent.getFromScope(value);

      Boolean accessGlobal = false;

      if (symbol == null) {
        accessGlobal = true;
        symbol = parent.getFromAll(value);
      }

      if (accessGlobal) {
        writeToFile("getstatic " + module_name + "/" + value + " I");
      } else {
        if(this.canBeConst(symbol)) {
          writeToFile(getConstInst(symbol.getValue()));
        }
        else
          writeToFile(getInstWihUnderscore("iload", symbol.getRegistry()));
      }

    }

    setMaxStack(1);


    return;
  }

}
/*
 * JavaCC - OriginalChecksum=56589e597f8a053ddc34724fc985dc24 (do not edit this
 * line)
 */
