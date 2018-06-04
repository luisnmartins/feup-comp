import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

/* Generated By:JJTree: Do not edit this line. ASTRhs.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTRhs extends SimpleNode {

  public String operator = null;
  public Integer value = null;

  public ASTRhs(int id) {
    super(id);
  }

  public ASTRhs(Parser p, int id) {
    super(p, id);
  }

  // Rhs(+/-/*..)
  @Override
  public String toString(String prefix) {
    if (this.operator != null)
      return prefix + " " + toString() + " ( " + this.operator + " )";
    else
      return prefix + " " + toString();
  }

  @Override
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {

    Boolean allCorrect = true;
    SimpleEntry<Boolean, Boolean> response = new SimpleEntry<>(true, false);
    for (int i = 0; i < this.jjtGetNumChildren(); i++) {
      try {
        response = this.jjtGetChild(i).createAndCheckSymbol(parent);
      } catch (ParseException e) {
        allCorrect = false;
        response = new SimpleEntry<>(false, false);
        System.out.println(e.getMessage());
      }
      if (operator != null) {
        if (response.getValue() == null) {
          throw new ParseException(this, "The function does not return a value");
        } else if (response.getValue() == true) {
          throw new ParseException(this, "Is not possible to operate with arrays");
        }

      }
    }
    if (allCorrect == false)
      return new SimpleEntry<>(false, null);
    else
      return new SimpleEntry<>(true, response.getValue());
  }

  public void getJVMCode(FunctionTable parent) {

    String module_name = parent.getParent().getModuleName();

    if (children.length == 1) {
      ASTTerm term;
      if (this.jjtGetChild(0) instanceof ASTTerm) {
        term = (ASTTerm) this.jjtGetChild(0);
        value = term.value;
      }

      this.jjtGetChild(0).getJVMCode(parent);

      setMaxStack(this.jjtGetChild(0).getMaxStack());

      // se foi call entao no pai verifica e se foi entao é + 1, senao é o maximo d
      // ste

    } else {

      Integer opera = 0;
      Boolean constFold = false;
      Integer t1 = null;
      Integer t2 = null;

      if (YAL.optimized) {
        if (this.jjtGetChild(0) instanceof ASTTerm) {
          ASTTerm term = (ASTTerm) this.jjtGetChild(0);
          if (term.value != null) {
            t1 = term.value;
          } else if (term.jjtGetChild(0) instanceof ASTAccess) {
            ASTAccess access = (ASTAccess) term.jjtGetChild(0);
            Symbol symbol = parent.getFromScope(access.name);
            if (canBeConst(symbol)) {
              t1 = symbol.getValue();
            }
          }
        }

        if (t1 != null) {
          if (this.jjtGetChild(1) instanceof ASTTerm) {
            ASTTerm term = (ASTTerm) this.jjtGetChild(1);
            if (term.value != null) {
              t2 = term.value;
            } else if (term.jjtGetChild(0) instanceof ASTAccess) {
              ASTAccess access = (ASTAccess) term.jjtGetChild(0);
              Symbol symbol = parent.getFromScope(access.name);
              if (canBeConst(symbol)) {
                t2 = symbol.getValue();
              }
            }
          }
        }

        if (t1 != null && t2 != null) {
          opera = makeOperation(operator, t1, t2);
          constFold = true;
        }
      }

      if (constFold) {
        writeToFile(getConstInst(opera), module_name);
        setMaxStack(1); // como é uma soma tem sempre o maximo dos dois mais um
      } else {

        int maxStack = 0;

        Boolean is_iinc = false;

        ASTAccess access = (ASTAccess) this.parent.jjtGetChild(0);
        ASTAccess rhs_access = null;
        ASTTerm second_term = null;
        if (this.jjtGetChild(0).jjtGetNumChildren() > 0) {
          if (this.jjtGetChild(0).jjtGetChild(0) instanceof ASTAccess) {
            rhs_access = (ASTAccess) this.jjtGetChild(0).jjtGetChild(0);
            if (access.name == rhs_access.name) {
              second_term = (ASTTerm) this.jjtGetChild(1);
              is_iinc = true;
            }
          }
        }

        if (!is_iinc && this.jjtGetChild(1).jjtGetNumChildren() > 1) {
          if (this.jjtGetChild(1).jjtGetChild(0) instanceof ASTAccess) {
            rhs_access = (ASTAccess) this.jjtGetChild(1).jjtGetChild(0);
            if (access.name == rhs_access.name) {
              second_term = (ASTTerm) this.jjtGetChild(0);
              is_iinc = true;
            }
          }
        }

        if (is_iinc) {
          if (second_term.jjtGetNumChildren() == 0) {
            Symbol symbol = parent.getFromScope(rhs_access.name);

            if (symbol != null) {
              writeToFile("iinc " + symbol.getRegistry() + " " + second_term.value, module_name);
              maxStack = setStackCounter(maxStack, 1);
            }

          }
        } else {
          for (int m = 0; m < 2; m++) {
            this.jjtGetChild(m).getJVMCode(parent);
            maxStack = setStackCounter(maxStack, this.jjtGetChild(m).getMaxStack());
          }
        }

        setMaxStack(maxStack + 1); // como é uma soma tem sempre o maximo dos dois mais um

        writeToFile(getOperation(operator), module_name);
      }

    }

    return;

  }

  public String getOperation(String op) {
    switch (op) {
    case "+":
      return "iadd";
    case "-":
      return "isub";
    case "*":
      return "imul";
    case "/":
      return "idiv";
    case "<<":
      return "ishl";
    case ">>":
      return "ishr";
    case ">>>":
      return "iushr";
    case "&":
      return "iand";
    case "|":
      return "ior";
    case "^":
      return "ixor";
    default:
      return "";
    }
  }

  public Integer makeOperation(String op, int t1, int t2) {
    switch (op) {
    case "+":
      return t1 + t2;
    case "-":
      return t1 - t2;
    case "*":
      return t1 * t2;
    case "/":
      return t1 / t2;
    case "<<":
      return t1 << t2;
    case ">>":
      return t1 >> t2;
    case ">>>":
      return t1 >>> t2;
    case "&":
      return t1 & t2;
    case "|":
      return t1 | t2;
    case "^":
      return t1 ^ t2;
    default:
      return 0;
    }
  }

}
/*
 * JavaCC - OriginalChecksum=243722291f580c9eef839a742207993d (do not edit this
 * line)
 */
