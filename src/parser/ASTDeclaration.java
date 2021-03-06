package parser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;
import table.*;

/* Generated By:JJTree: Do not edit this line. ASTDeclaration.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTDeclaration extends SimpleNode {

  public ASTDeclaration(int id) {
    super(id);
  }

  public ASTDeclaration(Parser p, int id) {
    super(p, id);
  }

  public SimpleEntry<Boolean,Boolean> tableHandler(GlobalTable parent) throws ParseException{
    
    ASTElement element = (ASTElement) this.jjtGetChild(0);
    String globalVariableName = element.name;
    Boolean elementIsArray = element.isArray;

    Symbol lhsDecS = parent.lookupVariable(globalVariableName);

    //has assign
    if (this.jjtGetNumChildren() > 1) {

        //declaration Value
        SimpleEntry<Boolean, Boolean> rhsDec = null;
        try {
          rhsDec = this.jjtGetChild(1).createAndCheckSymbol(parent);
        } catch(ParseException e) {
          return new SimpleEntry<>(false,false);
        }
        if(!rhsDec.getKey())
          return new SimpleEntry<>(false,false);
        else {
          if(lhsDecS != null) {
            if(lhsDecS.isArray()) {
              //a = [100]; a = [20]; 
              if(rhsDec.getValue() && lhsDecS.isInitialized()) {
                throw new ParseException(this, "Array " + globalVariableName + " has already a size specified");

              } 
              //a[]; a=2;
              else if(!rhsDec.getValue() && !lhsDecS.isInitialized()) {
                new ParseException(this, "Array " + globalVariableName + " can't be filled since it has no size specified");
              }
              lhsDecS.setInitialized(true);

            } else {
              //a=2; a=3;
              if(lhsDecS.isInitialized()) {
                throw new ParseException(this, "Variable " + globalVariableName + " is already initialized");

              } else {
                
                //a; a=[100];
                if(rhsDec.getValue()) {
                  throw new ParseException(this, "Variable "+globalVariableName + "can not be initialized as an array");
                }
                lhsDecS.setInitialized(true);
              }
            }
          }else{
            parent.pushVariable(globalVariableName,rhsDec.getValue(),true);
          }
        }

    } else {
      if(lhsDecS != null){
        throw new ParseException(this, "Global Variable "+globalVariableName+ " is already defined");
      }else{
        parent.pushVariable(globalVariableName, elementIsArray, !elementIsArray);
      }
    }
    return new SimpleEntry<>(true,false);

  }

  public ArrayList<LinkedHashMap<String, ArrayList>> getJVMCode(GlobalTable parent,
      ArrayList<LinkedHashMap<String, ArrayList>> insts, LinkedHashMap<String, String> statics_array_sizes) {
    ASTElement element = (ASTElement) this.jjtGetChild(0);
    String elemName = element.name;
    ArrayList<LinkedHashMap<String, ArrayList>> instructions = insts;

    Boolean setDec = false;
    if (instructions.get(1).get(elemName) == null)
      setDec = true;
    Symbol symbol = parent.getFromAll(elemName);
    String dec = "";
    

    if (this.jjtGetNumChildren() > 1) {
      instructions = this.jjtGetChild(1).getJVMCode(parent, instructions, statics_array_sizes);

    } else {
      dec = ".field static " + elemName;
      if (symbol.isArray())
        dec += " [I";
      else
        dec += " I";
    }

    if (setDec) {
      instructions.get(0).get("declarations").add(dec);
    }

    return instructions;

  }

}
/* JavaCC - OriginalChecksum=8a2f666ee6fc5230f43f9fe71f26bf80 (do not edit this line) */
