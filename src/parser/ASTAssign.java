package parser;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import table.*;

/* Generated By:JJTree: Do not edit this line. ASTAssign.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTAssign extends SimpleNode {

  public ASTAssign(int id) {
    super(id);
  }

  public ASTAssign(Parser p, int id) {
    super(p, id);
  }

  // Assign ( = )
  @Override
  public String toString(String prefix) {
    return prefix + " " + toString() + " ( = ) ";
  }

  @Override
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {

    ASTAccess leftSide = (ASTAccess) this.jjtGetChild(0);
    Symbol newVar = parent.getFromAll(leftSide.name);
    Boolean isLeftArray = false;
    Boolean isIndex = false;
    if (leftSide.jjtGetNumChildren() > 0) {
      if (!leftSide.jjtGetChild(0).createAndCheckSymbol(parent).getKey()) {
        return new SimpleEntry<>(false, null);
      }
      isIndex = true;
      isLeftArray = false;
    } else {
      if (newVar != null)
        isLeftArray = newVar.isArray();
    }

    if (leftSide.isSize) {
      throw new ParseException(this, "It is not possible to change array size");
    }

    if (this.jjtGetChild(1) != null) {

      SimpleEntry<Boolean, Boolean> rhs = null;
      try {
        rhs = this.jjtGetChild(1).createAndCheckSymbol(parent);
      } catch (ParseException e) {
        System.out.println(e.getMessage());
        return new SimpleEntry<>(false, null);
      }
      if (rhs.getKey() == false) {
        return new SimpleEntry<>(false, null);
      } else {
        if (rhs.getValue() == null) {
          throw new ParseException(this,
              "Variable " + leftSide.name + " will not be assigned according to the right side");

        }
        if (newVar != null) {

          if (isLeftArray) {
            if (!rhs.getValue() && (!newVar.isInitialized() || newVar.getMayBeUninitialized())) {
              throw new ParseException(this,
                  "Array " + leftSide.name + " can't be filled since it has no size specified");

            }
            newVar.setInitialized(true);

          } else {
            if (isLeftArray != rhs.getValue()) {
              throw new ParseException(this,
                  "Variable " + leftSide.name + " is not compatible with the right side value");
            }
            // a; a=[100];
            if ((!newVar.isInitialized() || newVar.getMayBeUninitialized()) && rhs.getValue()) {
              throw new ParseException(this, "Variable " + leftSide.name + "can not be initialized as an array");

            }
            // Freshly added
            if (isIndex && (!newVar.isInitialized() || newVar.getMayBeUninitialized())) {
              throw new ParseException(this,
                  "Can't access variable " + leftSide.name + " with an index since it is not an array");
            }
            newVar.setInitialized(true);

          }

        } else {

          if (isIndex) {
            throw new ParseException(this,
                "Can't access variable " + leftSide.name + " with an index since it is not an array");

          }
          Symbol addedVariable = parent.pushVariable(leftSide.name, rhs.getValue(), true);

        }
      }
    }

    return new SimpleEntry<>(true, null);
  }

  @Override
  public int setRegistry(FunctionTable parent, int registry) {
    int reg = registry;

    reg = this.jjtGetChild(0).setRegistry(parent, reg);

    return reg;

  }

  public void getJVMCode(FunctionTable parent) {
    ASTAccess access = (ASTAccess) this.jjtGetChild(0);

    String module_name = parent.getParent().getModuleName();

    Symbol symbol = parent.getFromScope(access.name);

    Boolean accessGlobal = false;

    int maxStack = 0;

    if (symbol == null) {
      accessGlobal = true;
      symbol = parent.getFromAll(access.name);
    }

    if (symbol.isArray()) {
      if (access.jjtGetNumChildren() > 0) {

        int maxReg = parent.getMaxRegistry();
        maxReg++;

        parent.setMaxRegistry(maxReg);

        // a[...] = ...

        if (accessGlobal)
          writeToFile("getstatic " + module_name + "/" + access.name + " [I");
        else
          writeToFile(getInstWihUnderscore("aload", symbol.getRegistry()));

        // METER AKI O INDEX
        access.jjtGetChild(0).getJVMCode(parent);

        this.jjtGetChild(1).getJVMCode(parent);

        maxStack = this.jjtGetChild(1).getMaxStack();

        maxStack = maxStack + 2;

        writeToFile("iastore");
        writeToFile("");

        maxStack = setStackCounter(maxStack, 3);

      } else {

        if ((this.jjtGetChild(1).jjtGetNumChildren() == 1 && this.jjtGetChild(1).jjtGetChild(0) instanceof ASTArraySize)
            || access.isSize) {

          this.jjtGetChild(1).getJVMCode(parent);

          maxStack = this.jjtGetChild(1).getMaxStack();
          // a = [2]; ou a.size = [2]
          if (accessGlobal)
            writeToFile("putstatic " + module_name + "/" + access.name + " [I");
          else
            writeToFile(getInstWihUnderscore("astore", symbol.getRegistry()));

          writeToFile("");

          maxStack = setStackCounter(maxStack, 1);

        } else {
          int maxReg = parent.getMaxRegistry();
          int value = 0;

          Boolean rhs_access_is_array = false;
          Boolean accessRhsGlobal = false;
          Symbol rhs_access_symbol = null;
          ASTAccess rhs_access = null;

          Boolean toGo = false;

          this.jjtGetChild(1).getJVMCode(parent);

          maxStack = this.jjtGetChild(1).getMaxStack();

          if (this.jjtGetChild(1).jjtGetChild(0).jjtGetNumChildren() > 0) {
            // array = algo sem ser integer

            if (this.jjtGetChild(1).jjtGetChild(0).jjtGetChild(0) instanceof ASTAccess) {
              rhs_access = (ASTAccess) this.jjtGetChild(1).jjtGetChild(0).jjtGetChild(0);
              rhs_access_symbol = parent.getFromScope(rhs_access.name);

              if (rhs_access_symbol == null) {
                accessRhsGlobal = true;
                rhs_access_symbol = parent.getFromAll(rhs_access.name);
              }

              if (rhs_access_symbol.isArray()) {
                rhs_access_is_array = true;
              }
            } else if (this.jjtGetChild(1).jjtGetChild(0).jjtGetChild(0) instanceof ASTCall) {

              if (accessGlobal)
                writeToFile("putstatic " + module_name + "/" + access.name + " [I");
              else
                writeToFile(getInstWihUnderscore("astore", symbol.getRegistry()));

              toGo = true;

            }
          }

          if (!toGo) {
            if (rhs_access_is_array) {

              if (accessRhsGlobal) {
                writeToFile("getstatic " + module_name + "/" + rhs_access.name + " [I");
              } else {
                writeToFile(getInstWihUnderscore("aload", symbol.getRegistry()));
              }

              if (accessGlobal)
                writeToFile("putstatic " + module_name + "/" + access.name + " [I");
              else
                writeToFile(getInstWihUnderscore("astore", symbol.getRegistry()));

              maxStack = setStackCounter(maxStack, 1);

            } else {

              maxReg++;
              // a = value, logo fill the array

              value = maxReg;
              writeToFile(getInstWihUnderscore("istore", value));

              if (accessGlobal) {
                writeToFile("getstatic " + module_name + "/" + access.name + " [I");
              } else {
                writeToFile(getInstWihUnderscore("aload", symbol.getRegistry()));
              }
              writeToFile("arraylength");

              maxReg++;

              int size = maxReg;

              maxReg++;

              int iterator = maxReg;

              parent.setMaxRegistry(maxReg);

              int loopCount = parent.getParent().getLoopCount();

              writeToFile(getInstWihUnderscore("istore", size));
              writeToFile("iconst_0");
              writeToFile(getInstWihUnderscore("istore", iterator)); // cria variavel para o iterador do
                                                                                  // loop , de
              // inicializacao

              writeToFile("loop" + loopCount + ":");

              writeToFile(getInstWihUnderscore("iload", iterator));
              writeToFile(getInstWihUnderscore("iload", size));

              writeToFile("if_icmpge loop_end" + loopCount);

              if (accessGlobal) {
                writeToFile("getstatic " + module_name + "/" + access.name + " [I");
              } else {
                writeToFile(getInstWihUnderscore("aload", symbol.getRegistry()));
              }
              writeToFile(getInstWihUnderscore("iload", iterator));

              writeToFile(getInstWihUnderscore("iload", value));

              writeToFile("iastore");

              writeToFile("iinc " + iterator + " 1");

              writeToFile("goto loop" + loopCount);

              writeToFile("loop_end" + loopCount + ":");

              writeToFile("");

              maxStack = setStackCounter(maxStack, 3);

              parent.getParent().incLoopCount();

            }
          }

        }

      }

    } else {
      ASTRhs rhs = (ASTRhs) this.jjtGetChild(1);
      rhs.getJVMCode(parent);
      if(this.canBeAssigned(symbol)){
        symbol.setValue(rhs.value);
      }
      

      maxStack = rhs.getMaxStack();

      if(!rhs.is_iinc){
      
        if (accessGlobal)
          writeToFile("putstatic " + module_name + "/" + access.name + " I");
        else
          writeToFile(getInstWihUnderscore("istore", symbol.getRegistry()));

        writeToFile("");
      }
      

      
    }

    maxStack = setStackCounter(maxStack, 1);

    setMaxStack(maxStack);

    return;
  }

}
/*
 * JavaCC - OriginalChecksum=707623fe908a83fd2745ed78935babb9 (do not edit this
 * line)
 */
