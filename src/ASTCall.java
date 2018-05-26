import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

/* Generated By:JJTree: Do not edit this line. ASTCall.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTCall extends SimpleNode {

  public Boolean isCaller = false;
  public String name;
  public String functionCalled;

  public ASTCall(int id) {
    super(id);
  }

  public ASTCall(Parser p, int id) {
    super(p, id);
  }

  // Call(name.function) or Call(name) ex: Call(io.println) or Call(test)
  @Override
  public String toString(String prefix) {
    if (isCaller) {
      return prefix + " " + toString() + " ( " + this.name + "." + this.functionCalled + " )";
    } else {
      return prefix + " " + toString() + " ( " + this.name + " ) ";
    }
  }

  @Override
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {
    if (this.functionCalled == null) {
      FunctionTable called = parent.getFunction(this.name);
      if (called == null) {
        throw new ParseException(this, "Function " + name + " doesn't exist in the current module");
      }

      LinkedHashMap<String, Symbol> params = called.getParameters();
      if (params.size() != this.jjtGetNumChildren()) {
        throw new ParseException(this, "Function '" + name + "' received wrong number of parameters: " + "expected-"
            + params.size() + ", received-" + this.jjtGetNumChildren());

      }

      int i = 0;
      for (Symbol symbol : params.values()) {
        ASTArgument arg = (ASTArgument) this.jjtGetChild(i);

        if (arg.isID) {
          Symbol entrySymbol;
          if ((entrySymbol = parent.getFromAll(arg.value)) == null) {
            throw new ParseException(this, "There was a problem calling function '" + name + "' on the parameter '"
                + arg.value + "':does not exist");

          } else {
            if (!entrySymbol.isInitialized() || entrySymbol.isArray() != symbol.isArray() || entrySymbol.getMayBeUninitialized()) {
              throw new ParseException(this, "There was a problem calling function '" + name + "' on the parameter '"
                  + arg.value + "':wrong type or not initialized");
            }

          }

        } else {
          if (symbol.isArray()) {
            throw new ParseException(this,
                "There was a problem calling function " + name + ":expected array received " + arg.value);

          }

        }
        i++;
      }
      if (called.getReturnParameter() != null)
        return new SimpleEntry<>(true, called.getReturnParameter().getValue().isArray());
      else
        return new SimpleEntry<>(true, null);

    } else {
      for (int i = 0; i < this.jjtGetNumChildren(); i++) {
        ASTArgument arg = (ASTArgument) this.jjtGetChild(i);
        Symbol entrySymbol;
        if (arg.isID && ((entrySymbol = parent.getFromAll(arg.value)) == null || !entrySymbol.isInitialized() || entrySymbol.getMayBeUninitialized())) {
          throw new ParseException(this, "There was a problem calling function '" + functionCalled
              + "' on the parameter '" + arg.value + "':wrong type or not initialized");
        }
      }
      return new SimpleEntry<>(true, false);

    }
  }

  public void getJVMCode(FunctionTable parent) {

    String module_name = parent.getParent().getModuleName();

    String newFuncParams = "";

    if (this.jjtGetNumChildren() > 0) {
      for (int i = 0; i < children.length; i++) {
        ASTArgument arg = (ASTArgument) children[i];
        newFuncParams += arg.getFuncParams(parent);
        children[i].getJVMCode(parent);
      }
      setMaxStack(this.jjtGetNumChildren());
    }


    

    // countStack = setStackCounter(countStack, children.length);

    String caller;
    String funcName;
    Symbol ret = null;
    FunctionTable funcT;
    if (isCaller) {
      funcName = functionCalled;
      caller = name + "/" + functionCalled;
    } else {
      funcName = name;
      caller = module_name + "/" + name;
    }

    funcT = parent.getFunction(funcName);
    if (funcT != null) {
      SimpleEntry<String, Symbol> newRet = funcT.getReturnParameter();
      if (newRet != null) {
        ret = newRet.getValue();
      }
    }

    

    String returnT = "V";

    if (ret != null){
      if (ret.isArray())
        returnT = "[I";
      else
        returnT = "I";
    }else {
      if (this.parent instanceof ASTStmtlst) {
        returnT = "V";
      } else {
        String access_name = ((ASTAccess) this.parent.jjtGetParent().jjtGetParent().jjtGetChild(0)).name;
        Symbol symbol = parent.getFromScope(access_name);

        if(symbol == null){
          symbol = parent.getFromAll(access_name);
        }

        if(symbol.isArray())
          returnT = "[I";
        else
          returnT = "I";


      }
    }

    writeToFile("invokestatic " + caller + "(" + newFuncParams + ")" + returnT, module_name);
    if (this.parent instanceof ASTStmtlst)
      if (returnT != "V")
        writeToFile("pop", module_name);
    writeToFile("", module_name);

    return;
  }

}
/*
 * JavaCC - OriginalChecksum=97d7dc0ee32d2a3f6c51396e54d445f7 (do not edit this
 * line)
 */
