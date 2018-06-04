import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;

/* Generated By:JJTree: Do not edit this line. SimpleNode.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class SimpleNode implements Node {

  public Node parent;
  protected Node[] children;
  protected int id;
  protected Object value;
  protected Parser parser;
  protected int line;
  protected int maxStack;
  public Writer output;

  public SimpleNode(int i) {
    id = i;
  }

  public SimpleNode(Parser p, int i) {
    this(i);
    parser = p;
  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }

  public void jjtSetParent(Node n) {
    parent = n;
  }

  public Node jjtGetParent() {
    return parent;
  }

  public int getMaxStack() {
    return maxStack;
  }

  public void setMaxStack(int stack) {
    maxStack = stack;
  }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

  public Node jjtGetChild(int i) {
    return children[i];
  }

  public Node[] jjtGetChildren() {
    return children;
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  public void jjtSetValue(Object value) {
    this.value = value;
  }

  public Object jjtGetValue() {
    return value;
  }

  /*
   * You can override these two methods in subclasses of SimpleNode to customize
   * the way the node appears when the tree is dumped. If your output uses more
   * than one line you should override toString(String), otherwise overriding
   * toString() is probably all you need to do.
   */

  public String toString() {
    return ParserTreeConstants.jjtNodeName[id];
  }

  public String toString(String prefix) {
    return prefix + toString();
  }

  /*
   * Override this method if you want to customize how the node dumps out its
   * children.
   */

  public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode) children[i];
        if (n != null) {
          n.dump(prefix + " ");
        }
      }
    }
  }

  public int getId() {
    return id;
  }

  public SimpleEntry<Boolean, Boolean> createAndCheckSymbol(SymbolTable parent) throws ParseException {
    return new SimpleEntry<>(true, null);
  }

  // returns simpleEntry key -> if it has no errors; value -> if it is duplicate
  // (functions)
  public SimpleEntry<Boolean, Boolean> tableHandler(GlobalTable parent) throws ParseException {
    return new SimpleEntry<>(true, false);
  }

  public Boolean setParameter(FunctionTable parent) {
    return true;
  }

  public int setRegistry(FunctionTable parent, int registry) {
    return registry;
  };

  public int setRegistry(FunctionTable parent, FunctionTable parent2, int registry) {
    return registry;
  };

  public int setRegistry(SymbolTable parent, int registry) {
    return registry;
  };

  public void getJVMCode(FunctionTable parent) {
    return;
  }

  public void getJVMCode(FunctionTable parent, Boolean notReverse) {
    return;
  }

  public ArrayList<LinkedHashMap<String, ArrayList>> getJVMCode(GlobalTable parent,
      ArrayList<LinkedHashMap<String, ArrayList>> insts, LinkedHashMap<String, String> statics_array_sizes) {
    return insts;
  }

  public int setStackCounter(int max, int newC) {
    return (newC > max ? newC : max);
  }

  public String getConstInst(int value) {
    String res = "ldc " + value;
    if(value == -1) {
      res = "iconst_m1";
    } else if (value >= 0 && value <= 5) {
      res = "iconst_" + value;
    } else if (value >= -128 && value < 127) {
      res = "bipush " + value;
    } else if (value >= -32768 && value < 32767) {
      res = "sipush " + value;
    }

    return res;
  }

  public String getInstWihUnderscore(String inst, int reg) {
    if (reg <= 3)
      return inst + "_" + reg;
    else
      return inst + " " + reg;
  }

  public void writeToFile(String str, String module_name) {
    try {
      output = new BufferedWriter(new FileWriter("Compiled Files/" + module_name + ".j", true)); // clears file every time
      output.append(str);
      output.append('\n');
      output.close();
    } catch (IOException e) {
      // TODO: handle exception
    }

  }

  public void editLastLine(String str, String module_name) {
    try {
      List<String> fileContent = new ArrayList<>(
          Files.readAllLines(Paths.get("Compiled Files/" + module_name + ".j"), StandardCharsets.UTF_8));
      fileContent.set(fileContent.size() - 1, str);

      Files.write(Paths.get("Compiled Files/" + module_name + ".j"), fileContent, StandardCharsets.UTF_8);
    } catch (IOException e) {
      // TODO: handle exception
    }
  }

  public void editStack(String str, String oldLine, String module_name) {
    try {
      List<String> fileContent = new ArrayList<>(
          Files.readAllLines(Paths.get("Compiled Files/" + module_name + ".j"), StandardCharsets.UTF_8));

      for (int i = 0; i < fileContent.size(); i++) {
        if (fileContent.get(i).contains(oldLine)) {
          fileContent.set(i+1, str);
          break;
        }
      }

      Files.write(Paths.get("Compiled Files/" + module_name + ".j"), fileContent, StandardCharsets.UTF_8);
    } catch (IOException e) {
      // TODO: handle exception
    }
  }

  public void editLocals(String str, String oldLine, String module_name) {
    try {
      List<String> fileContent = new ArrayList<>(
          Files.readAllLines(Paths.get("Compiled Files/" + module_name + ".j"), StandardCharsets.UTF_8));

      for (int i = 0; i < fileContent.size(); i++) {
        if (fileContent.get(i).contains(oldLine)) {
          fileContent.set(i + 2, str);
          break;
        }
      }

      Files.write(Paths.get("Compiled Files/" + module_name + ".j"), fileContent, StandardCharsets.UTF_8);
    } catch (IOException e) {
      // TODO: handle exception
    }
  }

  public String getLastLine(String module_name) {
    List<String> fileContent = null;
    try {
      fileContent = new ArrayList<>(
          Files.readAllLines(Paths.get("Compiled Files/" + module_name + ".j"), StandardCharsets.UTF_8));
    } catch (IOException e) {
      // TODO: handle exception
    }
    return fileContent.get(fileContent.size() - 1).toString();
  }

  public int getCountStores(String module_name, int stack, String function_name){
    int count = 0;

    try {
      List<String> fileContent = new ArrayList<>(
          Files.readAllLines(Paths.get("Compiled Files/" + module_name + ".j"), StandardCharsets.UTF_8));

      Boolean inFunction = false;

      String function_line = ".method public static " + function_name;
      String store1 = "istore " + stack;
      String store2 = "istore_" + stack;

      for (int i = 0; i < fileContent.size(); i++) {
        if (fileContent.get(i).contains(function_line)) {
          inFunction = true;
        }else if(fileContent.get(i).contains(".end method")){
          inFunction = false;
        }else if(inFunction && (fileContent.get(i).contains(store1) || fileContent.get(i).contains(store2))){
          count++;
        }
      }
    } catch (IOException e) {
      // TODO: handle exception
    }

    return count;
  }

  public boolean canBeConst(Symbol symbol) {
    if(symbol.getValue() == null)
      return false;
    SimpleNode node = (SimpleNode) this;
    while(!(node.parent instanceof ASTFunction)) {
      if((node.parent instanceof ASTWhile) || (node.parent instanceof ASTIf) || (node.parent instanceof ASTElse)) {
        symbol.setValue(null);
        return false;
      }
      node = (SimpleNode) node.parent;
    }
    return true;
  }
}

/*
 * JavaCC - OriginalChecksum=379452f9e91f8d0b5fc594df77c60eba (do not edit this
 * line)
 */
