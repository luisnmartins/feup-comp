import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

/* Generated By:JJTree: Do not edit this line. ASTRhs.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTRhs extends SimpleNode {

  public String operator = null;

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
      if (operator != null && response.getValue() == true) {
        throw new ParseException(this, "Is not possible to operate with arrays");
      }
    }
    if (allCorrect == false)
      return new SimpleEntry<>(false, null);
    else
      return new SimpleEntry<>(true, response.getValue());
  }

  public ArrayList getJVMCode(FunctionTable parent, ArrayList instList) {
    ArrayList instructions = instList;

    if (children.length == 1) {

      instructions = this.jjtGetChild(0).getJVMCode(parent, instructions);

      setMaxStack(this.jjtGetChild(0).getMaxStack());

      // se foi call entao no pai verifica e se foi entao é + 1, senao é o maximo d
      // ste

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
            instructions.add("iinc " + symbol.getRegistry() + " " + second_term.value);
            maxStack = setStackCounter(maxStack, 1);
          }

        }
      } else {
        for (int m = 0; m < 2; m++) {
          instructions = this.jjtGetChild(m).getJVMCode(parent, instructions);
          maxStack = setStackCounter(maxStack, this.jjtGetChild(m).getMaxStack());
        }
      }

      setMaxStack(maxStack + 1); // como é uma soma tem sempre o maximo dos dois mais um

      instList.add(getOperation(operator));

    }

    System.out.println("RHS MAX: " + getMaxStack());

    return instructions;

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

}
/*
 * JavaCC - OriginalChecksum=243722291f580c9eef839a742207993d (do not edit this
 * line)
 */
