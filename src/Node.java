/* Generated By:JJTree: Do not edit this line. Node.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
/* All AST nodes must implement this interface.  It provides basic
   machinery for constructing the parent and child relationships
   between nodes. */
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public
interface Node {

  /** This method is called after the node has been made the current
    node.  It indicates that child nodes can now be added to it. */
  public void jjtOpen();

  /** This method is called after all the child nodes have been
    added. */
  public void jjtClose();

  /** This pair of methods are used to inform the node of its
    parent. */
  public void jjtSetParent(Node n);
  public Node jjtGetParent();

  /** This method tells the node to add its argument to the node's
    list of children.  */
  public void jjtAddChild(Node n, int i);

  /** This method returns a child node.  The children are numbered
     from zero, left to right. */
  public Node jjtGetChild(int i);

  public Node[] jjtGetChildren();

  /** Return the number of children the node has. */
  public int jjtGetNumChildren();

  public int getId();

  //if it worked and if it is an array
  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException;

  public SimpleEntry<Boolean,Boolean> tableHandler(GlobalTable parent) throws ParseException;

  public Boolean setParameter(FunctionTable parent);

  public int setRegistry(FunctionTable parent, int registry);

  public int setRegistry(FunctionTable parent, FunctionTable parent2, int registry);

  public int setRegistry(SymbolTable parent, int registry);

  public int setStackCounter(int max, int newC);

  public ArrayList<LinkedHashMap<String, ArrayList>> getJVMCode(GlobalTable parent,
      ArrayList<LinkedHashMap<String, ArrayList>> insts, LinkedHashMap<String, String> statics_array_sizes);

  public ArrayList getJVMCode(FunctionTable parent, ArrayList instList);

  public int getMaxStack();

  public void setMaxStack(int stack);

  public String getConstInst(int value);

  public String getInstWihUnderscore(String inst, int reg);

  public void writeToFile(String str, String module_name);

  public void editLastLine(String str, String module_name);

  public void editLocals(String str, String oldLine, String module_name);

  public void editStack(String str, String oldLine, String module_name);

  public String getLastLine(String module_name);
}
/* JavaCC - OriginalChecksum=f321f02c1d43b87914acea48d856de05 (do not edit this line) */
